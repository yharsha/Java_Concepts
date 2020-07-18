package com.thread.syncronization;

public class DataRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedClass sharedClass =  new SharedClass();
		Thread t1 = new Thread(()-> {
			for(int i=0;i<Integer.MAX_VALUE;i++)
			{
				sharedClass.increment();
			}
		});
		
		Thread t2 = new Thread(()-> {
			for(int i=0;i<Integer.MAX_VALUE;i++)
			{
				sharedClass.checkforDataRace();
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public static class SharedClass {
		//without volatile (Atomic) - Data Race is detected will be detected due to CPU/compiler rearranging of code
		//for better performance /hardware utilization
		private volatile int x=0;
		private volatile int y=0;
		
		public void increment() {
			x++;
			y++;
			
		}
		
		public void checkforDataRace()
		{
			if(y>x)
			{
				System.out.println("y > x- Data Race is detected");
			}
		}
	}

}
