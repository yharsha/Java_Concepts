package waitAndNotify;

import java.util.Scanner;

public class WaitDemo {

	public void process() throws InterruptedException {
		synchronized (this) {
			System.out.println("Produce thread runninng...");
			wait();
			System.out.println("Resumed....!!");
		}
	}

	public void consume() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key..!!");
			sc.nextLine();
			System.out.println("Return key presses");
			notify();
			Thread.sleep(5000);

		}
	}


}
