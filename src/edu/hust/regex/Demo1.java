package edu.hust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
	public static void main(String[] args){
		
	//	match("ab", "..");
		
	//	split("a.b.c","\\.");               //��.�и�Ҫע����κ��ַ���.Ū��
		
	//	split("abccjdeffgtss","(.)\\1");  //ʹ����()�ĸ���ƥ����ʣ�(.)��ʾ��ȡ����һ���ַ�����װ���飬\1��ʾȡ��һ��(\Ҫת��)��()��ʾ��һ����
		
	//	split("abccjdeffgtss","(.)\\1+");
		
	//	replaceAllTest("bhffdsjiiaouipw","(i)\\1+","");//ɾ������i
		
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
		Pattern p = Pattern.compile(reg);//��װ������ʽ
		Matcher m = p.matcher(str);      //�õ�������ʽ��ƥ������(ƥ����)�����������ַ���
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
}
