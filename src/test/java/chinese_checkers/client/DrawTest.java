package chinese_checkers.client;

import static org.junit.Assert.*;

import org.junit.Test;

import chinese_checkers.Exceptions.cantGetOutOfTheJaillException;
import chinese_checkers.Exceptions.invalidMoveException;
import chinese_checkers.Exceptions.occupiedException;
import chinese_checkers.Exceptions.outOfTheBoardException;
import chinese_checkers.Exceptions.wrongNumberOfPlayersException;
import chinese_checkers.serwer.Board;

public class DrawTest {

	@Test
	public void DrawTest1() throws wrongNumberOfPlayersException, occupiedException, invalidMoveException, outOfTheBoardException, cantGetOutOfTheJaillException
	{
		Board gameBoard = new Board(6);
		gameBoard.movePiece(7, 3, 8, 4, 1);
		gameBoard.movePiece(6, 3, 6, 4, 1);
		assertEquals(2,gameBoard.movePiece(9, 4, 7, 4, 2));
		assertEquals(2,gameBoard.movePiece(7, 4, 5, 4, 2));
		assertEquals(0, gameBoard.findTile(7, 4).getPlayerId());
		
		assertEquals(2, gameBoard.findTile(5, 4).getPlayerId());
		//TODO: zrób ¿eby dzia³a³o
		Draw draw = new Draw(gameBoard);
		draw.repaint();
	}

}
