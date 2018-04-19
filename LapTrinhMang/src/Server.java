import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server {

	public static void main(String[] args) {
		
		try {
			java.net.ServerSocket server = new java.net.ServerSocket(2501);
			while (true) {
				try {
					java.net.Socket soc = server.accept();
					DataInputStream dis = new DataInputStream(soc.getInputStream());
					DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
					String request  = dis.readUTF();
					
					if (request.equals("hello")) {
						dos.writeUTF("Chao ban");
					} else {
						dos.writeUTF("coincard");
					}
					soc.close();
					server.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
