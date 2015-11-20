package edu.hust.thread;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * volatile是Java提供的最轻量级同步机制，volatile变量在共享使用时，如果多个线程同时修改变量值，会产生不同步的问题
 * 
 * 2015-11-15
 */
public class VolatileTest {
	
	public static Integer num=0;
//	public static AtomicInteger num = new AtomicInteger(0);
	
	public static void increase(){
		synchronized (num) { //此方式同步失败。将synchronized加到方法上可以或者使用整形的原子类型
			num++;
		}
//		num.incrementAndGet();
	}

	private static final int THREADS_COUNT=20;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for(int i=0; i<THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<10000; j++){
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		//等待所有累加线程都结束
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		
		System.out.println(num); //理论上应该输出20 * 10000 = 200000
	}
}
