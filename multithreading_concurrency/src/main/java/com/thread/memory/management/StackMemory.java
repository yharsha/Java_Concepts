package com.thread.memory.management;

public class StackMemory {

	public static void main(String[] args) {
		int x=2;
		int y=5;
		int result = sum(x,y);
		System.out.println(result);

	}

	private static int sum(int x, int y) {
		int result=x+y;
		return result;
	}

}
