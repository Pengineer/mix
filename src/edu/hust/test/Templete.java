package edu.hust.test;

public abstract class Templete {
	public Long getTime() {
		long startTime = System.currentTimeMillis();
		runCode();
		long endTime = System.currentTimeMillis();
		return endTime-startTime;
	}
	
	public abstract void runCode();
}