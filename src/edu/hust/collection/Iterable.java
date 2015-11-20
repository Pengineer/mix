package edu.hust.collection;

//该接口主要用于标示可以使用foreach遍历方式
public interface Iterable<T> {
	public Iterator<T> iterator();
}
