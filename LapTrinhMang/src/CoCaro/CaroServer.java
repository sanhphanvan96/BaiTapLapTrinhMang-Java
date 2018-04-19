package CoCaro;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CaroServer {

	public static void main(String[] args) {
		new CaroServer();
	}

	XuLy p1, p2;
	List<Point> dadanh = new ArrayList<>();

	public CaroServer() {
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
	CaroServer server;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public XuLy(CaroServer sever, Socket s) {
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
		try {
			while (true) {
				int xi = Integer.parseInt(dis.readUTF());
				int yi = Integer.parseInt(dis.readUTF());
				if (xi < 0 || xi >= server.so || yi < 0 || yi >= server.so) {
					continue;
				}
				boolean trung = false;
				for (int i = 0; i < server.dadanh.size(); i++) {
					int oxi = server.dadanh.get(i).x;
					int oyi = server.dadanh.get(i).y;
					if (xi == oxi || yi == oyi) {
						trung = true;
						break;
					}
				}
				if (trung)
					continue;
				server.dadanh.add(new Point(xi, yi));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}