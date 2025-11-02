class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] suffix=new int[n+1];
        for( int num:citations){
            if(num > n){
                suffix[n]++;
            }
            else{
                suffix[num]++;
            }
        }
        int sum=0;
        for(int i=suffix.length-1;i>=0;i--){
            sum = sum+suffix[i];
            if(sum >=i){
                return i;
            }
        }
        return 0;
    }
}