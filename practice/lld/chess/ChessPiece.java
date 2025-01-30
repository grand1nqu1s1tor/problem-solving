public abstract class ChessPiece {

    private Player player;
    private int row;
    private int col;

    public ChessPiece(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    //To be implmented by Chess Piece Subclasses
    public abstract Boolean isMoveValid(int newRow, int newcol);


}