package dev;

class Runner extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Executing thread:" + Thread.currentThread().getName() + " ivalue:" + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner run1 = new Runner();
		run1.start();
		run1.setName("1stThread");
		
		Runner run2 = new Runner();
		run2.start();
		run2.setName("2ndThread");
	}

}
