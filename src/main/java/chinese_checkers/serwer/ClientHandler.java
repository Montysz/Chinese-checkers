package chinese_checkers.serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private int playerId;
	public ClientHandler(Socket clientSocket, int playerId) throws IOException
	{
		this.client = clientSocket;
		out = new PrintWriter(client.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out.println("playerId: " + playerId);
		this.playerId = playerId;
	}
	public void run() {
		try
		{
			while (true)
			{
				String request = in.readLine();
				out.println(request + " nie wiem co z tym zrobic XD");
			}
		}
		catch (IOException e)
		{
			System.err.println("IOException in ClientHandler");
			System.err.println(e.getStackTrace());
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				System.err.println("IOException in ClientHandler");
				System.err.println(e.getStackTrace());
			}
			out.close();
		}
	}

}
