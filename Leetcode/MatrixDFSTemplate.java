public class MatrixDFSTemplate {
    public void dfs(int[][] matrix) {
        // Check for an empty matrix/graph.
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Perform DFS on each cell in the matrix.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    traverse(matrix, visited, i, j, directions);
                }
            }
        }
    }

    // Helper method to perform DFS.
    private void traverse(int[][] matrix, boolean[][] visited, int i, int j, int[][] directions) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // Traverse neighbors.
        for (int[] direction : directions) {
            int next_i = i + direction[0];
            int next_j = j + direction[1];
            if (next_i >= 0 && next_i < matrix.length && next_j >= 0 && next_j < matrix[0].length) {
                traverse(matrix, visited, next_i, next_j, directions);
            }
        }
    }
}
