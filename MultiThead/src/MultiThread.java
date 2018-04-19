
class Syn {

	public void display() {
		for (int i = 1; i < 10; i += 2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			;
		}
	}
}

public class MultiThread extends Thread {
	static Syn a = new Syn();

	public void run() {
		synchronized (a) {
			a.display();
		}
	}

	public static void main(String[] s) {
		MultiThread m = new MultiThread();
		MultiThread n = new MultiThread();
		m.start();
		n.start();
	}
}