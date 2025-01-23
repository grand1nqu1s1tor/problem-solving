import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Go from (0,0) position to the (m - 1, n - 1) position
        // Obstacle : 1, Space : 0

        // We will use the top-down approach since we are using recursion tree method
        // here

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(obstacleGrid, m - 1, n - 1, dp);
    }

    public int helper(int[][] grid, int i, int j, int[][] dp) {
        // The only valid moves wrt to the finish position would be either left or up.

        // Base Case 1: If out of bounds
        if (i < 0 || j < 0) {
            return 0;
        }

        // BC 2: If found a path
        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int left = 0, up = 0;
        if (j > 0 && grid[i][j - 1] != 1) {
            left = helper(grid, i, j - 1, dp);
        }
        if (i > 0 && grid[i - 1][j] != 1) {
            up = helper(grid, i - 1, j, dp);
        }

        dp[i][j] = left + up;
        return left + up;
    }
}