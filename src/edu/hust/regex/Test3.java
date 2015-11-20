package edu.hust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//"学生   学生/学生   大学生   学生/研究生  在读大学生 在校学生   在校学生/辅导员  MSW学生   讲师/学生办副主任  学生办副主任  五年制学生   法学研究生   (博士)  学生(在读)......."
public class Test3 {
	public static void main(String[] arg){
		System.out.println(test("学生(在读)"));
		
	}
	
	public static boolean test(String str){
		String str1 = str.replaceAll("\\s+", "");  
		String str2 = str1.replaceAll("[;；,，、。\\./~]+", "/"); 
		String str3 = str2.replaceAll("\\((.*?)\\)", "（$1）"); 
		String str4 = str3.replaceAll("\\（(.*?)\\）", "$1");
		
		if(str4.matches("^(.*)(学生|在读|研究生|本科生|硕士生?|博士生?)$")){
			return true;
		}
		
		String[] strs = str4.split("/");
		for(String s :strs){
			if(s.matches("^(.*)(学生|在读|研究生|本科生|硕士生?|博士生?)$")){
				return true;
			}
		}
		
		return false;
	}
}
