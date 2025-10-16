class Solution {
    public int removeElement(int[] nums, int val) {
        int[] arr = new int[nums.length];
        int idx=0;
        
        for(int i = 0; i< nums.length; i++){
            if( nums[i] != val){
                arr[idx] = nums[i];
                idx++;
            }
        }
        for(int x=0; x < idx; x++){
            nums[x] = arr[x];
        }
        return idx;
    }
}