package edu.hust.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	
	/**
	 * 线程池：无限长队列，核心线程数（一次执行任务数）为3，线程池最大大小为6
	 */
	
	public static void main(String[] args) {
		method1();
	} 
	
	//shutdown方法不会终止队列中任务，只会停掉线程池中空闲线程
	public static void method1() {
		BlockingQueue queue = new LinkedBlockingQueue();
	    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, queue);   
	    for (int i = 0; i < 20; i++) {
	        executor.execute(new Runnable() {
	            public void run() {
	                try {
	                	System.out.println(this.hashCode()/1000);
	                	for (int j = 0; j < 10; j++) {
							System.out.println(this.hashCode() + ":" + j);
							Thread.sleep(this.hashCode()%2);
						}  
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println(String.format("thread %d finished", this.hashCode()));
	                throw new RuntimeException();
	            }
	        });
	    }
	    
	    
	    
	    executor.shutdown();
	}
	
	//有sleep方法，shutdownNow会立即清除队列中所有待执行任务，同时终止当前正在运行的线程
	public static void method2() {
		BlockingQueue queue = new LinkedBlockingQueue();
	    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.DAYS, queue);   
	    
	    for (int i = 0; i < 20; i++) {
	        executor.execute(new Runnable() {
	            public void run() {
	                try {
	                	System.out.println(this.hashCode()/1000);
	                	for (int j = 0; j < 10; j++) {
							System.out.println(this.hashCode() + ":" + j);
							Thread.sleep(this.hashCode()/1000);
						}  
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println(String.format("thread %d finished", this.hashCode()));
	            }
	        });
	    }
	    
	    executor.shutdownNow();
	}
	
	//没有sleep，wait，condition等方法，shutdownNow()方法不会停止当前正在执行的任务，但是会清除队列中其他待执行线程
	public static void method3() {
		BlockingQueue queue = new LinkedBlockingQueue();   
	    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.DAYS, queue);   
	    
	    for (int i = 0; i < 20; i++) {   
	        executor.execute(new Runnable() {   
	            public void run() {   
	            	System.out.println(this.hashCode()/1000);
	                for (int j = 0; j < 10; j++) {
						System.out.println(this.hashCode() + ":" + j);
					}  
	                System.out.println(String.format("thread %d finished", this.hashCode()));
	            }   
	        });   
	    }
	    
	    executor.shutdownNow();
	}
}
