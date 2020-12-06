package chinese_checkers.serwer;

import chinese_checkers.Exceptions.wrongNumberOfPlayersException;

/**
 * 
 * @author Pawel
 *
 */
public class Board {
	private final int n = -1;
	/**
	 * board with players' pices
	 */
	protected Tile[][] gameBoard;
	protected int numberOfPlayers;
	/**
	 * 
	 * @param numberOfPlayers
	 * 	number of players playing on the board. can be only 2, 3, 4 or 6
	 * @throws wrongNumberOfPlayersException
	 * 	if number pf players is not 2, 3, 4 or 6 throws an exception
	 */
	public Board(int numberOfPlayers) throws wrongNumberOfPlayersException
	{
		if(numberOfPlayers != 2 && numberOfPlayers != 3 && numberOfPlayers != 4 && numberOfPlayers != 6)
		{
			throw new wrongNumberOfPlayersException();
		}
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
		this.numberOfPlayers = numberOfPlayers;
		this.gameBoard = new Tile[17][13];
		for(int i = 0; i < 17; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(numberOfPlayers == 2)
				{
					if(board[i][j] == 1)
					{
						this.gameBoard[i][j] = new Tile(j, i, 1, 2);
					}
					else if (board[i][j] == 4)
					{
						this.gameBoard[i][j] = new Tile(j, i, 2, 1);
					}
					else if (board[i][j] == -1)
					{
						this.gameBoard[i][j] = new Tile(j, i, -1, -1);
					}
					else
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 0);
					}
				}
				else if(numberOfPlayers == 3)
				{
					if(board[i][j] == 1)
					{
						this.gameBoard[i][j] = new Tile(j, i, 1, 0);
					}
					else if (board[i][j] == 2)
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 2);
					}
					else if (board[i][j] == 3)
					{
						this.gameBoard[i][j] = new Tile(j, i, 3, 0);
					}
					else if (board[i][j] == 4)
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 1);
					}
					else if (board[i][j] == 5)
					{
						this.gameBoard[i][j] = new Tile(j, i, 5, 0);
					}
					else if (board[i][j] == 6)
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 5);
					}
					else if (board[i][j] == -1)
					{
						this.gameBoard[i][j] = new Tile(j, i, -1, -1);
					}
					else
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 0);
					}
				}
				else if(numberOfPlayers == 4)
				{
					if(board[i][j] == 1)
					{
						this.gameBoard[i][j] = new Tile(j, i, 1, 4);
					}
					else if (board[i][j] == 2)
					{
						this.gameBoard[i][j] = new Tile(j, i, 2, 5);
					}
					else if (board[i][j] == 4)
					{
						this.gameBoard[i][j] = new Tile(j, i, 4, 1);
					}
					else if (board[i][j] == 5)
					{
						this.gameBoard[i][j] = new Tile(j, i, 5, 2);
					}
					else if (board[i][j] == -1)
					{
						this.gameBoard[i][j] = new Tile(j, i, -1, -1);
					}
					else
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 0);
					}
				}
				else if(numberOfPlayers == 6)
				{
					if(board[i][j] == 1)
					{
						this.gameBoard[i][j] = new Tile(j, i, 1, 4);
					}
					else if (board[i][j] == 2)
					{
						this.gameBoard[i][j] = new Tile(j, i, 2, 5);
					}
					else if (board[i][j] == 3)
					{
						this.gameBoard[i][j] = new Tile(j, i, 3, 6);
					}
					else if (board[i][j] == 4)
					{
						this.gameBoard[i][j] = new Tile(j, i, 4, 1);	
					}
					else if (board[i][j] == 5)
					{
						this.gameBoard[i][j] = new Tile(j, i, 5, 2);
					}
					else if (board[i][j] == 6)
					{
						this.gameBoard[i][j] = new Tile(j, i, 6, 3);
					}
					else if (board[i][j] == -1)
					{
						this.gameBoard[i][j] = new Tile(j, i, -1, -1);
					}
					else
					{
						this.gameBoard[i][j] = new Tile(j, i, 0, 0);
					}
				}
				else
				{
					throw new wrongNumberOfPlayersException();
				}
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
		//TODO: implement constructor for difrent boards and games 
	}
}
