package reentrantLocks;

public class ReEntrantDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finished();

	}

}
