package chuong1;

import java.util.Scanner;

public class BT7 {
	public static int congviec;
	private static Scanner sc;

	public boolean b11(int n) {
		if (n == 1 || n == 2)
			return true;
		if (n < 1)
			return false;
		int soUoc = 0;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				soUoc++;
		if (soUoc == 0)
			return true;
		else
			return false;
	}

	public boolean b12(int p) {
		for (int i = 1; i <= p; i++)
			if (i * i == p)
				return true;
		return false;
	}

	public boolean b13(int n) {
		String a = new Integer(n).toString(); // Chuyển thành chuỗi
		int k, x = a.length(); // đo độ dài x chuỗi a (bắt đầu từ 1)
		k = (int) (x - 1) / 2; // lấy độ dài 1/2 mảng kí tự (bắt đầu từ 0)
		for (int i = 0; i <= k; i++)
			if (a.charAt(i) == a.charAt(x - i - 1))
				continue;
			else
				return false;
		return true;
	}

	public void b14(int n) {
		BT7 obj = new BT7();
		for (int i = 1; i < n; i++)
			if (obj.b11(i))
				System.out.print(i + " ");
	}

	public void menu() {
		System.out.print("\n==========================\n" + "Chọn các công việc: \n" + "1. Kiểm tra số nguyên tố\n"
				+ "2. Kiểm tra số chính phương\n" + "3. Kiểm tra số đối xứng\n"
				+ "4. In ra số nguyên tố nhỏ hơn một số\n" + "0. Thoát\n" + "Chọn: ");
		sc = new Scanner(System.in);
		do {
			congviec = sc.nextInt();
		} while (congviec < 0 || congviec > 4);
	}

	public static void main(String[] args) {
		int n;
		BT7 mainObj = new BT7();
		sc = new Scanner(System.in);
		do {
			mainObj.menu();
			switch (congviec) {
			case 0:
				break;
			case 1:
				System.out.print("\nNhập N = ");
				n = sc.nextInt();
				if (mainObj.b11(n))
					System.out.print(n + " là số nguyên tố");
				else
					System.out.print(n + " không là số nguyên tố");
				break;
			case 2:
				System.out.print("\nNhập P = ");
				n = sc.nextInt();
				if (mainObj.b12(n))
					System.out.print(n + " là số chính phương");
				else
					System.out.print(n + " không là số chính phương");
				break;
			case 3:
				System.out.print("\nNhập M = ");
				n = sc.nextInt();
				if (mainObj.b13(n))
					System.out.print(n + " là số đối xứng");
				else
					System.out.print(n + " không là số đối xứng");
				break;
			case 4:
				System.out.print("\nNhập N = ");
				n = sc.nextInt();
				System.out.print("Danh sách các số nguyên tố nhỏ hơn " + n + " là :\n");
				mainObj.b14(n);
				break;
			default:
				break;
			}
		} while (congviec != 0);
	}
}
