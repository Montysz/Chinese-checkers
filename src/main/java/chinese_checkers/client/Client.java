package chinese_checkers.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client extends Thread {
	Socket socket;
	BufferedReader in;
	BufferedReader keyboard;
	PrintWriter out;
	ExecutorService listener = Executors.newFixedThreadPool(2);
	public static void main(String[] args)
	{
		new Client();
	}

	public Client()
	{
		try
		{
			socket = new Socket("localhost", 8080);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			listener.execute(this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
 	}
	public void run()
	{
		while(true)
		{
			try
			{
				String input;
				String typed;
				if(in.ready())
				{
					input = in.readLine();
					System.out.println(input);
				}
				if(keyboard.ready())
				{
					 typed = keyboard.readLine();
					 out.println(typed);
					 out.flush();
					 if(typed.equals("quit"))break;
				}
				Thread.sleep(10);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			in.close();
			out.close();
			keyboard.close();
			socket.close();
			listener.shutdown();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}


