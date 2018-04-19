package chuong1;

import java.util.Scanner;

public class BT4 {
	private static Scanner sc = new Scanner(System.in);

	public void tinhtien(int a, int b) {
		if (a < 0 || b < 0 || a > 24 || b > 24)
			System.out.print("Số liệu không hợp lệ.");
		else {
			// trước nửa đêm
			if (a < 18 && b <= 23 && a < b)
				System.out.print("\nSố tiền cần trả: " + 45 * (b - a) + "000");
			if (a < 18 && b >= 0 && a > b)
				System.out.print("\nSố tiền cần trả: " + 45 * (24 + b - a) + "000");
			// quá nửa đêm
			if (a > 18 && b <= 23 && a < b)
				System.out.print("\nSố tiền cần trả: " + 60 * (b - a) + "000");
			if (a > 18 && b >= 0 && a > b)
				System.out.print("\nSố tiền cần trả: " + 60 * (24 + b - a) + "000");
		}
	}

	public static void main(String[] args) {
		int a, b;
		System.out.print("Nhập giờ bắt đầu, giờ kết thúc: ");
		a = sc.nextInt();
		b = sc.nextInt();
		BT4 obj = new BT4();
		obj.tinhtien(a, b);
	}

}
