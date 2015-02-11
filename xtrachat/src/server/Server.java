//basic server without threading
//package server;

import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
		
	public static void main (String[] args)
	{
		Server s = new Server();
		System.out.println("Server Started...");
		s.listen();
		System.out.println("Listening at port 1337...");
	}

	void listen()
	{
		try
		{
			ServerSocket server_socket = new ServerSocket(1337);
			
			while(true)
			{
				Socket client_socket = server_socket.accept();
				PrintWriter writer  = new PrintWriter(client_socket.getOutputStream());
				System.out.println("Connected to a client...");

				writer.println("Connected");
				writer.close();
				//based on input string or button event call other method for chat room etc.   
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
