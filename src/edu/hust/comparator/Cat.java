package edu.hust.comparator;

/*
 * 为了避免比较的方式被写死，我们将比较的具体实现抽取出来，形成一个接口，即比较器
 */

public class Cat implements Comparable<Cat> {
	int age;
	int weight;
	String name;
	
	public Cat(int age, int weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public int compareTo(Cat c) { //即使有了Comparator，但是还是要继承comparable接口，因为排序的时候需要
		return new WeightComparator().compare(this, c);
	}
	
	@Override
	public String toString() {
		return age + ":" + weight + ":" + name; 
	}
}
