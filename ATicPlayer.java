/**
 * An abstract class representing a generic tictactoe game player.
 * @author Maddie Tong
 * @version CMPU102 special edition
 */
public abstract class ATicPlayer {
    /**
     * The current game is being played
     */
    protected TicGame game;
    /**
     * Empty constructor for objects of class ATicPlayer.
     */
    protected ATicPlayer () {}

    /**
     * Constructor for objects of class ATicPlayer.
     * @param game the tictactoe game that is to be played.
     */
    protected ATicPlayer (TicGame game) {
        this.game = game;
    }

    /**
     * Makes the player choose a move. Each concrete type of player implements
     * this method with different semantics. It either return the move picked
     * by the player or return null when the user wants to quit.
     * @return the chosen move by the player.
     */
    public abstract TicMove pickMove();

}