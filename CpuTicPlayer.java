/**
 * A computer-controlled tictactoe player that makes random game moves.
 * @author Maddie Tong
 * @version CMPU102 special edition
 */
public class CpuTicPlayer extends ATicPlayer { 

    /**
     * Constructors for objects of class CompuTicPlayer
     * @param game the tictactoe game that is to be played
     */
    public CpuTicPlayer (TicGame game) {
        super(game); 
    }

    /**
     * Randomizes a move uniformly. It generates random moves within a game
     * board until it finds a blank position, meaning it would go in an infinite 
     * loop if the game was not over yet.
     * @return the selected random move; it never returns null since the computer
     * never quits.
     */
    public TicMove pickMove() {

        while (true) {
            int n = game.boardSize;
            int x = (int)(n*Math.random());
            int y = (int)(n*Math.random());
            char[][] currentboard = game.board;
            int numx = 0;
            int numo = 0;
            int score = 0;

            //check if the position is occupied. If no, carry on. If yes, randomly generate another row and column position
            if (currentboard[x][y] != game.BLANK)
                continue;
            TicMove ticmove = new TicMove(x,y);

            loop1:
            for (int i=0; i<n; i++) { //check rows

                for (int j=0; j<n; j++) {
                    if (currentboard[i][j] == 'X')
                        numx += 1; 
                    if (currentboard[i][j] == 'O')
                        numo += 1;    
                }
                if (numo == n-1 && numx == 0) {
                    for (int j=0; j<n; j++) {
                        if (currentboard[i][j] == game.BLANK) {
                            ticmove.row = i;
                            ticmove.col = j;
                            break loop1;
                        }
                    }
                }
                if (numx == n-1 && numo == 0) {
                    for (int j=0; j<n; j++) {
                        if (currentboard[i][j] == game.BLANK) {
                            ticmove.row = i;
                            ticmove.col = j;
                            break loop1;
                        }
                    }
                }
                numx = 0;
                numo = 0;
            }

            loop2:
            for (int j=0; j<n; j++) {//check columns

                for (int i=0; i<n; i++) {
                    if (currentboard[i][j] == 'X')
                        numx += 1; 
                    if (currentboard[i][j] == 'O')
                        numo += 1; 
                }
                if (numo == n-1 && numx == 0) {
                    for (int i=0; i<n; i++) {
                        if (currentboard[i][j] == game.BLANK) {
                            ticmove.row = i;
                            ticmove.col = j;
                            break loop2;
                        }
                    }
                }
                if (numx == n-1 && numo == 0) {
                    for (int i=0; i<n; i++) {
                        if (currentboard[i][j] == game.BLANK) {
                            ticmove.row = i;
                            ticmove.col = j;
                            break loop2;
                        }
                    }
                }
                numx = 0;
                numo = 0;
            }

            loop3:
            for (int i=0; i<n; i++) {//check diagonals from left
                if (currentboard[i][i] == 'X')
                    numx += 1; 
                if (currentboard[i][i] == 'O')
                    numo += 1;
                if (numo == n-1 && numx == 0) {
                    for (int j=0; j<n; j++) {
                        if (currentboard[j][j] == game.BLANK) {
                            ticmove.row = j;
                            ticmove.col = j;
                            break loop3;
                        }
                    }
                }
                if (numx == n-1 && numo == 0) {
                    for (int j=0; j<n; j++) {
                        if (currentboard[j][j] == game.BLANK) {
                            ticmove.row = j;
                            ticmove.col = j;
                            break loop3;
                        }
                    }
                }
            }
            numx = 0;
            numo = 0;

            // loop4:
            // for (int j=0; j<n; j++) {//check diagonals from right 

                // if (currentboard[j][(n-1)-j] == 'X')
                    // numx += 1;
                // if (currentboard[j][(n-1)-j] == 'O')
                    // numo += 1;    
                // if (numo == n-1 && numx == 0) {
                    // for (int k=0; k<n; k++) {
                        // if (currentboard[k][(n-1)-k] == game.BLANK) {
                            // ticmove.row = j;
                            // ticmove.col = j;
                            // break loop4;
                        // }
                    // }
                // }
                // if (numx == n-1 && numo == 0) {
                    // for (int k=0; k<n; k++) {
                        // if (currentboard[k][(n-1)-k] == game.BLANK) {
                            // ticmove.row = j;
                            // ticmove.col = j;
                            // break loop4;
                        // }
                    // }
                // }
            // }
            // numx = 0;
            // numo = 0;

            char z = (char) (x + 65); //convert the row number to the letter representing that row

            System.out.println("CPU's move: "+z+ +(y+1)+"\n");
            return ticmove;
        }
    }

}