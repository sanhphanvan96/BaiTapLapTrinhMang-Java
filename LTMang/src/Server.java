import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(2500);
			while(true) {
				try {
					Socket soc = server.accept();
					DataInputStream dis = new DataInputStream(soc.getInputStream());
					DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
					String request = dis.readUTF();
					if (request.equals("Hello")) {
						dos.writeUTF("Chao ban");
					} else {
						dos.writeUTF("Bye bye");
					}
					soc.close();
				} catch (Exception e) {
					
				}
			}
		} catch(Exception e) {
			
		}
	}

}
