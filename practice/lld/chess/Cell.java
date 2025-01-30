public class Cell {

    private int row;
    private int col;
    private ChessPiece chessPiece;

    public Cell(int row, int col, ChessPiece chessPiece) {
        this.row = row;
        this.col = col;
        this.chessPiece = chessPiece;
    }

    //Check if cell has a chess piece
    public Boolean isEmpty() {
        if (chessPiece == null) {
            return true;
        }
        return false;
    }

    public void setChessPiece(ChessPiece chessPiece){
        this.chessPiece = chessPiece;
    }

}