package chuong1;

import java.util.Scanner;

// Tim so trung gian cua 3 so a, b, c
public class BT3 {
	public static Scanner sc = new Scanner(System.in);

	public static float soTrungGian(float a, float b, float c) {
		float max = (a > b && a > c) ? a : (b > c ? b : c);
		float min = (a < b && a < c) ? a : (b < c ? b : c);
		return a + b + c - max - min;
	}

	public static void main(String[] args) {
		float a, b, c;
		System.out.println("Nhap lan luot 3 so a, b, c");
		a = sc.nextFloat();
		b = sc.nextFloat();
		c = sc.nextFloat();
		System.out.println("So trung gian: " + soTrungGian(a, b, c));
	}

}
