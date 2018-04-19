package DateTimeServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

public class DateTimeServer extends Thread {
	Vector<XuLy> vec = new Vector<>();
	int count = 0;
	
	public DateTimeServer() {
		
		try {
			ServerSocket theServer = new ServerSocket(5000);
			this.start();
			while (true) {
				Socket theConnection = theServer.accept();
				// ---------
				XuLy x = new XuLy(theConnection, this);
				vec.add(x);
				

				// ---------
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100); // Khong sleep se chet, ko nen cho no giam
									// sat lien tuc
				while (count < 1000) {
					XuLy x = vec.remove(0);
					if (x == null)
						break;
					count++;
					x.start();
				}
			} catch (Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		new DateTimeServer();
	}

	
}
class XuLy extends Thread {
	Socket soc;
	DateTimeServer ser;

	public XuLy(Socket soc, DateTimeServer ser) {
		this.soc = soc;
		this.ser = ser;
	}

	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			String time = new Date().toString();
			dos.writeUTF(time);
			ser.count--;
			soc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
