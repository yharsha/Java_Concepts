package dev;

class runImpl implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Executing :" + Thread.currentThread().getName() + " ivalue:" + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class Demo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new runImpl());
		Thread t2 = new Thread(new runImpl());
		t1.start();
		t2.start();
	}

}
