package CapitalizeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CapitalizeClient {
	private static Socket socket;

	public static void main(String[] args) {

		try {
			// Make connection to the server
			socket = new Socket("localhost", 9090);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Receive the message from server
			log("First message: " + in.readLine());

			// Send a message to server
			String message = "This is message from the client.";
			out.println(message);

			// Receive the capitalized message
			log("Message received: " + in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void log(String args) {
		System.out.println(args);
	}
}
