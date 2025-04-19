package GFG;

class HIndex {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
       int n = citations.length;
       int[] freq = new int[n+1];
       for(int cit : citations) {
           if(cit >= n) {
               freq[n]++;
           } else {
               freq[cit]++;
           }
       }
       int index = n;
       int s = freq[n];
       while(s < index) {
           index--;
           s += freq[index];
       }
       return index;
    }
}