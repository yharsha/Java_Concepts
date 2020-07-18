package com.thread.memory.management;

public class ResourceSharingDemo {

	public static void main(String[] args) throws InterruptedException {
		InventoryCounter inventoryCounter = new InventoryCounter();
		IncrementThread incrementThread = new IncrementThread(inventoryCounter);
		DecrementThread decrementThread = new DecrementThread(inventoryCounter);
		
		incrementThread.start();
		
		decrementThread.start();
		
		incrementThread.join();
		decrementThread.join();
		
		System.out.println("Current Items in Inventory: "+ inventoryCounter.getItems());
	}
	
	
	public static class DecrementThread extends Thread{
		private InventoryCounter inventoryCounter;
		
		public DecrementThread(InventoryCounter inventoryCounter)
		{
			this.inventoryCounter=inventoryCounter;
		}
		
		public void run() {
			for(int i=0;i<10000;i++)
			{
				inventoryCounter.decrement();
			}
		}
	}
	
	public static class IncrementThread extends Thread{
		private InventoryCounter inventoryCounter;
		
		public IncrementThread(InventoryCounter inventoryCounter)
		{
			this.inventoryCounter=inventoryCounter;
		}
		
		public void run() {
			for(int i=0;i<10000;i++)
			{
				inventoryCounter.increment();
			}
		}
	}
	
	private static class InventoryCounter{
		private int items=0;
		Object lock = new Object();
		
		public  void increment() {
			//2nd way - use an object
			synchronized (this) {
				items++;
			}	
		
		}
		
		//1st way- use synchronized keyword
		public synchronized void decrement() {
			items--;
		}
		
		public synchronized int getItems() {
			return items;
		}
	}

}
