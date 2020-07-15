package com.thread.creation;

public class ThreadCreationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Thread thread = new Thread(new Runnable() {
	            public void run() {
	                System.out.println("We are executing Thread in Run method..."+Thread.currentThread().getName());
	                System.out.println(Thread.currentThread().getName()+ " Thread priority..."+
	                        Thread.currentThread().getPriority());
	            }
	        });

	        thread.setName("Yudi  Thread");
	        thread.setPriority(Thread.MAX_PRIORITY);
	        System.out.println("We are before starting  Thread: "+Thread.currentThread().getName());
	        thread.start();
	        System.out.println("We are after starting Thread: "+Thread.currentThread().getName());
	    }

	}


