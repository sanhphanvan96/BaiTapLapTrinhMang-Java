package io.nano.java;

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a, b, c;
		System.out.println("Nhập vào các hệ số a, b, c: ");
		a = sc.nextFloat();
		b = sc.nextFloat();
		c = sc.nextFloat();
		gpt(a, b, c);
	}

	public static void gpt(float a, float b, float c) {
		if (a == 0) {
			if (b == 0) {
				if (c == 0)
					System.out.println("Phương trình có vô số nghiệm.");
				else
					System.out.println("Phương trình vô nghiệm.");
			} else {
				System.out.println("Phương trình có nghiệm kép: x = " + -c / b);
			}
		} else {
			float delta = b * b - 4 * a * c;
			if (delta < 0)
				System.out.println("Phương trình vô nghiệm.");
			else if (delta == 0)
				System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + -b / (2 * a));
			else {
				System.out.println("Phương trình có nghiệm x1 = " + (-b + Math.sqrt(delta) / (2 * a)));
				System.out.println("Phương trình có nghiệm x2 = " + (-b - Math.sqrt(delta) / (2 * a)));
			}
		}

	}

}
