class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int answer = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            int best = 0;
            for (int prev = Math.max(0, idx - k); prev <= Math.min(25, idx + k); prev++) {
                best = Math.max(best, dp[prev]);
            }
            dp[idx] = best + 1;
            answer = Math.max(answer, dp[idx]);
        }
        return answer;
    }
}
