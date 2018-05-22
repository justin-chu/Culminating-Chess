import java.util.*;
public class Bishop extends ChessPiece
{
    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(int row, int col, boolean isWhite)
    {
        super(row,col,isWhite);
    }

    //public abstract void findMove();

    public void findMove(ChessPiece[][] board)
    {
        boolean ur = true; //used to make sure piece cant hop over another
        boolean dr = true; //used to make sure piece cant hop over another
        boolean ul = true; //used to make sure piece cant hop over another
        boolean dl = true; //used to make sure piece cant hop over another
        int[][] move = new int[13][2]; //Array saves all moves possible for the piece [most moves possible][coordinates]
        int count = 0; //counter for possible moves
        for(int r = 0; r<8; r++)
        {           
            for(int c = 0; c<8; c++)
            {
                if(r>getRow() && c>getCol() && ur == true) //piece moves up, right and hasnt tried to hop over another piece
                {
                    if(board[r][c] instanceof ChessPiece && Math.abs(getRow() - r) != Math.abs(getCol() - c)){ //if a piece is in the way on the diagonal
                        if(board[r][c].getIsWhite()!=getIsWhite()) //if that piece is the oppisite colour
                        {
                            move[count][0] = r; //input row coordinate of possible move
                            move[count][1] = c; //input column coordinate of possible move
                            count++; //add to number of possible moves
                            ur = false;
                            break;
                        } else{
                            ur = false;
                            break;
                        }
                    }else if(getRow() == r && getCol() == c) // makes sure the piece is actually moved
                        break;
                    else if(Math.abs(getRow() - r) != Math.abs(getCol() - c)) //makes sure piece moved diagonally
                        break;
                    else{
                        move[count][0] = r; //input row coordinate of possible move
                        move[count][1] = c; //input column coordinate of possible move
                        count++; //add to number of possible moves
                    }
                }
                else if(r<getRow() && c>getCol() && dr == true) //piece moves down, right and hasnt tried to hop over another piece
                {
                    if(board[r][c] instanceof ChessPiece && Math.abs(getRow() - r) != Math.abs(getCol() - c)){ //if a piece is in the way on the diagonal
                        if(board[r][c].getIsWhite()!=getIsWhite()) //if that piece is the oppisite colour
                        {
                            move[count][0] = r; //input row coordinate of possible move
                            move[count][1] = c; //input column coordinate of possible move
                            count++; //add to number of possible moves
                            dr = false;
                            break;
                        } else{
                            dr = false;
                            break;
                        }
                    }else if(getRow() == r && getCol() == c) // makes sure the piece is actually moved
                        break;
                    else if(Math.abs(getRow() - r) != Math.abs(getCol() - c)) //makes sure piece moved diagonally
                        break;
                    else{
                        move[count][0] = r; //input row coordinate of possible move
                        move[count][1] = c; //input column coordinate of possible move
                        count++; //add to number of possible moves
                    }
                }
                else if(r>getRow() && c<getCol() && ul == true) //piece moves up, left and hasnt tried to hop over another piece
                {
                    if(board[r][c] instanceof ChessPiece && Math.abs(getRow() - r) != Math.abs(getCol() - c)){ //if a piece is in the way on the diagonal
                        if(board[r][c].getIsWhite()!=getIsWhite()) //if that piece is the oppisite colour
                        {
                            move[count][0] = r; //input row coordinate of possible move
                            move[count][1] = c; //input column coordinate of possible move
                            count++; //add to number of possible moves
                            ul = false;
                            break;
                        } else{
                            ul = false;
                            break;
                        }
                    }else if(getRow() == r && getCol() == c) // makes sure the piece is actually moved
                        break;
                    else if(Math.abs(getRow() - r) != Math.abs(getCol() - c)) //makes sure piece moved diagonally
                        break;
                    else{
                        move[count][0] = r; //input row coordinate of possible move
                        move[count][1] = c; //input column coordinate of possible move
                        count++; //add to number of possible moves
                    }
                }
                else if(r<getRow() && c<getCol() && dl == true) //piece moves down, left and hasnt tried to hop over another piece
                {
                    if(board[r][c] instanceof ChessPiece && Math.abs(getRow() - r) != Math.abs(getCol() - c)){ //if a piece is in the way on the diagonal
                        if(board[r][c].getIsWhite()!=getIsWhite()) //if that piece is the oppisite colour
                        {
                            move[count][0] = r; //input row coordinate of possible move
                            move[count][1] = c; //input column coordinate of possible move
                            count++; //add to number of possible moves
                            dl = false;
                            break;
                        } else{
                            dl = false;
                            break;
                        }
                    }else if(getRow() == r && getCol() == c) // makes sure the piece is actually moved
                        break;
                    else if(Math.abs(getRow() - r) != Math.abs(getCol() - c)) //makes sure piece moved diagonally
                        break;
                    else{
                        move[count][0] = r; //input row coordinate of possible move
                        move[count][1] = c; //input column coordinate of possible move
                        count++; //add to number of possible moves
                    }
                }
            }
            if(count>13) //failsafe so counter cant go over most possible moves
                break;
        }
        //cuts down size of move array to only have the number of possible moves
        int[][] finaleMoves = new int[count][2];
        super.allMoves(finaleMoves);
        newMoves(finaleMoves);
    } 

    /**
     * @param the chessboard because the value of a piece depend on the position of other pieces.
     * @return the value of the chessPiece
     */
    public double evaluate(ChessPiece[][] board)
    {
        double value = 3.1;
        if(getIsWhite())
        {
            return value;
        }
        else
        {
            return value*-1;
        }
    }

    public String toString()
    {
        if(getIsWhite())
            return "ChessPieceIcons/WhiteBishop.png";
        else
            return "ChessPieceIcons/BlackBishop.png";
    }
}
