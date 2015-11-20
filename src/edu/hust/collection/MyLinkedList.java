package edu.hust.collection;

import edu.hust.collection.Collection;
import edu.hust.collection.Iterable;

public class MyLinkedList<T> implements Collection<T>, Iterable<T> {
	
	int size=0;
	Node<T> head = null;
	Node<T> tail = null;
	
	@Override
	public void add(T data) {
		Node<T> n = new Node<T>(data, null);
		if(head == null) {
			head = n;
			tail = n;
		}
		tail.setNext(n);
		tail = n;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	//Iterator用于定义统一的遍历方式，遍历时不止设计一个方式，因此使用接口来管理
	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator();//可以直接匿名内部类
	}
	
	//内部类用于具体实现适用于本地的遍历（其实本身next和hasNext方式是可以直接写在本地类中，不过接口定义的越细越好）
	public class MyLinkedListIterator implements Iterator<T> {
		int currentSize =0;
		Node<T> node = head;
		
		@Override
		public T next() {
			if(currentSize != 0) {
				node = node.getNext();
			}
			currentSize++;
			return node == null ? null : node.getData();
		}

		@Override
		public boolean hasNext() {
			if(currentSize < size()) {
				return true;
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		MyLinkedList<String> mll = new MyLinkedList<String>();
		mll.add("a");
		mll.add("b");
		Iterator<String> iterator = mll.iterator();
		while(iterator.hasNext()) {
			String data = iterator.next();
			System.out.println(data);
		}
		
		System.out.println(mll.size());
	}

}
