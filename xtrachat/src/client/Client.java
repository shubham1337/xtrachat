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
		System.out.println("Making a request to localhost:1337");
		c.send();
	}

	void send()
	{
		try
		{
			client_socket = new Socket("127.0.0.1", 1337);
			System.out.println("Connection Established");
			
			writer = new PrintWriter(client_socket.getOutputStream());
			while(true)
			{
				Scanner in = new Scanner(System.in);
				System.out.print("Send: ");
				String text;
				text = in.nextLine();
				writer.println(text + "\n");
				writer.flush();

				//Exiting the loop when user enters exit
				if (text.equals("exit"))
				{
					break;
				}
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

