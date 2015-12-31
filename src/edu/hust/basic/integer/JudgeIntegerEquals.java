package edu.hust.basic.integer;

import java.lang.reflect.Field;

import edu.hust.basic.string.JudgeStringEquals;

/**
 * 判断两个整数对象是否相等
 * 
 * @see JudgeStringEquals
 * @author 2015-12-07
 *
 */
public class JudgeIntegerEquals {

	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}
	
	/*
	 * 对于程序中所有的String常量，Java编译器都会在编译期间初始化一个拘留字符串对象。
	 * 但是Integer类型的常量却不一样，在Integer类中，你会发现有一个内部私有类IntegerCache，它缓存了从-128~127
	 * 之间的所有整数`对象`。而通过反编译得知，当我们执行Integer a = 100; 时，根据Java自动装箱技术会变成了Integer a = Integer.valueOf(100); 
	 * 再看看valueOf()函数的定义：
	 * 再看看java.lang.Integer中关于valueOf的源代码是怎样的： 
	 * public static Integer valueOf(int i) { 
	 *		final int offset = 128; 
	 *		if (i >= -128 && i <= 127) { 
	 *			return IntegerCache.cache[i + offset]; 
	 *		} 
	 *		return new Integer(i); 
	 * }
	 * 也就说对于-128~127之间的值返回的都是高速缓存中的对象。为什么要缓存而且只缓存这个范围的值呢？
	 * 因为此范围内的小整数的使用率相对而言较高，因此，使用相同的底层兑现是有价值的，可以减少潜在的内存占用。
	 * 
	 * int & Integer 区别
	 * int是基本数据类型，Integer是对象。Java1.5之后引入了自动拆箱和装箱功能，Integer i = 1; 自动变成Integer i= Integer.valueOf(1); 
	 * 如果在执行int j = i; 就会自动变成int j = i.intValue(); 即自动拆箱。（int i=1; 不等于 Integer i=1;）
	 */
	public static void test1() {
		Integer a = 100, b = 100;
		Integer c = 1000, d = 1000;
		System.out.println(a == b); //true
		System.out.println(c == d); //false
		
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		System.out.println(i == j); //真正的两个不同的对象，当然不一样
	}
	
	//Integer 与 int 的比较，表面看是引用类型与基本数据类型的比较，其实在JDK1.5之后，比较时Java会自动获取Integer
	//的值，然后比较两者的值（也就是说是按照基本数据类型来比较）。
	public static void test2() {
		int i = 1000;
		Integer j = new Integer(1000);
		System.out.println(i == j); //true
	}
	
	public static void test3() throws Exception {
		Class cache = Integer.class.getDeclaredClasses()[0];
		Field myCache = cache.getDeclaredField("cache");
		myCache.setAccessible(true);
		Integer[] newCache = (Integer[])myCache.get(cache); //通过反射获取缓存中的cache
		newCache[132] = newCache[133]; //128 + 4 = 132，即缓存中的第四个对象被第五个对象覆盖
		int a = 2;
		int b = a + a;
		System.out.println(a + " + " + a + " = " + b); //2  4
		System.out.printf("%d + %d = %d", a, a, b);
	}
}