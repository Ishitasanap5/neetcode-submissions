class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinceCount++;
                dfs(isConnected, i, visited); 
            }
        }
        return provinceCount;
    }
    private void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;
        
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, j, visited); 
            }
        }
    }
}