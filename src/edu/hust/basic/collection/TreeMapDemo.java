package edu.hust.basic.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeMap和TreeSet的底层是基于红黑树实现的，红黑树是一种自平衡的排序二叉树。
 * 
 * @author 2015-12-10
 *
 */
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		s.add(3);
		s.add(2);
		s.add(5);
		s.add(1);
		s.add(2);//set集合不可重复
		Object[] i = s.toArray(); 
		System.out.println(i.length);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); //可以通过构造函数自定义排序方式
		map.put(2, 2);
		map.put(5, 5);
		map.put(3, 3);
		map.put(1, 1);
		map.put(4, 4);
		
		Set<Integer> set = map.keySet(); //遍历
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		System.out.println(map.firstKey()); //值最小的元素
		System.out.println(map.lastKey());  //值最大的元素
		System.out.println(map.size());
		map.clear();
		System.out.println(map.size());
	}
}
