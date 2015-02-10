//basic server without threading
package server;

import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
		
	void listen()
	{
		try
		{
			ServerSocket server_socket = new ServerSocket(4500);
			
			while(true)
			{
				Socket client_socket = server_socket.accept();
				PrintWriter writer  = new PrintWriter(client_socket.getOutputStream());
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
