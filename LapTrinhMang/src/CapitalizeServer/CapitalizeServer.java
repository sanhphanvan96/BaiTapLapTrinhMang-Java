package CapitalizeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CapitalizeServer {

	public static void main(String[] args) throws IOException {
		int clientNumber = 0;
		int port = 9090;
		ServerSocket listener = new ServerSocket(port);
		log("Server is running at port " + port + ", waiting for connection ...");
		try {
			while (true) {
				// Create new thread for each request/client
				new CapitalizerServer(listener.accept(), clientNumber++).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			listener.close();
		}
	}

	private static class CapitalizerServer extends Thread {
		private Socket socket;
		private int clientNumber;

		public CapitalizerServer(Socket socket, int clientNumber) {
			this.socket = socket;
			this.clientNumber = clientNumber;
			log("New connection with client#" + clientNumber + " at " + socket);
		}

		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // auto push

				// Send welcome message to client
				out.println("Hello, you are client#" + clientNumber + ".");

				// Get message from the client, line by line; return them capitalized
				while (true) {
					String input = in.readLine();
					log("input => " + input);
					if (input == null || input.equals(".")) {
						break;
					}
					// Return capitalized string
					out.println(input.toUpperCase());
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void log(String args) {
		System.out.println(args);
	}
}
