package puzzle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleServer {
	public final static int puzzlePort = 5500;
	XuLy process;
	int count = 0;
	boolean cont = true;

	public PuzzleServer() {
		try {
			ServerSocket server = new ServerSocket(5500);
			process = new XuLy(this, server.accept());
			process.start();
		} catch (Exception e) {
			System.out.println("Lỗi server 1 : " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		new PuzzleServer();
	}
}

class XuLy extends Thread {
	PuzzleServer server;
	Socket soc;
	DataInputStream dis;
	DataOutputStream dos;

	public XuLy(PuzzleServer server, Socket soc) {
		this.server = server;
		this.soc = soc;
		try {
			dis = new DataInputStream(soc.getInputStream());
			dos = new DataOutputStream(soc.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		String imageClient = null;
		do {
			try {
				dis = new DataInputStream(soc.getInputStream());
				dos = new DataOutputStream(soc.getOutputStream());

				String image = image();
				System.out.println("Gửi ảnh: " + image);
				dos.writeUTF(image);

				System.out.println("Chuẩn bị nhận ảnh:");
				imageClient = dis.readUTF();
				System.out.println("Hình: " + imageClient);
				if (imageClient != null)
					continue;

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);

	}

	public String image() {
		String result = null;
		ArrayList<String> imgs = new ArrayList<>();

		// imgs.add("icesid.jpg");
		imgs.add("hellokitty.jpg");
		imgs.add("conan.jpg");

		Collections.shuffle(imgs);
		result = imgs.get(0);
		return result;
	}
}
