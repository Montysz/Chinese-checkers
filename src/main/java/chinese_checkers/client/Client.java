package chinese_checkers.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import chinese_checkers.serwer.Board;

//class of Client
public class Client {
	private static final String Server_IP = "localhost";
	private static final int Server_Port = 8080;
	private static int playerId;
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket(Server_IP, Server_Port);
		BufferedReader input =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		while(true)
		{
			String serverResponse = input.readLine();	
			if(!serverResponse.equals(""))
			{
				System.out.println("[Server]" + serverResponse);
				if(serverResponse.startsWith("PlayerId:"))
				{
					playerId = Integer.parseInt(serverResponse.substring(serverResponse.indexOf(" ")));
				}
				
			}
			String command = keyBoard.readLine();
			if(!command.equals(""))
			{
				if(command.equals("quit")) break;
				out.print(command);
			}
		}
		out.println("quit");
		System.out.println("quitting");
		input.close();
		keyBoard.close();
	}

}


