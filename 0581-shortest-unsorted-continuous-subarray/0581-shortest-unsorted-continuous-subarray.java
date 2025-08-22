class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == n - 1) return 0;

        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        int subarrayMin = Integer.MAX_VALUE, subarrayMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            subarrayMin = Math.min(subarrayMin, nums[i]);
            subarrayMax = Math.max(subarrayMax, nums[i]);
        }

        while (left > 0 && nums[left - 1] > subarrayMin) {
            left--;
        }
        while (right < n - 1 && nums[right + 1] < subarrayMax) {
            right++;
        }

        return right - left + 1;
    }
}
