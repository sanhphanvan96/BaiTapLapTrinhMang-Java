package pk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai62 {

	public String nhapChuoi() throws IOException {
		InputStreamReader luongVao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongVao);
		String s = br.readLine();
		return s;
	}

	public void daoNguocChuoi(String input) {
		String t = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			t += input.charAt(i);
		}
		System.out.println("Chuoi dao nguoc: " + t);
	}

	public void doiChuoiHoa(String input) {
		String t = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) > 'Z') {
				t += (char) (input.charAt(i) - 32);
			} else {
				t += input.charAt(i);
			}
		}
		System.out.println("Chuoi sau khi doi sang hoa: " + t);
	}

	public void doiChuoiThuong(String input) {
		String t = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				t += (char) (input.charAt(i) + 32);
			} else {
				t += input.charAt(i);
			}
		}
		System.out.println("Chuoi sau khi doi sang thuong: " + t);
	}

	public void chuyenHoaThuong(String input) {
		String t = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) > 'Z') {
				t += (char) (input.charAt(i) - 32);
			} else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				t += (char) (input.charAt(i) + 32);
			} else {
				t += input.charAt(i);
			}
		}
		System.out.println("Chuoi sau khi doi hoa sang thuong va nguoc lai: " + t);
	}

	public static void main(String[] args) {
		Bai62 dt = new Bai62();
		String input = "";
		try {
			System.out.println("Nhap chuoi: ");
			input = dt.nhapChuoi();
		} catch (Exception e) {
			// TODO: handle exception
		}
		dt.daoNguocChuoi(input);
		dt.doiChuoiHoa(input);
		dt.doiChuoiThuong(input);
		dt.chuyenHoaThuong(input);
	}

}
