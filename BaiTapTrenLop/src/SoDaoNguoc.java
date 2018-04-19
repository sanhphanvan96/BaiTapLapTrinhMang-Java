import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SoDaoNguoc {
	public int nhapSo() throws IOException {
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(inputStream);
		String s = buffer.readLine();
		return Integer.parseInt(s);
	}

	public void timSoDaoNguoc(int m) {
		int p = 0, sd;
		while (m != 0) {
			sd = m % 10;
			p = p * 10 + sd;
			m = m / 10;
		}
		System.out.println("So dao nguoc la: " + p);
	}

	public static void main(String[] args) {
		SoDaoNguoc dt = new SoDaoNguoc();
		int m = 0;
		try {
			do {
				System.out.println("Nhap so nguyen duong m = ");
				m = dt.nhapSo();
			} while (m <= 0);
		} catch (Exception e) {
		}
		dt.timSoDaoNguoc(m);
	}

}
