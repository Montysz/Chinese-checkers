package chinese_checkers.serwer;
/**
 * 
 * @author Pawel
 *
 */
public class Board {
	final int n = -1;
	/**
	 * board with players' pices
	 */
	protected Tile[][] gameBoard;
	/**
	 * default Board
	 */
	public Board()
	{
		int[][] board = {   {n,n,n,n,n,n,1,n,n,n,n,n,n},
							 {n,n,n,n,n,1,1,n,n,n,n,n,n},
							{n,n,n,n,n,1,1,1,n,n,n,n,n},
							 {n,n,n,n,1,1,1,1,n,n,n,n,n},
							{6,6,6,6,0,0,0,0,0,2,2,2,2},
							 {6,6,6,0,0,0,0,0,0,2,2,2,n},
							{n,6,6,0,0,0,0,0,0,0,2,2,n},
							 {n,6,0,0,0,0,0,0,0,0,2,n,n},
							{n,n,0,0,0,0,0,0,0,0,0,n,n},
							 {n,5,0,0,0,0,0,0,0,0,3,n,n},
							{n,5,5,0,0,0,0,0,0,0,3,3,n},
							 {5,5,5,0,0,0,0,0,0,3,3,3,n},
							{5,5,5,5,0,0,0,0,0,3,3,3,3},
							 {n,n,n,n,4,4,4,4,n,n,n,n,n},
							{n,n,n,n,n,4,4,4,n,n,n,n,n},
							 {n,n,n,n,n,4,4,n,n,n,n,n,n},
							{n,n,n,n,n,n,4,n,n,n,n,n,n},
														};
		
		for(int i = 0; i < 17; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				
			}
		}
	}
	/**
	 * constructor of Board class
	 * @param boardSize
	 * 	size of the board
	 * @param players
	 * 	number of players
	 */
	public Board(int boardSize, int players)
	{
		
		
	}
}
