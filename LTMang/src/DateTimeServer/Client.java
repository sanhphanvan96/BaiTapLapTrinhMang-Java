package DateTimeServer;

import java.io.DataInputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket soc = new Socket("localhost", 5000);
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			System.out.println(dis.readUTF());
			soc.close();
		} catch(Exception e) {
			
		}
	}

}
