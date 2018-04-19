import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner	sc = new Scanner(System.in);
			String hn = sc.nextLine();
			Socket soc = new Socket(hn, 2500);
			
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			dos.writeUTF("Hello");
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			System.out.println(dis.readUTF());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error!");
		}
	}

}
