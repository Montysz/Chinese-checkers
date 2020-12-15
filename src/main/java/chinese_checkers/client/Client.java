package chinese_checkers.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//class of Client
public class Client {
	private static final String Server_IP = "localhost";
	private static final int Server_Port = 2137;
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket(Server_IP, Server_Port);
		BufferedReader input =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		while(true)
		{
			//System.out.print(">");
			String serverResponse = input.readLine();	
			System.out.println(serverResponse);
			
			String command = keyBoard.readLine();
			
			if(command.equals("quit")) break;
			
			out.print(command);
			
			serverResponse = input.readLine();	
			System.out.println("Server: " + serverResponse);
		}
	}

}


