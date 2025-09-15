class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        
        dp[0][0] = 1;
        
        int mod = 1000000007;

        for(int i=1; i<=n ; i++){
            for(int j=1; j<= target; j++){
                for(int face=1; face <= k; face++){
                    if(j >= face){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-face]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}