package edu.hust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
	public static void main(String[] args){
		
	//	match("ab", "..");
		
	//	split("a.b.c","\\.");               //按.切割要注意和任何字符的.弄混
		
	//	split("abccjdeffgtss","(.)\\1");  //使用组()的概念匹配叠词：(.)表示获取任意一个字符并封装成组，\1表示取第一组(\要转义)，()表示是一个组
		
	//	split("abccjdeffgtss","(.)\\1+");
		
	//	replaceAllTest("bhffdsjiiaouipw","(i)\\1+","");//删掉叠词i
		
	//	get("hua zhong ke ji da xue","\\b[a-z]{3}\\b");
	}
	
	public static void match(String str, String reg){
		System.out.println(str.matches(reg));
	}

	
	public static void split(String str,String reg){
		String[] strs = str.split(reg);
		for(String s : strs){
			System.out.println(s);
		}
	}
	
	public static void replaceAllTest(String str, String reg, String rpStr){
		String newStr = str.replaceAll(reg, rpStr);
		System.out.println(newStr);
	}
	
	public static void get(String str, String reg){
		Pattern p = Pattern.compile(reg);//封装正则表达式
		Matcher m = p.matcher(str);      //得到正则表达式的匹配引擎(匹配器)，并作用于字符串
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
}
