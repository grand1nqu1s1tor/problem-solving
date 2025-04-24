//package chess;
//
//import tictactoe.Player;
//
//public class Board {
//
//    private Cell[][] board;
//
//    public Cell[][] getBoard() {
//        return board;
//    }
//
//    public void setBoard(Cell[][] board) {
//        this.board = board;
//    }
//
//    public Board() {
//        board = new Cell[8][8];
//        initializeBoard(board);
//    }
//
//    public void initializeBoard(Cell[][] board) {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                board[i][j] = new Cell(i, j, null);
//            }
//        }
//
//        //PAWNS
//        for (int j = 0; j < 8; j++) {
//            board[1][j].setChessPiece(new Pawn(Player.BLACK, 1, j));
//            board[6][j].setChessPiece(new Pawn(Player.WHITE, 6, j));
//        }
//        // ROOKS
//        board[7][7].setChessPiece(new Rook(Player.BLACK, 7, 7));
//        board[0][7].setChessPiece(new Rook(Player.BLACK, 0, 7));
//        board[0][0].setChessPiece(new Rook(Player.WHITE, 0, 0));
//        board[7][0].setChessPiece(new Rook(Player.WHITE, 7, 0));
//
//        //KNIGHTS
//        board[0][1].setChessPiece(new Knight(Player.BLACK, 0, 1));
//        board[0][6].setChessPiece(new Knight(Player.BLACK, 0, 6));
//        board[7][1].setChessPiece(new Knight(Player.WHITE, 7, 1));
//        board[7][6].setChessPiece(new Knight(Player.WHITE, 7, 6));
//
//        //BISHOPS
//        board[0][2].setChessPiece(new Bishop(Player.BLACK, 0, 2));
//        board[0][5].setChessPiece(new Bishop(Player.BLACK, 0, 5));
//        board[7][2].setChessPiece(new Bishop(Player.WHITE, 7, 2));
//        board[7][5].setChessPiece(new Bishop(Player.WHITE, 7, 5));
//
//        //QUEENS
//        board[0][3].setChessPiece(new Queen(Player.BLACK, 0, 3));
//        board[7][3].setChessPiece(new Queen(Player.WHITE, 7, 3));
//
//        //KINGS
//        board[0][4].setChessPiece(new King(Player.BLACK, 0, 4));
//        board[7][4].setChessPiece(new King(Player.WHITE, 7, 4));
//    }
//
//    public Boolean moveChessPiece(int fromRow, int fromCol, int toRow, int toCol){
//        Cell fromCell = board[fromRow][fromCol];
//        Cell toCell = board[toRow][toCol];
//
//        //Empty cell selected with no piece
//        if(fromCell.isEmpty()){
//            return false;
//        }
//
//        ChessPiece piece = fromCell.getChessPiece();
//
//        // Step 2: Validate move for this piece
//        if (!piece.isMoveValid(toRow, toCol)) {
//            System.out.println("Invalid move for " + piece);
//            return false;
//        }
//
//        //Same player pieces at src and dest
//        if(toCell.getChessPiece().getPlayer() == fromCell.getChessPiece().getPlayer()){
//            return false;
//        }
//
//        //Move to empty cell
//        if(toCell.isEmpty()){
//            toCell.setChessPiece(fromCell.getChessPiece());
//            fromCell.setChessPiece(null);
//            return true;
//        }
//
//
//        toCell.setChessPiece(piece);
//        piece.setRow(toRow);
//        piece.setCol(toCol);
//        fromCell.setChessPiece(null);
//
//        return true;
//    }
//
//    public boolean isCheckMate(Player player) {
//        return isKingInCheck(player);
//    }
//
//    public boolean isKingInCheck(Player player) {
//        Cell kingCell = findKing(player);
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                ChessPiece piece = board[i][j].getChessPiece();
//                if(piece != null && piece.getPlayer() != player){
//                    if (piece.isMoveValid(kingCell.getRow(), kingCell.getCol())) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public Cell findKing(Player player) {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                ChessPiece piece = board[i][j].getChessPiece();
//                if (piece != null && piece instanceof King && piece.getPlayer() == player) {
//                    return board[i][j];
//                }
//            }
//        }
//        return null;
//    }
//
//}