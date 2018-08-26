package producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*Multithreaded applications because it's it's always best to avoid low level synchronization with the
synchronize keyword yourself.*/
public class PCdemo {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	// if queue is full ,producer waits until consumer takes it
	public static void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			int val=random.nextInt(100);
			System.out.println("Inserting into queue:"+val+" #Size:"+queue.size());
			queue.put(val);
		}
	}

	public static void consumer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				int val = queue.take();
				System.out.println("Taken value:" + val + " Queue Size:" + queue.size());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					producer();
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
					consumer();
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

	}

}
