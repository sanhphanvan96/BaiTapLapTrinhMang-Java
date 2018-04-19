package io.nano.java;

public class HelloWorld {

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// int a = 5;
	// if (a != 0) {
	// a = a++ + a++;
	// }
	// System.out.println(a);
	// }

	public static void main(String[] args) {
		HelloWorld s = new HelloWorld();
		s.start();
	}

	void start() {
		int a = 3;
		int b = 4;
		System.out.print(" " + 7 + 2 + " ");
		System.out.print(a + b);
		System.out.print(" " + a + b + " ");
		System.out.print(foo() + a + b + " ");
		System.out.println(a + b + foo());
	}

	String foo() {
		return "foo";
	}

}
