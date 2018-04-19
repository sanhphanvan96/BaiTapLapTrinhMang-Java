package io.nano.java;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a, b;
		System.out.println("Nhập vào hệ số cho phương trình ax + b = 0");

		System.out.print("a = ");
		a = sc.nextFloat();

		System.out.print("b = ");
		b = sc.nextFloat();
		
		gpt(a, b);
	}

	public static void gpt(float a, float b) {
		if (a == 0) {
			if (b == 0) System.out.println("Phương trình có vô số nghiệm.");
			else System.out.println("Phương trình vô nghiệm.");

		} else {
			System.out.println("Phương trình có nghiệm duy nhất: x = " + -b/a);
		}
	}
}
