package edu.hust.collection;

//链表数据节点
public class Node<T> {
	T data;
	Node<T> next;
	
	Node(T obj, Node<T> next){
		this.data = obj;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
