package LeetCode;

class constRec {
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        
        while (area % W != 0) {
            W--;
        }
        
        int L = area / W;
        
        return new int[]{L, W};
    }
}