package chuong1;

/* Giai phuong trinh bac nhat: ax + b = 0 */
import java.util.Scanner;

public class BT1 {
	public static Scanner sc;

	public static void gpt(float a, float b) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phuong trinh vo so nghiem!");
			} else {
				System.out.println("Phuong trinh vo nghiem!");
			}
		} else {
			System.out.println("Phuong trinh co nghiem: " + (-b / a));
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		float a, b;
		System.out.println("Giai pt ax + b = 0");
		System.out.print("a = ");
		a = sc.nextFloat();
		System.out.print("b = ");
		b = sc.nextFloat();
		gpt(a, b);
	}
}
