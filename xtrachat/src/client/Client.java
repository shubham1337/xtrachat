//A simple client for xtrachat

import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
		
	Socket client_socket;
	PrintWriter writer;

	public static void main (String[] args)
	{
		Client c = new Client();
		System.out.println("Client Started...");
		System.out.println("Making a request at localhost:1337");
		c.send();
	}

	void send()
	{
		try
		{
			client_socket = new Socket("127.0.0.1", 1337);
			
			writer  = new PrintWriter(client_socket.getOutputStream());
			System.out.println("Connection Established");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

