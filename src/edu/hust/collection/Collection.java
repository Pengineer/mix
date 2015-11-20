package edu.hust.collection;

//定义集合的统一操作方式
public interface Collection<T> {
	public void add(T data);
	public int size();
}
