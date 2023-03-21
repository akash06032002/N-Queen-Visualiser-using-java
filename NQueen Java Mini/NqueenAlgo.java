
import java.util.*;
// import java.lang.*;
public class NqueenAlgo
{
  static int N = 14;
//   static int[][] board={{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }};
  static int[][] board = new int[N][N];

  public static void setN (int n)
  {
    N = n;
  }

  public static void initializeBoard ()
  {
    for (int row = 0; row < N; row++)
      {
	for (int col = 0; col < N; col++)
	  {
	    board[row][col] = 0;
	  }
      }
  }
  public static boolean isSafe (int row, int col)
  {

    for (int i = 0; i < col; i++)	//to check if prev queens are placed in the same row
      {
	if (board[row][i] == 1)
	  return false;
      }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)	//to check if prev queens are there in the upper diag of the current queen
      {
	if (board[i][j] == 1)
	  return false;
      }

    for (int i = row, j = col; i >= 0 && j >= 0 && i < N; i++, j--)	//to check if prev queens are there in the lower diag of the current queen
      {
	if (board[i][j] == 1)
	  return false;
      }
    return true;
  }

  static boolean solveRecNQueen (int col)
  {
    if (col == N)
      return true;

    for (int i = 0; i < N; i++)
      {

	if (isSafe (i, col))
	  {
	    board[i][col] = 1;	//placing quuen as it is safe posn to do so
	    if (solveRecNQueen (col + 1) == true)
	      return true;
	    else
	      board[i][col] = 0;	//removing queen as solveRecNQueen(col+1) returned false
	  }
      }

    return false;		//as we placed queen everywhere and ntg returned true;
  }

  static boolean solve ()
  {
    if (solveRecNQueen (0) == false)
      {
	System.out.println ("No solution exists");
	return false;
      }
    else
      {
	printBoard (board);
	return true;
      }
  }

  static void printBoard (int[][]board)
  {
    for (int row = 0; row < N; row++)
      {
	for (int col = 0; col < N; col++)
	  {
	    System.out.print (" " + board[row][col] + " ");
	  }
	System.out.println ();
      }
  }

  public static void main (String[] args)
  {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt ();
    NqueenAlgo.setN (n);
    NqueenAlgo.initializeBoard ();	//to initialize board[][]
    NqueenAlgo.solve ();
//              System.out.println(board[N][N]);

   sc.close();
  }
}
