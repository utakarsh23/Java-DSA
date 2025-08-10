package Trees;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

/**
 * InteractiveBSTVisualizer with:
 * - 3D shading & glow + shifting gradient background
 * - Branch growth animation + leaf pop on new nodes
 * - Click to highlight path root -> node
 * - Search animation showing traversal
 * - Smooth spring physics, subtree dragging that sticks where dropped
 *
 * Single-file runnable. Drop into InteractiveBSTVisualizer.java and run.
 */
public class InteractiveBSTVisualizer extends JPanel {

    // --- Node model ---
    static class Node {
        int value;
        Node left, right;
        // Animated / layout state
        double x, y;   // current displayed pos
        double tx, ty; // target pos
        double vx, vy; // velocity
        double scale = 1.0; // pop-in/breathing
        double wigglePhase;
        long createdAt = System.currentTimeMillis();

        Node(int v) {
            this.value = v;
            wigglePhase = Math.random() * Math.PI * 2;
        }
    }

    // Edge animation for branch growth
    static class EdgeAnim {
        Node parent, child;
        double progress; // 0..1
        boolean leafSpawned = false;
        EdgeAnim(Node p, Node c) { parent = p; child = c; progress = 0.0; }
    }

    // Leaf animation (small pop near child node)
    static class LeafAnim {
        Node node;
        double t = 0.0; // 0..1 life
        LeafAnim(Node n) { node = n; t = 0.0; }
    }

    private Node root = null;
    private Node draggedNode = null;
    private Node hoveredNode = null;
    private Node selectedNode = null;

    private int offsetX = 0, offsetY = 0;

    private final int BASE_RADIUS = 26;
    private final double SPRING_K = 0.10;
    private final double DAMP = 0.84;
    private final double POP_SPEED = 0.09;
    private final double WIGGLE_AMPL = 1.6;

    private final javax.swing.Timer animator;
    private final List<EdgeAnim> edgeAnims = new ArrayList<>();
    private final List<LeafAnim> leafAnims = new ArrayList<>();

    // Search animation state
    private List<Node> searchVisitOrder = null;
    private int searchStep = 0;
    private javax.swing.Timer searchTimer = null;

    // UI components
    private final JTextField inputField;
    private final JButton insertBtn;
    private final JButton resetBtn;
    private final JButton searchBtn;

    // background gradient phase
    private double bgPhase = 0.0;

    public InteractiveBSTVisualizer() {
        setPreferredSize(new Dimension(1100, 820));
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setOpaque(true);

        // Bottom UI
        JPanel bottom = new JPanel(new BorderLayout(8,8));
        bottom.setOpaque(false);
        bottom.setBorder(new EmptyBorder(12,12,12,12));

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(480, 36));
        inputField.setBackground(new Color(28,28,28));
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70,70,70),1,true),
                new EmptyBorder(8,10,8,10)
        ));
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputField.setText("5,2,7,1,4,6,9,8,3,10");

        insertBtn = new JButton("Insert");
        styleButton(insertBtn, new Color(70,130,180));
        resetBtn = new JButton("Reset");
        styleButton(resetBtn, new Color(200,80,80));
        searchBtn = new JButton("Search");
        styleButton(searchBtn, new Color(120,200,140));

        JPanel rightButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT,8,0));
        rightButtons.setOpaque(false);
        rightButtons.add(insertBtn);
        rightButtons.add(searchBtn);
        rightButtons.add(resetBtn);

        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(rightButtons, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);

        // Mouse interactions
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Node n = findNodeAt(e.getX(), e.getY());
                if (n != null) {
                    draggedNode = n;
                    offsetX = e.getX() - (int)Math.round(n.x);
                    offsetY = e.getY() - (int)Math.round(n.y);
                    n.vx = n.vy = 0;
                } else {
                    // click on background clears selection
                    selectedNode = null;
                }
                repaint();
            }
            public void mouseReleased(MouseEvent e) {
                // on release keep tx/ty as-is so subtree sticks
                draggedNode = null;
            }
            public void mouseClicked(MouseEvent e) {
                Node n = findNodeAt(e.getX(), e.getY());
                if (n != null) {
                    selectedNode = n;
                    // compute path highlight (visual)
                    // (we only need to set selectedNode; draw path based on it)
                } else selectedNode = null;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (draggedNode != null) {
                    double newX = e.getX() - offsetX;
                    double newY = e.getY() - offsetY;
                    double dx = newX - draggedNode.x;
                    double dy = newY - draggedNode.y;
                    moveSubtree(draggedNode, dx, dy);
                    repaint();
                }
            }
            public void mouseMoved(MouseEvent e) {
                Node n = findNodeAt(e.getX(), e.getY());
                if (n != hoveredNode) {
                    hoveredNode = n;
                    repaint();
                }
            }
        });

        // Buttons behavior
        insertBtn.addActionListener(ev -> {
            String txt = inputField.getText().trim();
            if (!txt.isEmpty()) {
                List<Integer> vals = parseInts(txt);
                for (int v : vals) insertWithPop(v);
                relayoutTargets();
            }
        });

        resetBtn.addActionListener(ev -> {
            root = null;
            edgeAnims.clear();
            leafAnims.clear();
            repaint();
        });

        // Search action
        searchBtn.addActionListener(ev -> {
            String t = inputField.getText().trim();
            if (!t.isEmpty()) {
                try {
                    int q = Integer.parseInt(t);
                    startSearchAnimation(q);
                } catch (NumberFormatException ignored) {}
            }
        });

        inputField.addActionListener(ev -> insertBtn.doClick());

        // Resize -> relayout targets
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) { relayoutTargets(); }
        });

        // Animator timer for physics + edge/leaf progress + background
        animator = new javax.swing.Timer(16, e -> {
            stepPhysics();
            stepEdgeAnims();
            stepLeafAnims();
            bgPhase += 0.004;
            repaint();
        });
        animator.start();
    }

    private void styleButton(JButton b, Color bg) {
        b.setFocusPainted(false);
        b.setFont(new Font("Segoe UI", Font.BOLD, 13));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
    }

    // ====== Tree operations ======
    public void insert(int v) { root = insertRec(root, v); }

    private Node insertRec(Node node, int v) {
        if (node == null) return new Node(v);
        if (v < node.value) node.left = insertRec(node.left, v);
        else if (v > node.value) node.right = insertRec(node.right, v);
        return node;
    }

    // insert and pop animate edge
    public void insertWithPop(int v) {
        root = insertRecWithPop(root, v);
    }

    private Node insertRecWithPop(Node node, int v) {
        if (node == null) {
            Node n = new Node(v);
            n.x = getWidth() > 0 ? getWidth()/2.0 : 500;
            n.y = getHeight() > 0 ? getHeight()/2.0 : 300;
            n.tx = n.x; n.ty = n.y;
            n.scale = 0.01;
            n.createdAt = System.currentTimeMillis();
            return n;
        }
        if (v < node.value) {
            Node oldLeft = node.left;
            node.left = insertRecWithPop(node.left, v);
            if (oldLeft == null) addEdgeAnim(node, node.left);
        } else if (v > node.value) {
            Node oldRight = node.right;
            node.right = insertRecWithPop(node.right, v);
            if (oldRight == null) addEdgeAnim(node, node.right);
        }
        return node;
    }

    private void addEdgeAnim(Node p, Node c) {
        if (p == null || c == null) return;
        EdgeAnim ea = new EdgeAnim(p, c);
        edgeAnims.add(ea);
    }

    // ====== Layout ======
    private void relayoutTargets() {
        if (root == null) return;
        layoutTree(root, getWidth()/2, 90, Math.max(80, getWidth()/4));
    }

    private void layoutTree(Node n, int x, int y, int xOff) {
        if (n == null) return;
        n.tx = x; n.ty = y;
        if (n.left != null) layoutTree(n.left, x - xOff, y + 100, Math.max(40, xOff/2));
        if (n.right != null) layoutTree(n.right, x + xOff, y + 100, Math.max(40, xOff/2));
    }

    // ====== Edge/Leaf animation stepping ======
    private void stepEdgeAnims() {
        Iterator<EdgeAnim> it = edgeAnims.iterator();
        while (it.hasNext()) {
            EdgeAnim ea = it.next();
            ea.progress += 0.04; // growth speed
            if (ea.progress >= 1.0) {
                ea.progress = 1.0;
                if (!ea.leafSpawned) {
                    leafAnims.add(new LeafAnim(ea.child));
                    ea.leafSpawned = true;
                }
                // keep the completed anim (we might want to keep to avoid re-adding)
                // remove after a while? We'll keep small list as edges animate once.
            }
        }
    }

    private void stepLeafAnims() {
        Iterator<LeafAnim> it = leafAnims.iterator();
        while (it.hasNext()) {
            LeafAnim la = it.next();
            la.t += 0.03;
            if (la.t >= 1.0) it.remove();
        }
    }

    // ====== Physics & animation ======
    private void stepPhysics() {
        if (root == null) return;
        stepRec(root);
    }

    private void stepRec(Node n) {
        if (n == null) return;
        if (n != draggedNode) {
            double ax = (n.tx - n.x) * SPRING_K;
            double ay = (n.ty - n.y) * SPRING_K;
            n.vx = (n.vx + ax) * DAMP;
            n.vy = (n.vy + ay) * DAMP;
            n.x += n.vx;
            n.y += n.vy;
        } else {
            // ensure target follows while dragging
            n.tx = n.x; n.ty = n.y;
            n.vx = n.vy = 0;
        }
        // scale/pop
        if (n.scale < 1.0) {
            n.scale += POP_SPEED;
            if (n.scale > 1.0) n.scale = 1.0;
        } else {
            n.scale = 1.0 + 0.02 * Math.sin(System.currentTimeMillis()*0.006 + n.wigglePhase);
        }
        n.wigglePhase += 0.02;
        stepRec(n.left); stepRec(n.right);
    }

    // Move subtree by dx,dy (both current and target positions)
    private void moveSubtree(Node n, double dx, double dy) {
        if (n == null) return;
        n.x += dx; n.y += dy; n.tx += dx; n.ty += dy;
        moveSubtree(n.left, dx, dy);
        moveSubtree(n.right, dx, dy);
    }

    // ====== Search animation ======
    private void startSearchAnimation(int q) {
        if (root == null) return;
        // stop previous
        if (searchTimer != null) searchTimer.stop();
        searchVisitOrder = new ArrayList<>();
        // simulate BST search recording nodes visited
        Node cur = root;
        while (cur != null) {
            searchVisitOrder.add(cur);
            if (q == cur.value) break;
            else if (q < cur.value) cur = cur.left;
            else cur = cur.right;
        }
        searchStep = 0;
        searchTimer = new javax.swing.Timer(420, e -> {
            if (searchStep < searchVisitOrder.size()) {
                hoveredNode = searchVisitOrder.get(searchStep);
                // also set a tiny glow by bumping scale slightly
                hoveredNode.scale = Math.max(hoveredNode.scale, 1.08);
                searchStep++;
                repaint();
            } else {
                // finished; highlight final path if value found
                if (!searchVisitOrder.isEmpty() && searchVisitOrder.get(searchVisitOrder.size()-1).value == q) {
                    selectedNode = searchVisitOrder.get(searchVisitOrder.size()-1);
                } else {
                    // not found: briefly flash root->... path via hoveredNode
                    selectedNode = null;
                }
                hoveredNode = null;
                searchTimer.stop();
                repaint();
            }
        });
        searchTimer.start();
    }

    // ====== Hit testing ======
    private Node findNodeAt(int x, int y) {
        return findAtRec(root, x, y);
    }

    private Node findAtRec(Node n, int x, int y) {
        if (n == null) return null;
        double dx = x - n.x, dy = y - n.y;
        double r = BASE_RADIUS * Math.max(0.5, n.scale) + 6;
        if (Math.hypot(dx, dy) <= r) return n;
        Node f = findAtRec(n.left, x, y);
        if (f != null) return f;
        return findAtRec(n.right, x, y);
    }

    // ====== Painting ======
    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // dynamic gradient background
        paintShiftingBackground(g);

        // edges (with growth animation)
        if (root != null) {
            drawEdgesWithGrowth(g, root);
            // draw nodes above edges
            drawNodesRec(g, root, 0);
        }

        // overlay: when selected, draw path highlight
        if (selectedNode != null) {
            drawPathHighlight(g, selectedNode);
        }

        g.dispose();
    }

    private void paintShiftingBackground(Graphics2D g) {
        int w = getWidth(), h = getHeight();
        // create two colors cycling with bgPhase
        float hue1 = (float)((Math.sin(bgPhase) * 0.1) + 0.6);
        float hue2 = (float)((Math.cos(bgPhase*1.3) * 0.12) + 0.3);
        Color c1 = Color.getHSBColor(hue1, 0.45f, 0.12f);
        Color c2 = Color.getHSBColor(hue2, 0.38f, 0.07f);
        GradientPaint gp = new GradientPaint(0,0,c1, w,h,c2);
        g.setPaint(gp);
        g.fillRect(0,0,w,h);
    }

    // Draw edges with growth animation support.
    private void drawEdgesWithGrowth(Graphics2D g, Node n) {
        if (n == null) return;
        // draw left
        if (n.left != null) {
            float alpha = 0.85f;
            EdgeAnim ea = findEdgeAnim(n, n.left);
            if (ea == null) {
                // fully drawn edge
                g.setColor(new Color(220,220,220, (int)(alpha*255)));
                g.setStroke(new BasicStroke(2.2f));
                g.drawLine((int)Math.round(n.x), (int)Math.round(n.y), (int)Math.round(n.left.x), (int)Math.round(n.left.y));
            } else {
                // partial: lerp endpoint
                Point2D p1 = new Point2D.Double(n.x, n.y);
                Point2D p2 = lerp(p1, new Point2D.Double(n.left.x, n.left.y), ea.progress);
                g.setColor(new Color(220,220,220, (int)(alpha*255)));
                g.setStroke(new BasicStroke(2.2f));
                g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
            }
            drawEdgesWithGrowth(g, n.left);
        }
        // draw right
        if (n.right != null) {
            EdgeAnim ea = findEdgeAnim(n, n.right);
            if (ea == null) {
                g.setColor(new Color(220,220,220, 220));
                g.setStroke(new BasicStroke(2.2f));
                g.drawLine((int)Math.round(n.x), (int)Math.round(n.y), (int)Math.round(n.right.x), (int)Math.round(n.right.y));
            } else {
                Point2D p1 = new Point2D.Double(n.x, n.y);
                Point2D p2 = lerp(p1, new Point2D.Double(n.right.x, n.right.y), ea.progress);
                g.setColor(new Color(220,220,220, 220));
                g.setStroke(new BasicStroke(2.2f));
                g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
            }
            drawEdgesWithGrowth(g, n.right);
        }
        // draw leafs for any completed anims near child nodes
        for (LeafAnim la : leafAnims) {
            drawLeafForNode(g, la);
        }
    }

    private EdgeAnim findEdgeAnim(Node p, Node c) {
        for (EdgeAnim ea : edgeAnims) if (ea.parent == p && ea.child == c) return ea;
        return null;
    }

    private Point2D lerp(Point2D a, Point2D b, double t) {
        return new Point2D.Double(a.getX() + (b.getX()-a.getX())*t, a.getY() + (b.getY()-a.getY())*t);
    }

    private void drawLeafForNode(Graphics2D g, LeafAnim la) {
        Node n = la.node;
        // simple green leaf that pops and fades
        double t = la.t;
        int r = (int)Math.round(BASE_RADIUS * n.scale);
        int x = (int)Math.round(n.x + r*0.7);
        int y = (int)Math.round(n.y + r*0.3);
        int size = (int)(6 + 12 * Math.sin(Math.min(1.0,t)*Math.PI));
        int alpha = (int)(255 * Math.max(0, 1.0 - t));
        g.setColor(new Color(80, 190, 100, alpha));
        g.fillOval(x-size/2, y-size/2, size, size/2 + 2);
        g.setColor(new Color(60,140,70, alpha));
        g.drawOval(x-size/2, y-size/2, size, size/2 + 2);
    }

    private void drawNodesRec(Graphics2D g, Node n, int depth) {
        if (n == null) return;
        // draw children first so parent is on top (optional)
        drawNodesRec(g, n.left, depth+1);
        drawNodesRec(g, n.right, depth+1);

        // compute draw pos with gentle wiggle
        double wig = Math.sin(n.wigglePhase + System.currentTimeMillis()*0.002) * (WIGGLE_AMPL + depth*0.12);
        int cx = (int)Math.round(n.x + wig);
        int cy = (int)Math.round(n.y);

        double s = n.scale;
        int r = (int)Math.round(BASE_RADIUS * s);

        // drop shadow
        int shadowW = (int)(r*2.4);
        int shadowH = (int)(r*0.66);
        g.setColor(new Color(0,0,0,120));
        g.fillOval(cx - shadowW/2, cy + r - shadowH/2, shadowW, shadowH);

        // base color per depth
        Color[] palette = {
                new Color(58,133,200),
                new Color(85,186,95),
                new Color(200,85,155),
                new Color(240,200,90),
                new Color(145,85,180)
        };
        Color base = palette[depth % palette.length];

        // shading: draw outer darker then inner gradient via GradientPaint
        g.setColor(base.darker().darker());
        g.fillOval(cx - r, cy - r, r*2, r*2);

        GradientPaint gp = new GradientPaint(cx - r/3f, cy - r/2f, base.brighter(),
                cx + r, cy + r, base.darker(), true);
        g.setPaint(gp);
        g.fillOval(cx - (int)(r*0.92), cy - (int)(r*0.92), (int)(r*1.84), (int)(r*1.84));

        // specular highlight
        int hx = cx - r/3;
        int hy = cy - r/3;
        g.setColor(new Color(255,255,255,220));
        g.fillOval(hx - Math.max(2,r/8), hy - Math.max(2,r/8), Math.max(4,r/4), Math.max(4,r/4));

        // outline
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2f));
        g.drawOval(cx - r, cy - r, r*2, r*2);

        // hovered / selected glow
        if (n == hoveredNode) {
            paintGlow(g, cx, cy, r, new Color(130,200,255,140));
        }
        if (n == selectedNode) {
            paintGlow(g, cx, cy, r+6, new Color(255,230,120,180));
        }

        // node value text
        g.setFont(new Font("Segoe UI", Font.BOLD, Math.max(11, (int)(12*s))));
        String txt = String.valueOf(n.value);
        FontMetrics fm = g.getFontMetrics();
        int tx = cx - fm.stringWidth(txt)/2;
        int ty = cy + fm.getAscent()/2 - 2;
        g.setColor(Color.WHITE);
        g.drawString(txt, tx, ty);
    }

    private void paintGlow(Graphics2D g, int cx, int cy, int r, Color glowColor) {
        // paint several translucent rings
        for (int k=0;k<6;k++) {
            int rr = r + 6 + k*6;
            int alpha = (int)(glowColor.getAlpha() * (1.0 - k*0.15));
            if (alpha <= 0) break;
            g.setColor(new Color(glowColor.getRed(), glowColor.getGreen(), glowColor.getBlue(), alpha));
            g.setStroke(new BasicStroke( (float)(6 - k*0.9) ));
            g.drawOval(cx - rr, cy - rr, rr*2, rr*2);
        }
    }

    // Highlight path from root to node (draw thick glowing lines)
    private void drawPathHighlight(Graphics2D g, Node node) {
        if (root == null || node == null) return;
        Node cur = root;
        g.setStroke(new BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        while (cur != null) {
            if (cur == node) break;
            Node next = (node.value < cur.value) ? cur.left : cur.right;
            if (next == null) break; // path missing (shouldn't happen)
            // draw thick glowing line from cur->next
            drawGlowingLine(g, (int)Math.round(cur.x), (int)Math.round(cur.y), (int)Math.round(next.x), (int)Math.round(next.y));
            cur = next;
        }
    }

    private void drawGlowingLine(Graphics2D g, int x1, int y1, int x2, int y2) {
        // outer glow
        g.setColor(new Color(255,220,120,80));
        for (int i=6;i>=1;i--) {
            g.setStroke(new BasicStroke(i*2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g.drawLine(x1, y1, x2, y2);
        }
        // core
        g.setColor(new Color(255,240,180,220));
        g.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.drawLine(x1,y1,x2,y2);
    }

    // ====== Utilities ======
    private List<Integer> parseInts(String txt) {
        List<Integer> out = new ArrayList<>();
        String[] parts = txt.split("[,\\s]+");
        for (String p : parts) {
            try { out.add(Integer.parseInt(p.trim())); } catch (Exception ignored) {}
        }
        return out;
    }

    // lerp
    private static double lerpD(double a, double b, double t) { return a + (b-a)*t; }

    // ====== main & helper ======
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InteractiveBSTVisualizer panel = new InteractiveBSTVisualizer();
            int[] init = {5,2,7,1,4,6,9,8,3,10};
            panel.populateFromArray(init, true);

            JFrame frame = new JFrame("Wiggly 3D BST — shiny, viney, searchable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.BLACK);
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Convenience: populate from array
    public void populateFromArray(int[] vals, boolean popAnimate) {
        root = null;
        for (int v : vals) {
            if (popAnimate) insertWithPop(v);
            else insert(v);
        }
        relayoutTargets();
    }
}