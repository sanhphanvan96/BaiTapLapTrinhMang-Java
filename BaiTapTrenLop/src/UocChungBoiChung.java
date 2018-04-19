import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UocChungBoiChung {
	public static int nhapSo() throws IOException {
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(inputStream);
		String s = buffer.readLine();
		return Integer.parseInt(s);
	}

	static public int uocChungLonNhat(int a, int b) {
		if (a == 0 || b == 0)
			return a + b;
		else {
			while (a != b) {
				if (a > b)
					a = a - b;
				else
					b = b - a;
			}
			return a;
		}
	}

	public static int boiChungNhoNhat(int a, int b) {
		return a * b / UocChungBoiChung.uocChungLonNhat(a, b);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Nhap a: ");
		int a = nhapSo();

		System.out.println("Nhap b: ");
		int b = nhapSo();

		System.out.println("BCNN: " + boiChungNhoNhat(a, b));
		System.out.println("UCLN: " + uocChungLonNhat(a, b));
	}
}
