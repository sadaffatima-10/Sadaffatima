class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        return solve(s1, s2, 0, 0, dp);
    }

    private int solve(String s1, String s2,int i, int j, int[][] dp){
        int m = s1.length();
        int n = s2.length();

        if(i >= m && j >= n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if( i >= m){
            return dp[i][j] = s2.charAt(j) + solve(s1,s2, i, j+1, dp);
        }
        if( j >= n){
            return dp[i][j] = s1.charAt(i) + solve(s1,s2, i+1, j, dp);
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1, dp);
        }
       
        int delete_s1 = s1.charAt(i) + solve(s1, s2, i+1, j, dp);
        int delete_s2 = s2.charAt(j) + solve(s1, s2, i, j+1, dp);
        
        return dp[i][j] = Math.min(delete_s1, delete_s2);

    }
}