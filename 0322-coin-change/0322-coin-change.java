class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int max = amount+1;

        if(amount < 1){
            return 0;
        }

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for(int i=1; i<= amount ; i++){
            dp[i] = max;
        }

        for(int i=1; i<= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}