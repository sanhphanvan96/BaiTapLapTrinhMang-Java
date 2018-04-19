package pk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai61 {

	public int nhapSo() throws IOException {
		InputStreamReader luongVao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongVao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	public int uocChungLonNhat(int a, int b) {
		if ((a == 0) || (b == 0))
			return 0;
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	public int boiChungNhoNhat(int a, int b) {
		int s = 0;
		if ((a == 0) || (b == 0))
			return (a + b);
		if (a != b) {
			s = a * b / uocChungLonNhat(a, b);
		}
		return s;
	}

	public static void main(String[] args) {
		Bai61 dt = new Bai61();
		int a = 0, b = 0;
		try {
			do {
				System.out.print("Nhap so a: ");
				a = dt.nhapSo();
				System.out.print("Nhap so b: ");
				b = dt.nhapSo();
			} while ((a < 0) || (b < 0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Uoc chung lon nhat: " + dt.uocChungLonNhat(a, b));
		System.out.println("Boi chung nho nhat: " + dt.boiChungNhoNhat(a, b));
	}

}
