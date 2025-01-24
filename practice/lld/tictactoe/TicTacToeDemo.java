public class TicTacToeDemo {

    public static void main(String[] args) {
        Board board = new Board(3);

        System.out.println(board.makeMove('X', 0, 0)); // No winner yet
        System.out.println(board.makeMove('O', 1, 1)); // No winner yet
        System.out.println(board.makeMove('X', 0, 1)); // No winner yet
        System.out.println(board.makeMove('O', 2, 2)); // No winner yet
        System.out.println(board.makeMove('X', 0, 2)); // X wins
    }

}