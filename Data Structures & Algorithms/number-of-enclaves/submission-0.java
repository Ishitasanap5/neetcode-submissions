class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1) {
                dfs(grid, 0, c);
            }
            if (grid[rows - 1][c] == 1) {
                dfs(grid, rows - 1, c);
            }
        }
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 1) {
                dfs(grid, r, 0);
            }
            if (grid[r][cols - 1] == 1) {
                dfs(grid, r, cols - 1);
            }
        }
        int enclaveCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    enclaveCount++;
                }
            }
        }
        
        return enclaveCount;
    }
    

private void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
}