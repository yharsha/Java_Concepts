package com.thread.creation;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadErrorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
				throw new RuntimeException("INTENTIONAL EXCEPTION");
			}
		});
		thread.setName("Misbehaving Thread");
		
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("An unexpected Error happened in Thread..."+t.getName()
				+"  || Error is "+e.getMessage());
				System.out.println("---");
			}
		});
		
		
		thread.start();

	}

}
