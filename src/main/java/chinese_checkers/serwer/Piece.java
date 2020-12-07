package chinese_checkers.serwer;

import chinese_checkers.Exceptions.invalidMoveException;
/**
 * TODO: do wyrzucenia???
 * @author Pawel
 *
 */
public class Piece{
	
	private Tile tile;
	/**
	 * 
	 * @return
	 * 	x-coordinate of the piece
	 */
	public int getxCord()
	{
		return this.tile.getX();
	}
	/**
	 * 
	 * @return
	 * 	y-coordinate of the piece
	 */
	public int getyCord()
	{
		return this.tile.getY();
	}
	/**
	 * 
	 * @param newX
	 * 	x-coordinate of the new position
	 * @param newY
	 *  y-coordinate of the new position
	 * @return
	 * 	returns true if the given piece was succesfuly moved, otherwise throws invalidMoveException
	 */
	public boolean isWinning()
	{
		if(tile.getWinningId() == tile.getPlayerId())return true;
		else return false;
	}
}
