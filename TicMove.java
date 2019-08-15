/**
 * Represents a player's move in tictactoe game.
 * @author Maddie Tong
 * @version CMPU102 special edition
 */
public class TicMove {
    /**
     * @param row the move's row
     */
    int row;
    /**
     * @param col the move's column
     */
    int col;
    /**
     * Constructor for objects of class TicMove.
     * @param row the move's row
     * @param col the move's column
     */
    public TicMove (int row, int col) {
        this.row = row;
        this.col = col;
    }
    
}