package waitAndNotify;

public class CallWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final WaitDemo obj=new WaitDemo();
		Thread t1=new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					obj.process();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					obj.consume();
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
