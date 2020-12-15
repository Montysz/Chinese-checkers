package chinese_checkers.serwer;

import java.io.BufferedReader;
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


/**
 * 
 * @author Szymon
 *
 */

public class Server extends Thread {
	
	private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
	private static int numberOfConnections = 0;
	private static boolean gameStarted = false;
	private static ExecutorService pool = Executors.newFixedThreadPool(6);
	
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(8080);
		
		System.out.println("[SERVER] Starting server...");
		
		while (numberOfConnections<6)
		{
			System.out.println("[SERVER] Waiting for client connection");
			Socket client = listener.accept();
			numberOfConnections++;
			System.out.println("[SERVER] Connected client number " + numberOfConnections);
			ClientHandler clientThread = new ClientHandler(client, numberOfConnections);
			clients.add(clientThread);
			
			pool.execute(clientThread);
		}
		
		
	} 
}