package chinese_checkers.serwer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chinese_checkers.Exceptions.wrongNumberOfPlayersException;


/**
 * 
 * @author Szymon
 *
 */

public class Server extends Thread {
	
	ServerSocket serverSocket;
	ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
	boolean shoutldRun = true;
	boolean gameStarted = false;
	boolean gameFinished = false;
	int numberOfClients = 0;
	Board gameBoard = null;
	public static void main(String[] args)
	{
		new Server();
	}
		
	public Server()
	{
		try
		{
			serverSocket = new ServerSocket(8080);
			System.out.println("[Server] Starting server...");
			while(shoutldRun)
			{
				if(numberOfClients < 6 && !gameStarted)
				{
					System.out.println("[Server] looking for players to join");
					numberOfClients++;
					Socket s = serverSocket.accept();
					System.out.println("[Server] new player with id " + numberOfClients + " has joing the game");
					ClientHandler client = new ClientHandler(s, this, numberOfClients);
					client.start();
					clients.add(client);
				}
				else if(gameStarted)
				{
					System.out.println("[Server] trying to start the game with " + numberOfClients + " players");
					try
					{
						this.gameBoard = new Board(numberOfClients);
					}
					catch (wrongNumberOfPlayersException e)
					{
						System.err.println("Cannot start the game with " + numberOfClients + " players");
						gameStarted = false;
					}
					if(!gameFinished && gameBoard!=null)
					{
						System.out.println("[Server] game has succesfuly started with " + numberOfClients + " players");
					}
					while(!gameFinished && gameBoard!=null)
					{
						
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}














