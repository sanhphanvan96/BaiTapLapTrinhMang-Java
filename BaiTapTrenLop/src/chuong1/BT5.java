package chuong1;

import java.util.Scanner;

public class BT5 {

	private static Scanner sc;

	public boolean kiemtraNhuan(int nam) {
		// năm nhuận là năm chia hết cho 400, hoặc chia hết cho 4 nhưng không chia hết
		// cho 100.
		if ((nam % 400 == 0) || (nam % 4 == 0 && nam % 100 != 0))
			return true;
		else
			return false;
	}

	public void demNgay() {
		int thang, nam;
		int ngayTrongThang[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.print("Nhập năm, tháng: ");
		sc = new Scanner(System.in);
		nam = sc.nextInt();
		thang = sc.nextInt();
		if (thang < 1 || thang > 12)
			System.out.print("Nhập sai!");
		else {
			System.out.print("\nKết quả:\n Năm " + nam + " tháng " + thang + " có ");
			System.out.println(ngayTrongThang[thang] + " ngay");
//			if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12)
//				System.out.print("31 ngày");
//			else if (thang == 4 || thang == 6 || thang == 9 || thang == 11)
//				System.out.print("30 ngày");
			BT5 obj = new BT5();
			if (thang == 2 && obj.kiemtraNhuan(nam))
				System.out.print("29 ngày");
			if (thang == 2 && !obj.kiemtraNhuan(nam))
				System.out.print("28 ngày");
		}

	}

	public static void main(String[] args) {
		BT5 mainObj = new BT5();
		mainObj.demNgay();
	}

}
