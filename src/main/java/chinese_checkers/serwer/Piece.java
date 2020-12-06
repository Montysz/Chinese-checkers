package chinese_checkers.serwer;

import chinese_checkers.Exceptions.invalidMoveException;
/**
 * 
 * @author Pawel
 *
 */
public class Piece {
	
	private int xCord;
	
	private int yCord;
	
	public int getxCord()
	{
		return this.xCord;
	}
	
	public int getyCord()
	{
		return this.yCord;
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
	public boolean movePiece(int newX, int newY) throws invalidMoveException
	{
		//TODO: implement piece movement rules
		return false;
	}
}
