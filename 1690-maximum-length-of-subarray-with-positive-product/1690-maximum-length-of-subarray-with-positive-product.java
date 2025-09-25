class Solution {
    public int getMaxLen(int[] nums) {
        int max_len = 0;
        int pos_len = 0;
        int neg_len = 0;

        for (int num : nums) {
            if (num > 0) {
                pos_len++;
                neg_len = (neg_len == 0) ? 0 : neg_len + 1;
            } else if (num < 0) {
                int temp_pos = (neg_len == 0) ? 0 : neg_len + 1;
                int temp_neg = pos_len + 1;
                pos_len = temp_pos;
                neg_len = temp_neg;
            } else { // num == 0
                pos_len = 0;
                neg_len = 0;
            }
            max_len = Math.max(max_len, pos_len);
        }

        return max_len;
    }
}
