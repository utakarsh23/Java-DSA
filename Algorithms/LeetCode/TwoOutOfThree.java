package LeetCode;

class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        var res=new ArrayList<Integer>();
        int [] index1=new int[101];
        int [] index2=new int[101];
        int [] index3=new int[101];

        for(int i:nums1) index1[i]=1;
        for(int i:nums2) index2[i]=1;
        for(int i:nums3) index3[i]=1;
        for(int i=0;i<101;i++) if(index1[i]+index2[i]+index3[i]>1) res.add(i);

        return res;
    }
}