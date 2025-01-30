import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Player currentPlayer;
    private Scanner scanner;

    public ChessGame() {
        this.board = new Board();
        this.currentPlayer = Player.WHITE;
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        while (true) {
            System.out.println(currentPlayer + "'s turn. Enter your move (fromRow fromCol toRow toCol): ");

            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            // Ensure the selected piece belongs to the current player
            ChessPiece piece = board.getPieceAt(fromRow, fromCol);
            if (piece == null || piece.getPlayer() != currentPlayer) {
                System.out.println("Invalid move: You can only move your own pieces!");
                continue; // Ask for input again
            }

            if (board.moveChessPiece(fromRow, fromCol, toRow, toCol)) {
                if (board.isCheckMate(currentPlayer)) {
                    System.out.println("Checkmate! " + currentPlayer + " loses.");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == Player.WHITE) ? Player.BLACK : Player.WHITE;
    }

    public static void main(String[] args) {
        ChessGame newGame = new ChessGame();
        newGame.playGame();
    }
}
