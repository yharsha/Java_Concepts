package com.thread.coordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		
        List<Long> inputNumbers = Arrays.asList(1000000L, 55L, 35L, 45L, 46L, 23L, 56L);
        List<FactorialThread> threads = new ArrayList<FactorialThread>();
        
        for(Long num:inputNumbers)
        {
        	threads.add(new FactorialThread(num));
        }
        
        //start threads
        for(FactorialThread thread : threads)
        {
        	thread.start();
     
        }
        
        for(FactorialThread thread : threads)
        {
        	
        	thread.join(2000);
        }
 
        
        //check outputs of inputNumbers
        for(int i=0;i<inputNumbers.size();i++)
        {
        	FactorialThread factorialThread = threads.get(i);
        	if(factorialThread.isFinished())
        	{
        		System.out.println("The factorial output of "+inputNumbers.get(i)+" :: "+factorialThread.getResult());
        	}
        	else
        	{
        		System.out.println("The factorial output of "+inputNumbers.get(i)+" is still in progress");
        	}
        }
       

	}
	
	
    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }

}
