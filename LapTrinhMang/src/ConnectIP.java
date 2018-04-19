import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class ConnectIP {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap trang: ");
			String hn = sc.nextLine();
			InetAddress[] ia = InetAddress.getAllByName(hn);
			for(int i = 0; i < ia.length; i++) {
				System.out.println(ia[i].getHostAddress());
			}
			
		} catch(Exception e) {
			
		}
	}

}
