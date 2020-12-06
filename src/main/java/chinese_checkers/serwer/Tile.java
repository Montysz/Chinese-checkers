package chinese_checkers.serwer;
/**
 * 
 * @author Pawel
 *
 */
public class Tile {
	private int xCord;
	private int yCord;
	private int playerId;
	private int isWiningFor;
	/**
	 * Checking if a tile has a piece in it
	 * @return
	 * 	true if no player occupies this tile, false otherwise
	 */
	public boolean isEmpty()
	{
		if(this.playerId == 0)return true;
		else return false;
	}
	/**
	 * Tile constructor
	 * @param xCord
	 * 	x-coordinate of a tile
	 * @param yCord
	 * 	y-coordinate of a tile
	 * @param playerId
	 * 	id of a player with piece in this tile, 0 if no player has his piece in this tile
	 * @param isWiningFor
	 * 	id of a player with needs to have his piece in this tile in order to win the game
	 */
	public Tile(int xCord, int yCord, int playerId, int isWiningFor)
	{
		this.xCord = xCord;
		this.yCord = yCord;
		this.playerId = playerId;
		this.isWiningFor = isWiningFor;
	}
}
