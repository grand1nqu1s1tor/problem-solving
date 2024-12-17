package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFSTemplate {
    public void bfs(int[][] matrix) {
        // Check for an empty matrix/graph.
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Perform BFS on each cell in the matrix.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    traverse(matrix, visited, i, j, directions);
                }
            }
        }
    }

    // Helper method to perform BFS.
    private void traverse(int[][] matrix, boolean[][] visited, int i, int j, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr_i = current[0];
            int curr_j = current[1];

            if (visited[curr_i][curr_j]) {
                continue;
            }

            visited[curr_i][curr_j] = true;

            // Traverse neighbors.
            for (int[] direction : directions) {
                int next_i = curr_i + direction[0];
                int next_j = curr_j + direction[1];

                if (next_i >= 0 && next_i < matrix.length && next_j >= 0 && next_j < matrix[0].length) {
                    if (!visited[next_i][next_j]) {
                        queue.add(new int[]{next_i, next_j});
                    }
                }
            }
        }
    }
}
