package Caro;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

	XuLy p1, p2;
	List<Point> dadanh = new ArrayList<>();
	int so = 10;

	public Server() {
		try {
			ServerSocket server = new ServerSocket(5000);
			p1 = new XuLy(this, server.accept());
			p1.start();
			p2 = new XuLy(this, server.accept());
			p2.start();
		} catch (Exception e) {

		}
	}
}

class XuLy extends Thread {
	Server server;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public XuLy(Server server, Socket s) {
		this.server = server;
		this.s = s;
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				System.out.println("chuan bi nhan");
				int xi = Integer.parseInt(dis.readUTF());
				int yi = Integer.parseInt(dis.readUTF());
				System.out.println(xi + "," + yi);
				if (server.p1 == null || server.p2 == null)
					continue;

				if (this == server.p1 && server.dadanh.size() % 2 == 1)
					continue;
				if (this == server.p2 && server.dadanh.size() % 2 == 0)
					continue;

				if (xi < 0 || xi >= server.so || yi < 0 || yi >= server.so) {
					continue;
				}
				boolean trung = false;
				for (int i = 0; i < server.dadanh.size(); i++) {
					int oldxi = server.dadanh.get(i).x;
					int oldyi = server.dadanh.get(i).y;
					if (xi == oldxi && yi == oldyi) {
						trung = true;
						break;
					}
				}
				if (trung)
					continue;
				// Kiem tra luot danh

				// Thong bao cho tat ca 2 client rang co toa do moi danh
				server.p1.dos.writeUTF("" + xi);
				server.p1.dos.writeUTF("" + yi);
				server.p2.dos.writeUTF("" + xi);
				server.p2.dos.writeUTF("" + yi);

				server.dadanh.add(new Point(xi, yi));
			} catch (Exception e) {

			}
		}
	}
}
