package SocketExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String serverAddress = "localhost";
		Socket socket = new Socket(serverAddress, 9090);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String res = buffer.readLine();
		log("Response " + res);
		System.exit(0);
	}

	public static void log(String args) {
		System.out.println(args);
	}
}
