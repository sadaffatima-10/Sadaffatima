class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int i=0;
        int sum=0;
        int diff=Integer.MAX_VALUE;
        int closestSum=0;

        for(i=0;i < nums.length-2;i++){
            int j=i+1;
            int k= nums.length-1;
            while(j < k){
                sum = nums[i]+nums[j]+nums[k];
                int currDiff =Math.abs(target-sum);
                
                if(currDiff < diff){
                    diff = currDiff;
                    closestSum = sum;
                }
            
                if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return closestSum;
    }
}