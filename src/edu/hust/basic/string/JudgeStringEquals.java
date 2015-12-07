package edu.hust.basic.string;

/**
 * 预备知识：JVM内存管理
 * 参考：
 * @see http://blog.csdn.net/clam_clam/article/details/6831345
 * @see http://hxraid.iteye.com/blog/687660
 * 
 * @author 2015-12-03
 *
 */
public class JudgeStringEquals {
	public static void main(String[] args) {
		String str1 = "abc";   //通过常量池在编译期创建了一个String对象
		String str2 = "abc";   //没有创建对象
		System.out.println(str1 == str2);  //true，str1和str2存储的都是堆中唯一的那个拘留字符串对象的地址
		String str3 = "abc" + "abc";  //通过常量池在编译期创建了一个String对象。编译时，JVM直接将其变成“abcabc”
		String str4 = str1 + str2;   //创建了2个的对象：StringBuilder对象；执行StringBuilder.toString()时创建String对象。如果没有str3，在常量池中不会有“abcabc”
		String str5 = "a" + "bc";    //没有创建对象
		String str6 = new String("a") + "bc";  //创建了2对象（如果没有上面的代码，创建3个对象，因为通过常量池会创建一个拘留字符串对象）
		System.out.println(str3 == str4);  //false
		System.out.println(str1 == str5);  //true
		System.out.println(str1 == str6);  //false
		String s1 = new String("a");    //创建两个相同字符串值的String对象：一个是拘留字符串对象，一个是new新建的字符串对象
		String s2 = new String("b");    //创建了2个对象
		String s3 = new String("a");    //创建了1个对象（因为有s1那一行），此时堆中有3个字符串值为“a”的对象
		System.out.println(s1 == s2);   //false
		System.out.println(s1 == s3);   //false
	}
	
	//参考：http://zhidao.baidu.com/link?url=1tKBA3gruiWrzrJ_Lsv91Mo35qStLGDhqc_71776F-7ylww1Ly3E_1czeztMGqLgbRGafMwp3Dx-M2CgryF0Ta
	public static void method1() {
		//这两句代码共有几个对象？
		String str = new String("hello"); 
		str+="Java";  
	}
	
	/*
	 * 根据clam_clam的博客，纠正下面网友“综上”中不严格的注释，str1是常量池的，但是通过str1创建的对象不再常量池中，
	 * 还是在堆中，这个对象叫“拘留字符串对象”，CONSTANT_String_info常量表的入口地址已经转变成这个堆中String对象的直接地址(常量池解析)了。
	 */
	public static void method2() {
		String str1 = "Java";
		System.out.println(str1.intern() == str1);//true，表名str1是常量池的

		String str2 = new String("hello");
		System.out.println(str2.intern() == str2);//false，表名str2不是常量池的

		String str3 = new String("hello") + "Java";
		System.out.println(str3.intern() == str3);//false，表明str3不是常量池的,也说明编译的时候没有将“hello”和“Java”相连

		String str4 = "hello" + "Java";
		System.out.println(str4.intern() == str4);//true,表明str4是常量池的，也从侧面表明在编译的时候已经做了相加的操作了
//		综上
//		method1的例子中会有5个对象，因为是new String("hello")，所以这个不是常量，而“Java”是常量
//		首先，“hello”在堆和常量池各一个
//		其次，“Java”在常量池有一个
//		最后，“helloJava”在堆和常量池各一个
	}
	
}
