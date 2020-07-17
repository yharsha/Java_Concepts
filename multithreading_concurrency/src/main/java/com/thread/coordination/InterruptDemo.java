package com.thread.coordination;


public class InterruptDemo {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new BlockingTask());
		thread.start();
		
		thread.interrupt(); 
	}
	
	
	private static class  BlockingTask implements  Runnable {
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println("Came out from Sleep "+ Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Interrupted by main Thread");
				e.printStackTrace();
			}
		}
	}

}
