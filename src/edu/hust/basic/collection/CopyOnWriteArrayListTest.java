package edu.hust.basic.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合中的fail-fast（快速失败）事件
 * 
 * ArrayList集合类在多线程下会出现fail-fast事件，抛出ConcurrentModificationException异常；可用concurrent包下的CopyOnWriteArrayList类代替（采用复制数组的方式使得效率低）
 * 
 * @author liangjian
 *
 */
public class CopyOnWriteArrayListTest {
	
//	private static List<String> list = new ArrayList<String>(); // java.util.ConcurrentModificationException
	private static List<String> list = new CopyOnWriteArrayList<String>(); // 无异常

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		
		for (int i=0; i<10; i++) {
			list.add(i + ""); //每次执行add/remove/clear都会使得集合中的modCount属性自增
			printAll();
		}
	}
	
	public static void printAll() {
//		for(String str : list) { // 增强for循环遍历底层也是调用next
//			System.out.println(str);
//		}
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()); //每次执行next函数都会比较集合中modCount属性的当前值和新建Iterator对象是该属性的值
		}
	}
	
	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i=10; i<20; i++) {
				list.add(i + "");
				printAll();
			}
		}
	}
}
