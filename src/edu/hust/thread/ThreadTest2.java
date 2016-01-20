package edu.hust.thread;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池中捕获异常
 * 1，smdb中的做法：将具体的run方法用try-catch包起来，用Exception异常来接受所有可能的异常。（感觉这并不是一个正常的捕获方式）
 * 2，网上的做法：使用afterExecute()方法收集。
 * 
 * 
 * http://www.blogjava.net/xylz/archive/2013/08/05/402405.html
 *   结论，通过覆盖ThreadPoolExecutor.afterExecute 方法，我们才能捕获到任务的异常（RuntimeException）
 *
 * @author liangjian
 * @date 2016-01-12
 *
 */

public class ThreadTest2 extends ThreadPoolExecutor {
	
	/**
	 * 最大可以同时工作的任务数
	 */
	private static final int MAX_TASK_NUMBER = 3; 
	
	/**
	 * 正在执行的任务的taskType+arguments
	 */
	
	public ThreadTest2() {
		super(MAX_TASK_NUMBER, Integer.MAX_VALUE, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		this.allowCoreThreadTimeOut(true);
	}

	//捕获异常
	protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        printException(r, t);
    }

	private static void printException(Runnable r, Throwable t) {
	    if (t == null && r instanceof Future<?>) {
	        try {
	            Future<?> future = (Future<?>) r;
	            if (future.isDone())
	                future.get();
	        } catch (CancellationException ce) {
	            t = ce;
	        } catch (ExecutionException ee) {
	            t = ee.getCause();
	        } catch (InterruptedException ie) {
	            Thread.currentThread().interrupt(); // ignore/reset
	        }
	    }
	    if (t != null) {
	    	System.out.println("异常收集。。。");
	    	System.out.println(t.getMessage());
//	        log.error(t.getMessage(), t);
	    }
	}
	
	public static void main(String[] args) {
		ThreadTest2 t2 = new ThreadTest2();
		for (int i = 0; i < 10; i++) {
			MyThread t = new MyThread();
			t2.execute(t);
		}
	}
}
