package edu.hust.thread;

import java.io.PrintWriter;
import java.io.StringWriter;

public class MyThread implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " : " + Thread.activeCount());
			Thread.sleep(1000);
			int i = 1 / 0;
		} catch (Exception e) {
			//smdb的做法，将错误信息输出到只是指定的print writer流中
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
//			crawlTask.addLog(sw.toString());
//			hibernateBaseDao.addOrModify(crawlTask);
			throw new RuntimeException(e);
		}
	}

}
