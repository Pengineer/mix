package edu.hust.comparable;

/*
 * 将需要比较的类实现Comparable接口，覆写comparaTo方法即可
 * 
 * 缺陷：比较的方式被写死了。。。
 */

public class Cat implements Comparable<Cat> {
	int age;
	String name;
	
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Cat c) {
		if(this.getAge() > c.getAge()) return 1;
		else if(this.getAge() < c.getAge()) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		return age + ":" + name; 
	}
}
