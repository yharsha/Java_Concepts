package com.thread.creation;

public class ThreadCreationbyInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new DemoThread();
		thread.start();
	}
	
	public static class DemoThread extends Thread{
		@Override
		public void run()
		{
			System.out.println("Hello from -"+this.getName());
			
		}
	}

}
