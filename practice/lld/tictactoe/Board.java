import java.util.*;

public class Board {

    private final char[][] board;
    private char currentPlayer;

    public Board(int n) {
        this.board = new char[n][n];
        initializeBoard();
        this.currentPlayer = 'X';
    }

    public void initializeBoard() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /* O(N^2)
     * Naive way : Check every cell on the board.
     */

    /* O(N)
     * Better Way: So what you would do to check who the winner is after every move would be to,
     * check the row, column and the diagonals relating to the where the latest move has been made.
     */

    /* O(1)
     * Best Way : */
    public char getWinner() {
        return ' ';
    }

    //Which player is making the move where
    public char makeMove(char currPlayer, int row, int col) {
        //Validate Player
        //if (getCurrentPlayer() != currPlayer) throw new IllegalArgumentException("Invalid Player");

        //Validate the position
        int n = board.length;
        if (row < 0 || row >= n || col < 0 || col >= n || board[row][col] != ' ') {
            throw new IllegalArgumentException("Invalid Move");
        }

        // Place the player's move on the board
        board[row][col] = currPlayer;

        //Check if the player won by making this move

        //Check the row
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (board[row][j] == currPlayer) cnt++;
            if (cnt == n) return currPlayer;
        }

        //Check the column
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (board[i][col] == currPlayer) cnt++;
            if (cnt == n) return currPlayer;
        }

        //Check for diagonal
        boolean winDiagonal = true;
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (board[i][i] != currPlayer) {
                    winDiagonal = false;
                    break;
                }
            }
        }

        //Check for reverse diagonal
        boolean winRevDiagonal = true;
        if (row + col == n - 1) {
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != currPlayer) {
                    winRevDiagonal = false;
                    break;
                }
            }
        }

        if (winDiagonal || winRevDiagonal) {
            return currPlayer;
        }

        //Switch the player at the end if no winner is found
        this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';

        return ' ';
    }

    public static void main(String[] args) {
        Board board = new Board(3);

        System.out.println(board.makeMove('X', 0, 0)); // No winner yet
        System.out.println(board.makeMove('O', 1, 1)); // No winner yet
        System.out.println(board.makeMove('X', 0, 1)); // No winner yet
        System.out.println(board.makeMove('O', 2, 2)); // No winner yet
        System.out.println(board.makeMove('X', 0, 2)); // X wins
    }

}