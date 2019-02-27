import java.util.Random;
import java.util.Arrays;

/**
 * Project 4 - TicTacToe Game
 *
 * This class is for the TicTacToe game that is implemented in the chat room.
 *
 * @author, @Section Varun Ramakrishnan, L09
 * @version 3rd April 2018
 *
 */

public class TicTacToeGame implements InGameUser
{

    /*
    Unused variables
    private static final char   PLAYERX = 'X';     // Helper constant for X player
    private static final char   PLAYERO = 'O';     // Helper constant for O player
    private static final char   SPACE = ' ';       // Helper constant for spaces
    */

    private static final int    ROWS_COLOMNS = 3;

    // Enum for possible values on game board
    private enum                board_square{X, O, TIE};

    // 2D Array for game board
    private board_square[][]    board = new board_square[ROWS_COLOMNS][ROWS_COLOMNS];

    private int[]               rows = new int[ROWS_COLOMNS];
    private int[]               colomns = new int[ROWS_COLOMNS];
    private int[]               diagonals = {0, 0};

    private int                 numTurn = 0;
    private board_square        whichPlayer = board_square.X;
    private board_square        win = null;

    // Variables made for each player of the game using the user Interface
    private InGameUser          playOne;
    private InGameUser          playTwo;

    // Variable to make IDs for the game
    private static int          gameID = 0;

    // Variable to assign each game a number
    private static int          gameNum;

    /*
    Sample TicTacToe Board
      0 | 1 | 2
     -----------
      3 | 4 | 5
     -----------
      6 | 7 | 8
     */

    // TODO 4: Implement necessary methods to manage the games of Tic Tac Toe

    public TicTacToeGame(InGameUser playX, InGameUser playY)
    {
        gameNum = gameID;
        gameID++;

        if(Math.random() < 0.5)
        {
            this.playOne = playX;
            this.playTwo = playY;
        }
        else
        {
            this.playOne = playY;
            this.playTwo = playX;
        }
    }

    /*
    Unused methods
    public int takeTurn(int index)
    {
        int turn = 0;


        return turn;
    }

    public int isTied()
    {
        int tie = 0;


        return tie;
    }

    public double getSpace()
    {
        double  spaces = 0.0;


        return spaces;
    }
*/
    // This method returns the ID of winner
    public InGameUser whoWin()
    {
        InGameUser  winner = null;

                    if(win == board_square.X) winner = playOne;
                    if(win == board_square.O) winner = playTwo;

        return winner;
    }

    // This method checks if the game is still going on
    public boolean isOn()
    {
        boolean isOn;

                if(win == null) isOn = false;
                else isOn = true;

        return isOn;
    }

    // This method is to check if the user is already in the game
    public boolean  isUserPlaying(InGameUser player)
    {
        boolean isPlaying = false;

                if(player.getUserID() == playOne.getUserID() || player.getUserID() == playTwo.getUserID()) isPlaying = true;

        return isPlaying;
    }

    // This method finds who's playing the game
    public InGameUser getWhosePlaying()
    {
        InGameUser  user;

                    if(!isOn()) user = null;
                    else if(whichPlayer == board_square.X) user = playOne;
                    else user = playTwo;

        return user;
    }

    // This method returns the two users playing the game
    public InGameUser[] getUsers()
    {
        InGameUser[]    usersInGame = {playOne, playTwo};

        return usersInGame;
    }

    // This method checks if a move is valid, if it is valid it places a move
    public boolean move(int location)
    {
        boolean move;

                move = moveTwoParam(location / 3, location % 3);

        return move;
    }

    // This method checks if the row and colomn are valid and places the move
    public boolean moveTwoParam(int row, int colomn)
    {
        boolean isValid;

                if(!isOn()) isValid = false;
                else
                {
                    board_square    position;

                    try
                    {
                        position = board[row][colomn];
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        return false;
                    }

                    if(position == null)
                    {
                        board[row][colomn] = whichPlayer;

                        rows[row] += boardSquareIntConv(whichPlayer);
                        colomns[colomn] += boardSquareIntConv(whichPlayer);

                        if(row == colomn) diagonals[0] += boardSquareIntConv(whichPlayer);
                        if(row == ROWS_COLOMNS - 1 - colomn) diagonals[1] += boardSquareIntConv(whichPlayer);

                        if(Math.abs(rows[row]) == ROWS_COLOMNS ||
                           Math.abs(colomns[colomn]) == ROWS_COLOMNS ||
                           Math.abs(diagonals[0]) == ROWS_COLOMNS ||
                           Math.abs(diagonals[1]) == ROWS_COLOMNS)
                        {
                            win = whichPlayer;
                            isValid = true;
                        }

                        whoNext();
                        isValid = true;
                    }

                    isValid = false;
                }

        return isValid;
    }

    // This method checks to see who's turn is next
    private void whoNext()
    {
        if((1 + numTurn) == 9) win = board_square.TIE;

        if(whichPlayer == board_square.X) whichPlayer = board_square.O;
        else if(whichPlayer == board_square.O) whichPlayer = board_square.X;;
    }

    /**
     * This method converts the board_square variable into an int.
     * If it is X, then it is "1", if it is O, then it is "-1"
     *
     * @param element
     * @return value
     */
    private int boardSquareIntConv(board_square element)
    {
        int value = 0;

            if(element == board_square.X) value = 1;
            else if(element == board_square.O) value = -1;

        return value;
    }

    /**
     * This method converts the board_square variable into a character.
     *
     * @param element
     * @return value
     */
    private char boardSquareCharConv(board_square element)
    {
        char    value = ' ';

                if(element == board_square.X) value = 'X';
                else if(element == board_square.O) value = 'Y';

        return value;
    }

    // This method returns the winner of the game
    public board_square getWinner()
    {
        return win;
    }

    // This method returns the user's ID
    public int getUserID()
    {
        return gameID;
    }

    // This method returns the user's name in the chatroom
    public String getUserName()
    {
        return null;
    }

    @Override
    public String toString()
    {
        String  toString = "";



        return toString;
    }

}