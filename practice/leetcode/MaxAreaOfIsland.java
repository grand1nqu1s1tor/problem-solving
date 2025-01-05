
class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundaries : 0
        // Water : 0
        // Island : 1
        // We can move in four directions
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // Maximu Area of an island in the grid to be returned
        int maxArea = 0;
        // Use DFS to explore one island at time
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(grid, i, j, dirs);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int[][] dirs) {
        int m = grid.length;
        int n = grid[0].length;

        // Base Case : Goes out of Bound
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int area = 1;

        for (int[] dir : dirs) {
            int new_i = dir[0] + i;
            int new_j = dir[1] + j;

            area = area + dfs(grid, new_i, new_j, dirs);
        }

        return area;
    }
}