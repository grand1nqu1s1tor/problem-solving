class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols]; // Visited array to track
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, i, j, dirs, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false; // Return false if the word is not found in the entire grid
    }

    private boolean dfs(char[][] board, int[][] visited, int i, int j, int[][] dirs, int idx, String word) {
        // Check if out of bounds, already visited, or characters don't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1) {
            return false;
        }
        if (board[i][j] != word.charAt(idx)) {
            return false; // Character mismatch
        }
        if (word.length() == idx + 1) {
            return true; // Entire word matched
        }

        visited[i][j] = 1;

        for (int[] dir : dirs) {
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            if (dfs(board, visited, next_i, next_j, dirs, idx + 1, word)) {
                return true; // Return true if any direction leads to a match
            }
        }

        visited[i][j] = 0; // Backtrack: unmark the current cell

        return false; // Return false if no match is found in any direction
    }
}
