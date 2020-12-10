package chinese_checkers.server;

import static org.junit.Assert.*;

import org.junit.Test;

import chinese_checkers.Exceptions.invalidMoveException;
import chinese_checkers.Exceptions.occupiedException;
import chinese_checkers.Exceptions.outOfTheBoardException;
import chinese_checkers.Exceptions.wrongNumberOfPlayersException;
import chinese_checkers.serwer.Board;
import chinese_checkers.serwer.Tile;

public class BoardTest {

	@Test
	public void testNumberOfPlayers() throws wrongNumberOfPlayersException {
		Board gameBoard = new Board(6);
		assertEquals(6, gameBoard.numberOfPlayers);
	}
	@Test(expected = wrongNumberOfPlayersException.class)
	public void testWrongNumberOfPlayersException1() throws wrongNumberOfPlayersException
	{
		Board gameBoard = new Board(5);
		
	}
	
	@Test(expected = wrongNumberOfPlayersException.class)
	public void testWrongNumberOfPlayersException2() throws wrongNumberOfPlayersException
	{
		Board gameBoard = new Board(10);
		
	}
	//TODO: test jump moves
	@Test
	public void testBasicMove() throws wrongNumberOfPlayersException, occupiedException, invalidMoveException, outOfTheBoardException
	{
		Board gameBoard = new Board(6);
		int playerId = gameBoard.findTile(7, 3).getPlayerId();
		assertTrue(gameBoard.movePiece(7, 3, 7, 4, 1)); //vallid move, should have moved 
		assertNotEquals(playerId, gameBoard.findTile(7, 3).getPlayerId()); // check if it in fact moved
	}
	
	@Test(expected = occupiedException.class)
	public void testBasicMove2() throws wrongNumberOfPlayersException, occupiedException, invalidMoveException, outOfTheBoardException
	{
		Board gameBoard = new Board(6);
		gameBoard.movePiece(6, 0, 6, 1, 1);
	}
	
	@Test(expected = invalidMoveException.class)
	public void testBasicMove3() throws wrongNumberOfPlayersException, occupiedException, invalidMoveException, outOfTheBoardException
	{
		Board gameBoard = new Board(6);
		gameBoard.movePiece(7, 3, 9, 9, 1);
	}
	
	@Test(expected = invalidMoveException.class)
	public void testBasicMove4() throws wrongNumberOfPlayersException, occupiedException, invalidMoveException, outOfTheBoardException
	{
		Board gameBoard = new Board(6);
		gameBoard.movePiece(7, 3, 6, 4, 1);
	}
}
