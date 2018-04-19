import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner	sc = new Scanner(System.in);
			String hn = sc.nextLine();
			InetAddress[] ia = InetAddress.getAllByName(hn);
			for (int i = 0; i < ia.length; i++) {
				System.out.println(ia[i].getHostAddress());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
