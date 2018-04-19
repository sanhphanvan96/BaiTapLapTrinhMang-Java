import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocXuatFile {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("D:/testIoJava.txt"));
		out.writeInt(445);
		out.writeInt(555);
		out.writeLong(123456);
		out.writeDouble(155454545);
		out.writeUTF("This is coincard!");
		out.close();

		DataInputStream in = new DataInputStream(new FileInputStream("D:/testIoJava.txt"));
		try {
			System.out.println(in.readInt());
			System.out.println(in.readInt());
			System.out.println(in.readLong());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			in.close();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}

}
