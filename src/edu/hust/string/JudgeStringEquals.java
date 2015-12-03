package edu.hust.string;

/**
 * 预备知识：JVM内存管理
 * 参考：http://blog.csdn.net/clam_clam/article/details/6831345
 * 
 * @author 2015-12-03
 *
 */
public class JudgeStringEquals {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);
		String str3 = "abc" + "abc";
		String str4 = str1 + str2;
		String str5 = "a" + "bc";
		System.out.println(str3 == str4);
		System.out.println(str1 == str5);
		String s1 = new String("a");
		String s2 = new String("b");
		System.out.println(s1 == s2);
	}
}
