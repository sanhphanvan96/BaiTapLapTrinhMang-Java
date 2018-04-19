package chuong1;

import java.util.Scanner;

/*
 * Giai pt bac 2 ax^2 + bx + c = 0
 */
public class BT2 {
	public static Scanner sc = new Scanner(System.in);

	public static void gptbac2(float a, float b, float c) {
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("Pt vo so nghiem.");
				} else {
					System.out.println("Pt vo nghiem");
				}
			} else {
				System.out.println("Pt co nghiem x = " + (-c / b));
			}
		} else {
			float delta = b * b - 4 * a * c;
			if (delta < 0) {
				System.out.println("Pt vo nghiem");
				return;
			}
			if (delta == 0) {
				System.out.println("Pt co nghiem kep x = " + (-b / (2 * a)));
				return;
			}
			System.out.println("Pt co nghiem x1 = " + (-b + Math.sqrt(delta)) / (2 * a));
			System.out.println("Pt co nghiem x2 = " + (-b - Math.sqrt(delta)) / (2 * a));
		}
	}

	public static void main(String[] args) {
		float a, b, c;
		System.out.println("Giai phuong trinh bac 2 ax^2 + bx + c = 0");
		a = sc.nextFloat();
		b = sc.nextFloat();
		c = sc.nextFloat();
		gptbac2(a, b, c);
	}

}
