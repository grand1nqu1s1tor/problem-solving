import java.util.*;

public class Board {

    private final char[][] board;
    private char currentPlayer;
    private boolean isGameOver;

    public Board(int n) {
        this.board = new char[n][n];
        initializeBoard();
        this.currentPlayer = 'X';
        isGameOver = false;
    }

    public void initializeBoard() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
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
        // Validate if the game is still on
        if (isGameOver) throw new IllegalArgumentException("Game is already over");

        // Validate the position
        int n = board.length;
        if (row < 0 || row >= n || col < 0 || col >= n || board[row][col] != ' ') {
            throw new IllegalArgumentException("Invalid Move");
        }

        // Place the player's move on the board
        board[row][col] = currPlayer;

        // Flags to check for a win
        boolean rowWin = true;
        boolean colWin = true;
        boolean diagWin = true;
        boolean revDiagWin = true;

        // Check the row
        for (int j = 0; j < n; j++) {
            if (board[row][j] != currPlayer) {
                rowWin = false;
                break;
            }
        }

        // Check the column
        for (int i = 0; i < n; i++) {
            if (board[i][col] != currPlayer) {
                colWin = false;
                break;
            }
        }

        // Check the diagonal
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (board[i][i] != currPlayer) {
                    diagWin = false;
                    break;
                }
            }
        } else {
            diagWin = false; // Not on the diagonal
        }

        // Check the reverse diagonal
        if (row + col == n - 1) {
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != currPlayer) {
                    revDiagWin = false;
                    break;
                }
            }
        } else {
            revDiagWin = false; // Not on the reverse diagonal
        }

        // If any flag is true, the current player wins
        if (rowWin || colWin || diagWin || revDiagWin) {
            isGameOver = true; // Mark the game as over
            printBoard();
            return currPlayer;
        }

        // Switch the player at the end if no winner is found
        this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';

        printBoard();

        return ' '; // No winner yet
    }

    public void printBoard() {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}