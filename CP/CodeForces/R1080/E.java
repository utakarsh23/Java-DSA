
import java.io.*;
import java.util.*;
import java.lang.*;

public class E {


    class Tree {
        Tree left;
        Tree right;
        int id;
        long dp = 0;
        long ans = 0;

        Tree(int id) {
            this.id = id;
        }
    }

    long MOD = 1000000007L;

    void solve() throws Exception {
        long t = nl();
        while (t-- > 0) {
            int n = ni();

            Map<Integer, Tree> tmap = new HashMap<>();
            for(int i = 1; i <= n; i++) {
                tmap.put(i, new Tree(i));
            }

            for (int i = 1; i <= n; i++) {
                int l = ni();
                int r = ni();
                Tree current = tmap.get(i);

                if (l != 0) {
                    current.left = tmap.get(l);
                }
                if (r != 0) {
                    current.right = tmap.get(r);
                }
            }

            Tree root = tmap.get(1);

            calcDP(root);

            calcAns(root, 0);

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                sb.append(tmap.get(i).ans).append(" ");
            }
            pn(sb.toString());
        }
        out.flush();
    }

    void calcDP(Tree tree) {
        if (tree == null) return;

        if (tree.left == null && tree.right == null) {
            tree.dp = 1;
            return;
        }

        calcDP(tree.left);
        calcDP(tree.right);

        long leftVal = (tree.left != null) ? tree.left.dp : 0;
        long rightVal = (tree.right != null) ? tree.right.dp : 0;

        tree.dp = (leftVal + rightVal + 3) % MOD;
    }

    void calcAns(Tree tree, long parentAns) {
        if (tree == null) return;

        tree.ans = (tree.dp + parentAns) % MOD;

        calcAns(tree.left, tree.ans);
        calcAns(tree.right, tree.ans);
    }
//void updateTree()


public static void main(String[] args) throws Exception {
    new E().solve();
}

FastReader in;
PrintWriter out;

E() {
in = new FastReader();
out = new PrintWriter(System.out);
    }

void p(Object o) {
    out.print(o);
}

void pn(Object o) {
    out.println(o);
}

void pni(Object o) {
    out.println(o);
    out.flush();
}

String ns() throws Exception {
    return in.next();
}

String nsln() throws Exception {
    return in.nextLine();
}

int ni() throws Exception {
    return Integer.parseInt(in.next());
}

long nl() throws Exception {
    return Long.parseLong(in.next());
}

double nd() throws Exception {
    return Double.parseDouble(in.next());
}

long[] nll(long n) throws Exception {
    long[] a = new long[(int) n];
    for (int i = 0; i < n; i++) a[i] = nl();
    return a;
}

int[] nii(int n) throws Exception {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = ni();
    return a;
}
}


class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws Exception{
        br = new BufferedReader(new FileReader(s));
    }

    public String next() throws Exception{
        while (st == null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }catch (IOException e){
                throw new Exception(e.toString());
            }
        }
        return st.nextToken();
    }

    public String nextLine() throws Exception{
        String str = "";
        try{
            str = br.readLine();
        }catch (IOException e){
            throw new Exception(e.toString());
        }
        return str;
    }
}
