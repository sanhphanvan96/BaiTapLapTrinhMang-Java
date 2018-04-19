import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Socket {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Input data: ");
			String hn = sc.nextLine();
			java.net.Socket soc = new java.net.Socket(hn, 2501);
			
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			dos.writeUTF("hello");
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			System.out.println(dis.readUTF());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
