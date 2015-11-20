package edu.hust.test;

/**
 * 基本数据类型没有可设置的属性，因此跨函数使用内存的情形不必存在（唯一的value属性被私有了）
 *
 * C语言中普通局部变量也可以跨函数使用：
 * function(){int i; change(&i); }
 */

public class TestDemo2 {
	public static void main(String[] args) {
		Integer i = new Integer(3);
		change(i);
		System.out.println(i);
		
		User user = new User();
		user.setName("abc");
		changeObject(user);
		System.out.println(user.getName());
	}
	
	public static void change(Integer i) {
//		i.setXXX();
	}
	
	public static void changeObject(User user) {
		user.setName("def");
	}
}
