package edu.whut.introspector;

/**
 * JavaBean��ר�������������еĹ��ڳ�Ա���ԵĲ�������
 */

public class Person {
	public String name;
	public int age ;
	//����һ����4����Ա���ԣ������ֶΣ���ABC��name��age��class����Object�̳У�
	public String getABC(){
		return "ABC";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
