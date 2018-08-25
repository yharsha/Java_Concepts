package dev;

public class SynchronizedDemo {

	private int count = 0;

	/*1.In this case we're calling the synchronized method of this app objet here.
	 * 2.the thing is that only one thread can acquire the intrinsic lock at a
	 * time and if one thread acquires
	 */
	private synchronized void increment() {
		count++;
	}

	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					// count++;
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000; i++) {
					// count++;
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		// to make main thread wait till t1 & t2 threads execution is completed.

		t1.join();
		t2.join();
		System.out.println("Count is:" + count);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SynchronizedDemo app1 = new SynchronizedDemo();
		app1.doWork();

	}

}
