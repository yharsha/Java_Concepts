package countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Use CountDownLatch when one thread (like the main thread) requires to wait for one or more threads 
 * to complete, before it can continue processing.*/
class processor implements Runnable {

	private CountDownLatch latch;

	public processor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Started.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		latch.countDown();
	}
}

public class LatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executor.submit(new processor(latch));
		}

		try {
			// it waits until countdown latch comes to zero
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed..");
	}

}
