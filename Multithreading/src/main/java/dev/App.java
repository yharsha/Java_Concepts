package dev;

import java.util.Scanner;

/*Two kinds of problems.
The first one we're going to look at in this tutorial and it has to do with data being cached.
And the second kind of problem which is more vicious has to do with threats interleaving.*/

class Processor extends Thread {
	/*
	 * "Voltaile" used to prevent threads caching variables when they're not changed from
	 * within that thread.
	 */
	private volatile boolean runStatus = true;

	public void run() {
		while (runStatus) {
			System.out.println("Hey!");
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		runStatus = false;
	}

}

class Runner extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Executing thread:" + Thread.currentThread().getName() + " ivalue:" + i);
			try {
				Thread.sleep(100);
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
		// run1.start();
		run1.setName("1stThread");

		Runner run2 = new Runner();
		// run2.start();
		run2.setName("2ndThread");

		// main is also a thread,p1 is one more thread
		Processor p1 = new Processor();
		p1.start();

		// below is pause execution of my main thread and main program here until I hit
		// the return key.
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		System.out.println("shutting down..!!");
		p1.shutdown();
	}

}
