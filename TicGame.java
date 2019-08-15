import java.util.Scanner;

/** 
 * Represents a Tictactoe game.
 * @author Maddie Tong
 * @version CMPU102 special edition
 */

public class TicGame {
    /**
     * represents an empty position on the game board
     */
    protected final char BLANK = ' ';
    /**
     * represents the current game board as a matrix of players' symbols
     */
    protected char[][] board;
    /**
     * represents the board's size
     */
    protected final int boardSize;
    /**
     * game result 'T' means tie, 'C' means the human player wins, and 'L' 
    means the human player loses. Game result is updated every time the game is over.
     */
    protected char gameResult;
    /**
     * Constructor for objects of class TicGame
     * @param boardSize represents the board's size
     */
    public TicGame (int boardSize) {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];

        for (int i=0; i<boardSize; i++)
            for (int j=0; j<boardSize; j++)
                board[i][j] = BLANK;

    }

    /**
     * Creates a textual representation of the game board in the format: 
     *    1   2   3
     * A    |   |
     *   ---|---|---
     * B    | O |
     *   ---|---|---
     * C  X |   |
     * @return A string representing the game board in the above format.
     */
    public String toString () {
        String s = " ";
        char c = 'A';

        for (int i=0; i<boardSize; i++) {
            if (i==0)
                s += "  ";

            s += (i+1)+ "   ";
        }

        s += "\n";

        for (int i=0; i<boardSize; i++) {
            s += Character.toString(c); //convert char letter to string
            c++; //increment to create characters following 'A'

            for (int j=0; j<boardSize; j++) {
                if (j == 0)
                    s += "  ";

                if (j == (boardSize-1)) 
                    s += board[i][j]+ "\n";
                else
                    s += board[i][j]+ " | ";
            }

            if (i==(boardSize-1))
                break;

            for (int k=0; k<(boardSize-1); k++) { 
                if (k==0)
                    s += "  ";

                s += "---|";

                if (k == (boardSize-2))
                    s += "---\n";

            }    
        }
        return s;
    }

    /**
     * Returns the game board size.
     * @return Returns the game board size
     */
    public int getBoardSize () {
        return boardSize;
    }

    /**
     * Executes the move passed as an argument. If the move is invalid, it returns 
    false.
     * @param move the move to be executed
     * @param symbol the symbol of the player who is making the move 
     * @return true if the move was sucessfully executed
     */
    protected boolean executeMove (TicMove move, char symbol) {
        if (move != null) {
            board[move.row][move.col] = symbol;
        } else {
            return false;
        }
        return true;
    }

    /**
     * A method that returns true if the game is over and false if it is not over.
    A game is over if either player has completed a row, a column, or a diagonal. 
    Moreover, a game is also over if the board is full and no player completed 
    a row, line, or diagonal. That indicates a tie.
     *@return A boolean indicating whether the game is over or not.
     */
    public boolean isGameOver () {
        int n = getBoardSize();

        for (int i=0; i<n; i++) { //check if rows are completed
            char character = board[i][0]; 

            if (character == BLANK)
                continue;

            for (int j=0; j<n; j++)

                if (board[i][j] == character)
                    if ((j==(n-1)) && (character == 'X')) {
                        System.out.println(
                            "Congratulations, you won! Play again?");
                        gameResult = 'C';
                        return true;
                    } else if ((j==(n-1)) && (character == 'O')) {
                        System.out.println("You lost! Try again?");
                        gameResult = 'L';
                        return true;
                    }
                    else
                        continue;
                else if (board[i][j] != character)
                    break;

        }

        for (int j=0; j<n; j++) {//check columns are completed

            char character = board[0][j]; 

            if (character == BLANK)
                continue;

            for (int i=0; i<n; i++)

                if (board[i][j] == character)
                    if ((i==(n-1)) && (character == 'X')) {
                        System.out.println(
                            "Congratulations, you won! Play again?");
                        gameResult = 'C';
                        return true;
                    } else if ((i==(n-1)) && (character == 'O')) {
                        System.out.println("You lost! Try again?");
                        gameResult = 'L';
                        return true;
                    }
                    else
                        continue;
                else if (board[i][j] != character)
                    break;

        }

        for (int i=0; i<n; i++) {//check diagonals from left upper corner to right lower corner are completed
            char character = board[0][0]; 

            if (character == BLANK)
                break;

            if (board[i][i] == character)
                if ((i==(n-1)) && (character == 'X')) {
                    System.out.println(
                        "Congratulations, you won! Play again?");
                    gameResult = 'C';
                    return true;
                } else if ((i==(n-1)) && (character == 'O')) {
                    System.out.println("You lost! Try again?");
                    gameResult = 'L';
                    return true;
                }
                else
                    continue;
            else if (board[i][i] != character)
                break;

        }

        for (int j=0; j<n; j++) {//check diagonals from right upper corners to left lower corners are completed
            char character = board[0][n-1]; 

            if (character == BLANK)
                break;

            if (board[j][(n-1)-j] == character)
                if ((j == (n-1)) && (character == 'X')) {
                    System.out.println(
                        "Congratulations, you won! Play again?");
                    gameResult = 'C';
                    return true;
                } else if ((j == (n-1)) && (character == 'O')) {
                    System.out.println("You lost! Try again?");
                    gameResult = 'L';
                    return true;
                }
                else
                    continue;
            else if (board[j][(n-1)-j] != character)
                break;

        }

        for (int i=0; i<n; i++) {//check if board is full (ie. tie)
            for (int j=0; j<n; j++) {

                if (board[i][j] == BLANK)
                    return false;

                else if (board[i][j] != BLANK)
                    if ((j==(n-1)) && (i==(n-1))) {
                        System.out.println("Oh, a tie! Try again?");
                        gameResult = 'T';
                        return true;
                    } else
                        continue;

            }
        }
        return false;
    }

    /**
     * Creates and prints a new game board. Resets the game state so that the user 
     * can play again.
     */
    protected void resetGame () {
        TicGame newboard = new TicGame(this.boardSize); //create a new blank board with the user's inputted board size
        System.out.println("---------- NEW GAME ----------");
        System.out.println(newboard);
        this.board = newboard.board; //update the current game board to a newly created.
    }

    /**
     * Returns the game result as a character. Game result 'T' means tie, 'C' means 
     * the user wins, and 'L' means the user loses.
     * @return a character representing the game's result.
     */
    public char getGameResult () {
        return gameResult;
    }

    /**
     * Runs a single-player, text-based game of Tictactoe. New games run right
    after the user quits. When the user quits, the total number of games 
    played and the human player's winning ratio is printed on the screen.
     * @param args The first argument represents the user's desired game board size,
     * which must be an integer between 1 and 9, inclusive. If no argument is provided
     * or if the provided board size does not comply to the rules, appropriate messages 
     * are printed and a default game board sized 3x3 will be used.
     */
    public static void main(String[] args) {
        System.out.println(
            "Tic-tac-toe by Maddie Tong, CMPU-102 special edition");

        int boardSize; 
        TicGame aboard;
        double totalgames = -1;
        double win = 0;

        while (true) {

            if (args.length == 0) {
                aboard = new TicGame(3);
                break;
            }

            //check if args contains a negative value
            try {
                boardSize = Integer.parseInt(args[0]);   
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid board size '"+args[0]+
                    "' (not an integer), using default value of 3 instead.");
                aboard = new TicGame(3);
                break;
            } 

            boardSize = Integer.parseInt(args[0]);

            if ((boardSize<=0)||(boardSize>9)) { //check if the user's desired boardSize is outside the accepted range 
                System.out.println(
                    "Specified board size "+boardSize+ 
                    " out of range [1,9], using default value of 3 instead.");
                aboard = new TicGame(3);
                break;
            }

            aboard = new TicGame(boardSize);
            break;

        }

        while (true) {

            totalgames += 1; //total game is updated every time the program goes from the start of this loop

            aboard.resetGame(); //used to create the first blank game board and subsequent ones of the same size after gameover
            HumanTicPlayer human = new HumanTicPlayer(aboard);
            CpuTicPlayer compu = new CpuTicPlayer(aboard);

            if ((Math.random()) < 0.5) {
                aboard.executeMove(compu.pickMove(),'O');
                System.out.println(aboard);

            } 

            while (true) {

                if ((aboard.executeMove(human.pickMove(),'X')) == false) { 

                    if (totalgames == 0)
                        System.out.println("Goodbye!");
                    else
                        System.out.println("You won "+(int)win+" out of "
                            +(int)totalgames+ " games ("
                            +(int)((win/totalgames)*100)+"%). Goodbye!");

                    return;
                }
                else 
                    System.out.println(aboard);

                if ((aboard.isGameOver()) == true){
                    if (aboard.getGameResult() == 'C')
                        win += 1;
                    break;
                }

                aboard.executeMove(compu.pickMove(),'O');
                System.out.println(aboard);

                if ((aboard.isGameOver()) == true){
                    if (aboard.getGameResult() == 'C')
                        win += 1;
                    break;
                }

            }
        }
    }
}

