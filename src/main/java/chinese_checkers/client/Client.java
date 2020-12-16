package chinese_checkers.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket socket;
	DataInputStream DIS;
	DataOutputStream DOS;
	public static void main(String[] args)
	{
		new Client();
	}

	public Client()
	{
		try
		{
			socket = new Socket("localhost", 8080);
			DIS = new DataInputStream(socket.getInputStream());
			DOS = new DataOutputStream(socket.getOutputStream());
			
			listenForInput();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
 	}
	
	public void listenForInput()
	{
		
		while(true)
		{
			String input ="ping";
			try
			{
				DOS.writeUTF(input);
				DOS.flush();
				
				while(DIS.available() == 0)
				{
					try
					{
						Thread.sleep(1);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				
				String reply = DIS.readUTF();
				if(reply.startsWith("curMove"))
				{
					System.out.println("Its player "+ reply.substring(reply.indexOf(" ")) + " turn" );
				}
				else if(reply.startsWith("ping"))
				{
					DOS.writeUTF("pong");
					DOS.flush();
				}
				else if(reply.startsWith("readyCheck"))
				{
					String keyBoard = listenForKeyBoard();
					DOS.writeUTF(keyBoard);
					DOS.flush();
					if(keyBoard.startsWith("quit"))break;
				}
				else if(reply.startsWith("pong"))
				{
					
				}
				else
				{
					System.out.println(reply);
				}
					
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		try
		{
			DOS.close();
			DIS.close();
			socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String listenForKeyBoard()
	{
		System.out.println("Input needed:");
		Scanner console = new Scanner(System.in);
		while(!console.hasNext())
		{
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return console.nextLine();
	}
}


