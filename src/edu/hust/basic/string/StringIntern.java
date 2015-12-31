package edu.hust.basic.string;

/**
 * intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表
 * 池中这个字符串的String对象；否则，将此String对象包含的字符串添加到常量池中，并且返回次String对象的引用。
 * 
 * 由于JDK1.7开始对方法区“永久代”的调整，导致在不同的JDK下面运行，下面的结果会不一样。
 * 
 * @see 《深入理解Java虚拟机 第二版》 P56-57
 * @author 2015-12-23
 *
 */
public class StringIntern {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
		String str3 = "javase";
		System.out.println(str3.intern() == str3);
	}
}
