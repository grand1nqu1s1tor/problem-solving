class Solution {
    public boolean exist(char[][] board, String word) {
        // Same letter may not be used more than once
        // this means, we have to move in any direction after inclusion of the current cell mandatorily
        // If we find the word, return true, else false
        // Moving in Only four directions is allowed
        // Are the capital and small letters equally treated here?

        // Approach:
        // we can use the DFS, since we are building the depth/length of the word while
        // recursion

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] visited = new boolean[board.length][board[0].length];

        // We can only start the DFS wherever the starting letter matches to the
        // character at 0 idx.
        // Loop through the grid and apply DFS
        StringBuilder current = new StringBuilder("");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, i, j, current, word, dirs, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] matrix, int i, int j, StringBuilder current, String word, int[][] dirs, boolean[][] visited) {
        // Base Case 1
        if (word.equals(current.toString())) {
            return true;
        }

        // Base Case 2
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return false;
        }

        // Base Case 3
        if(matrix[i][j] != word.charAt(current.length())){
            return false;
        }

        visited[i][j] = true;
        current.append(matrix[i][j]);

        // Include the letter and DFS Call
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (dfs(matrix, new_i, new_j, current, word, dirs, visited)) {
                return true;
            }
        }

        // Backtracking
        current.deleteCharAt(current.length() - 1);
        visited[i][j] = false;

        return false;
    }
}