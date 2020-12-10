package chinese_checkers.serwer;

import chinese_checkers.Exceptions.invalidMoveException;
import chinese_checkers.Exceptions.occupiedException;
import chinese_checkers.Exceptions.outOfTheBoardException;
/**
 * 
 * @author Pawel
 *
 */
public class DefaultRules implements Rules {
	/**
	 * x-size of the board
	 */
	private int xSize;
	/**
	 * y-size of the board
	 */
	private int ySize;
	/**
	 * 
	 * @param x
	 * 	x-size of the board
	 * @param y
	 *  y-size of the board
	 */
	public DefaultRules(int x, int y)
	{
		this.xSize = x;
		this.ySize = y;
	}
	
	public boolean movePiece(int x, int y, int newX, int newY, int playerId, Tile[][] gameBoard) throws occupiedException, invalidMoveException, outOfTheBoardException
	{
		if(newX > xSize || newY > ySize)throw new outOfTheBoardException();
		if(!gameBoard[newY][newX].playable())throw new outOfTheBoardException();
		if(!gameBoard[newY][newX].isEmpty())throw new occupiedException();
		if(gameBoard[y][x].getPlayerId() != playerId)throw new invalidMoveException();
		if(gameBoard[y][x].isWinning() && gameBoard[newY][newX].getWinningId() != playerId)throw new invalidMoveException();
		int dX = newX - x;
		int dY = newY - y;
		/*
		 * moves are diffrend base on the row, check that first
		 * allowed moves like:  x+1, x-1, y+1,     y-1,     y-1 x-1, y+1 x-1
		 * and jump moves like: x+2, x-2, y+2 x+1, y-2 x+1, y-2 x-1, y+2 x-1  
		 * for jump moves check if corresponding tile is occupied
		 */
		if(y%2 == 0)
		{
			if(dX == 1 && dY == 0)//x+1
			{
				return true;
			}
			else if(gameBoard[y][x+1].playable() && !gameBoard[y][x+1].isEmpty() && dX == 2 && dY == 0)//jump x+2
			{
				
				return true;
			}
			else if(dX == -1 && dY == 0)//x-1
			{
				return true;
			}
			else if(gameBoard[y][x-1].playable() && !gameBoard[y][x-1].isEmpty() && dX == -2 && dY == 0)//jump x-2
			{
				return true;
			}
			else if(dY == 1 && dX == 0)//y+1
			{
				return true;
			}
			else if(gameBoard[y+1][x].playable() && !gameBoard[y+1][x].isEmpty() && dX == 1 && dY == 2)//jump y+2 x+1
			{
				return true;
			}
			else if(dY == -1 && dX == 0)//y-1
			{
				return true;
			}
			else if(gameBoard[y-1][x].playable() && !gameBoard[y-1][x].isEmpty() && dX == 1 && dY == -2)//jump y-2 x+1
			{
				return true;
			}
			else if((dX == -1) && (dY == -1) )//y-1 x-1
			{
				return true;
			}
			else if(gameBoard[y-1][x-1].playable() && !gameBoard[y-1][x-1].isEmpty() && dX == -1 && dY == -2)//jump y-2 x-1
			{
				return true;
			}
			else if((dX == 1) && (dY == 1) )//y+1 x-1
			{
				return true;
			}
			else if(gameBoard[y+1][x+1].playable() && !gameBoard[y+1][x+1].isEmpty() && dX == -1 && dY == 2)//jump y+2 x-1
			{
				return true;
			}
			
			
			
		}
		/*
		 * allowed moves like:  x+1, x-1, y+1,     y-1,     y-1 x+1, y+1 x+1 
		 * and jump moves like: x+2, x-2, y+2 x-1, y-2 x-1, y-2 x+1, y+2 x+1
		 * for jump moves check if corresponding tile is occupied
		 */
		else if(y%2 == 1)
		{
			if(dX == 1 && dY == 0)//x+1
			{
				return true;
			}
			else if(gameBoard[y][x+1].playable() && !gameBoard[y][x+1].isEmpty() && dX == 2 && dY == 0)//jump x+2
			{
				return true;
			}
			else if(dX == -1 && dY == 0)//x-1
			{
				return true;
			}
			else if(gameBoard[y][x-1].playable() && !gameBoard[y][x-1].isEmpty() && dX == -2 && dY == 0)//jump x-2
			{
				return true;
			}
			else if(dY == 1 && dX == 0)//y+1
			{
				return true;
			}
			else if(gameBoard[y+1][x].playable() && !gameBoard[y+1][x].isEmpty() && dX == -1 && dY == 2)//jump y+2 x-1
			{
				return true;
			}
			else if(dY == -1 && dX == 0)//y-1
			{
				return true;
			}
			else if(gameBoard[y-1][x].playable() && !gameBoard[y-1][x].isEmpty() && dX == -1 && dY == -2)//jump y-2 x-1
			{
				return true;
			}
			else if((dX == 1) && (dY == -1) )//y-1 x+1
			{
				return true;
			}
			else if(gameBoard[y-1][x+1].playable() && !gameBoard[y-1][x+1].isEmpty() && dX == +1 && dY == -2)//jump y-2 x+1
			{
				return true;
			}
			else if((dX == 1) && (dY == 1) )//y+1 x+1
			{
				return true;
			}
			else if(gameBoard[y+1][x+1].playable() && !gameBoard[y+1][x+1].isEmpty() && dX == 1 && dY == 2)//jump y+2 x+1
			{
				return true;
			}
		}
		
		throw new invalidMoveException();
	}
	//for basic rules just assume that the piece count is 10;
	public boolean hasWon(int playerId, Tile[][] gameBoard) {
		int count = 0;
		for(int i = 0; i < ySize; i++)
		{
			for(int j = 0; j < xSize; j++)
			{
				if(gameBoard[i][j].getWinningId() == playerId)
				{
					count++;
				}
			}
		}
		if(count == 10)return true;
		return false;
	}
}
