package chinese_checkers.serwer;

import chinese_checkers.Exceptions.invalidMoveException;
import chinese_checkers.Exceptions.occupiedException;
import chinese_checkers.Exceptions.outOfTheBoardException;
/**
 * 
 * @author Pawel
 *
 */
public interface Rules {
	/**
	 * checking if the given movment is possible given the ruleset
	 * @param x
	 * 	initial x coordinate
	 * @param y
	 * 	initial y coordinate
	 * @param newX
	 *  new x coordinate
	 * @param newY
	 * 	new y coordinate
	 * @param playerId
	 * 	id of a player suposed to move
	 * @param gameBoard
	 * 	current state of a game 
	 * @return
	 * 	true if the piece is able to move in given tile on specific rule set
	 * @throws occupiedException
	 * 	if the tile to move is occupied
	 * @throws invalidMoveException
	 * 	if the move is invalid
	 * @throws outOfTheBoardException
	 * 	if the move goes out of the board
	 */
	public boolean movePiece(int x, int y, int newX, int newY, int playerId, Tile[][] gameBoard) throws occupiedException, invalidMoveException, outOfTheBoardException;
	/**
	 * 
	 * @param playerId
	 * 	id of a player
	 * @param gameBoard
	 * 	current board state
	 * @return
	 * 	true if a player with given id has won the game, false otherwise
	 */
	public boolean hasWon(int playerId, Tile[][] gameBoard);
}
