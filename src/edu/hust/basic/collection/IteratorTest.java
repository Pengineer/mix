package edu.hust.basic.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在Iterator遍历期间，其他线程修改集合中的对象。（线程安全下增删还是可以的）
 * 
 * @author liangjian
 * @since 2016-01-23
 *
 */
public class IteratorTest {
	
	private static List<String> list = new ArrayList<String>(); 
//	private static List<String> list = new CopyOnWriteArrayList<String>();

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for (int i=0; i<100; i++) {
			list.add(i + ""); 
		}
		while(true) {
			printAll();
		}
	}
	
	public static void printAll() {
		Iterator<String> itr = list.iterator();
		System.out.println("开始遍历。。。");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("结束遍历。。。");
	}
	
	static class MyThread extends Thread {
		Random rand = new Random();
		@Override
		public void run() {
			while(true) {
				list.set(0, rand.nextInt() + "");
				String str = list.get(1);
				str = "b";
			}
		}
	}
}
