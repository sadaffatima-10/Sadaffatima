class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;

        boolean[] travel = new boolean[366]; 
        int last = 0;
        
        for (int d : days) {
            travel[d] = true;
            last = Math.max(last, d);
        }

        int[] dp = new int[last + 1]; 

        for (int d = 1; d <= last; d++) {
            if (!travel[d]) {
                dp[d] = dp[d - 1];
            } else {
                int cost1 = dp[d - 1] + costs[0];
                int cost7 = dp[Math.max(0, d - 7)] + costs[1];
                int cost30 = dp[Math.max(0, d - 30)] + costs[2];
                dp[d] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[last];
    }
}