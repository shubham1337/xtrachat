package xtrachat.src.server;
//added basic threading

import java.net.*;
import java.util.*;
import java.io.*;

public class Server {

	void listen()
	{
		try
		{
			ServerSocket server_socket = new ServerSocket(1337);

			while(true)
			{
				System.out.println("Waiting for a client to connect...");
				Socket client_socket = server_socket.accept();
				System.out.println("Connected to a client...");
				Thread t1 = new Thread(new ClientHandler(client_socket));
				//new thread for each client
				t1.start();

				//PrintWriter writer  = new PrintWriter(client_socket.getOutputStream());
				//writer.println("Connected");
				//writer.close();

				//Reading from client_socket
				/*while(true)
				{
					BufferedReader in = 
						new BufferedReader(new InputStreamReader(client_socket.getInputStream()));

					String text = in.readLine();
					System.out.println("Recieved: " + text);

					if (text.equals("exit"))
					{
						break;
					}
				}*/

				//based on input string or button event call other method for chat room etc.   
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
		
	public static void main (String[] args)
	{
		Server s = new Server();
		System.out.println("Server Started...");
		s.listen();
		System.out.println("Listening at port 1337...");
	}

}
