import java.util.Scanner;
/**
 * A human tictactoe player that reads moves from the keyboard.
 * @author Maddie Tong
 * @version CMPU102 special edition
 */
public class HumanTicPlayer extends ATicPlayer {
    /**
     * Constructor for objects of class HumanTicPlayer
     * @param game the tictactoe game that is to be played
     */
    public HumanTicPlayer (TicGame game) {
        super(game);
    }

    /**
     * This method asks the user to enter a tictactoe move. Moves are read from 
     * the keyboard and are specified by two characters rc, where r is a letter 
     * representing the row and c is a digit representing the column 
     * (lowercase and uppercase should not matter). If the user's input is 
     * not within the game board, or is already occupied, an appropriate error 
     * message is displayed and the user is asked for another position. If the 
     * user writes "quit",the method returns null, indicating it is time to exit
     * the program.
     * @return the move the user chose or null if the user wants to quit.
     */
    public TicMove pickMove() {
        int r;
        int c;
        char x = 'A';
        int n = game.getBoardSize();
        char[][] currentboard = game.board;

        for (int i=0; i<(n-1); i++) {      
            x++;
        }

        while (true) {

            System.out.printf("Your move (quit to exit): ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next().toUpperCase();

            if (s.compareTo("QUIT") == 0) {
                return null;
            }

            try {
                r = ((int) (s.charAt(0)) - 'A')+1;
                c = ((int) (s.charAt(1)))%48;
            } catch (StringIndexOutOfBoundsException e) { 
                System.out.println(
                    "Invalid move: please specify two characters, one for the row and \nanother for the column. E.g a1.");
                continue;//continue by looping back to ask for the user's move when the current move is invalid
            }

            //convert string elements to char then to integers (ASCII)
            r = ((int) (s.charAt(0)) - 'A')+1;
            c = ((int) (s.charAt(1)))%48;

            if ((s.length())>2) { //check if the user's input is longer than necessary
                System.out.println(
                    "Invalid move: please specify two characters, one for the row and \nanother for the column. E.g a1.");
                continue;
            }   

            if ((r > n)||(r <= 0))  {//check if the user's inputted row is out of bound
                System.out.println("Invalid move: invalid row " +s.charAt(0)+ 
                    ". Must be between A and "+x+".");
                continue;
            }

            if ((c > n)||(c <= 0)) {//check if the user's inputted column is out of bound
                System.out.println("Invalid move: invalid column " +s.charAt(1)+
                    ". Must be between 1 and " +n+ ".");
                continue;
            }

            if (currentboard[(r-1)][(c-1)] != game.BLANK){// check if the position is occupied
                System.out.println("Invalid move: position already taken.");
                continue;
            }

            TicMove ticmove = new TicMove ((r-1),(c-1));
            return ticmove;

        }
    }
}