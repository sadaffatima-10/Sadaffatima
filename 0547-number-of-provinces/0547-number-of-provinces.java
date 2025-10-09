class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited){
        visited[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, j,visited);
            }
        }
    }
}