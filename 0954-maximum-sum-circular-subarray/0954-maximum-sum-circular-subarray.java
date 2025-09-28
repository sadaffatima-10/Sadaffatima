class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMaxSum = 0;
        int currentMinSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            totalSum += num;
            
            currentMaxSum = Math.max(num, currentMaxSum + num);
            maxSum = Math.max(maxSum, currentMaxSum);
            
            currentMinSum = Math.min(num, currentMinSum + num);
            minSum = Math.min(minSum, currentMinSum);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);

    }
}