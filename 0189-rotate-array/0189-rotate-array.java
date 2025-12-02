class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n; // to handle n<k.

        int[] arr = new int[n];

        int j = n - k;  
       
        int x = 0;

        for(int i=j; i<n; i++){
            arr[x] = nums[i];
            x++;
        }
        for(int i=0; i<j; i++){
                arr[x] = nums[i];
                x++;
        }
        for(int i=0; i<n; i++){
            nums[i] = arr[i];
        }
    }
}