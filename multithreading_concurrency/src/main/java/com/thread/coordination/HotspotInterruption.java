package com.thread.coordination;

import java.math.BigInteger;

public class HotspotInterruption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new LongComputationTask(new BigInteger("200")
				,new BigInteger("50000")));
		
		thread.start();
		thread.interrupt();
	}
	
	private static class  LongComputationTask implements  Runnable {
		private BigInteger base;
		private BigInteger power;
		
		public LongComputationTask(BigInteger base,BigInteger power)
		{
			this.base=base;
			
			this.power=power;
		}
		
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("base: "+base+" power:"+power+ " Result is "+pow(base,power));
		}
		public BigInteger pow(BigInteger base,BigInteger power) {
			BigInteger result = BigInteger.ONE;
			
			//HOTSPOT
			for(BigInteger i = BigInteger.ZERO ; i.compareTo(power)!=0 ;i=i.add(BigInteger.ONE))
			{
				if(Thread.currentThread().isInterrupted()) {
				System.out.println("Prematurely Interrupted..");
				return BigInteger.ZERO;
				//System.exit(0);
				}
				result=result.multiply(base);
				
			}
			return result;
		}


	
	}

}
