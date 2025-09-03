class Solution {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= target; sum++) {
                long ways = 0;
                for (int face = 1; face <= k; face++) {
                    if (sum - face >= 0) {
                        ways += dp[dice - 1][sum - face];
                    }
                }
                dp[dice][sum] = (int)(ways % MOD);
            }
        }

        return dp[n][target];
    }
}