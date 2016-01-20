package edu.hust.basic.Final;

/**
 * 关于final的使用，主要是对变量和方法的修饰，参考：http://www.cnblogs.com/dolphin0520/p/3736238.html
 * 
 * Java采用的是值传递方式，如果参数是基本数据类型，则在栈内存中直接复制一个完全相同的变量；如果是引用数据类型，则在栈内存中复制一个当前对象的引用，
 * 由于没有复制堆内存中的实际对象，因此操作的仍是同一个对象，即方法内对引用参数所指对象的操作会影响到方法外的对应引用的使用。
 * 
 * @author liangjian
 * @since 2016-01-20
 */
public class FinalTest {

	public static void main(String[] args) {
		MyClass2 myClass = new MyClass2();
		StringBuffer buffer = new StringBuffer("hello");
		myClass.changeValue(buffer);
		System.out.println(buffer.toString());
	}
	
}
