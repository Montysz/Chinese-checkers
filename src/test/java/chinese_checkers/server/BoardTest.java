package chinese_checkers.server;

import static org.junit.Assert.*;

import org.junit.Test;

import chinese_checkers.Exceptions.wrongNumberOfPlayersException;
import chinese_checkers.serwer.Board;

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
}
