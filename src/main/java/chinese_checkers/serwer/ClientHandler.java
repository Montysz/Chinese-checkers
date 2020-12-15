package chinese_checkers.serwer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import chinese_checkers.Exceptions.cantGetOutOfTheJaillException;
import chinese_checkers.Exceptions.invalidMoveException;
import chinese_checkers.Exceptions.occupiedException;
import chinese_checkers.Exceptions.outOfTheBoardException;

public class ClientHandler extends Thread{
	Socket socket;
	Server server;
	DataInputStream DIS;
	DataOutputStream DOS;
	int clientId;
	boolean hasWon = false;
	boolean shouldRun = true;
	boolean isReady = false;
	public ClientHandler(Socket socket, Server server, int clientId)
	{
		super("ServerConnectionThread");
		this.socket = socket;
		this.server = server;
		this.clientId = clientId;
	}
	
	public void sendStringToClient(String text)
	{
		try
		{
			DOS.writeUTF(text);
			DOS.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendStringToAllClients(String text)
	{
		for(ClientHandler s : server.clients)
		{
			s.sendStringToClient(text);
		}
	}
	
	public void run()
	{
		try
		{
			DIS = new DataInputStream(socket.getInputStream());
			DOS = new DataOutputStream(socket.getOutputStream());
			
			sendStringToClient("Welcome, your id is: " + clientId );
			
			while(shouldRun)
			{
				while(DIS.available() == 0)
				{
					try
					{
						Thread.sleep(1);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				
				String text = DIS.readUTF();
				if(text.startsWith("quit"))
				{
					if(!hasWon)
					{
						
					}
				}
				else if(text.startsWith("move"))
				{
					int index = Integer.parseInt(text.substring(text.indexOf(" ")));
					int x = Integer.parseInt(text.substring(index, index+1));
					int y = Integer.parseInt(text.substring(index+2, index+3));
					int newX = Integer.parseInt(text.substring(index+4, index+5));
					int newY = Integer.parseInt(text.substring(index+6, index+7));
					int playerId = clientId;
					try
					{
						server.gameBoard.movePiece(x, y, newX, newY, playerId);
					}
					catch (occupiedException e) 
					{
						sendStringToClient("Invalid move, the space is occupied");
						e.printStackTrace();
					}
					catch (invalidMoveException e)
					{
						sendStringToClient("Invalid move");
						e.printStackTrace();
					}
					catch (outOfTheBoardException e)
					{
						sendStringToClient("Invalid move, cannot move out of the board");
						e.printStackTrace();
					} 
					catch (cantGetOutOfTheJaillException e)
					{
						sendStringToClient("Invalid move, cannot move out of the winning tile");
						e.printStackTrace();
					}
				}
				else
				{
					sendStringToClient(text + " is not a vallid call");
				}
				
				
				
			}
			DIS.close();
			DOS.close();
			socket.close();
		}
		catch(IOException e)
		{
			System.err.println("IO error");
			System.err.println(e.getStackTrace());
		}
	}
	
	public void setClientId(int id)
	{
		this.clientId = id;
	}
}
