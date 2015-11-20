package edu.hust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//"ѧ��   ѧ��/ѧ��   ��ѧ��   ѧ��/�о���  �ڶ���ѧ�� ��Уѧ��   ��Уѧ��/����Ա  MSWѧ��   ��ʦ/ѧ���츱����  ѧ���츱����  ������ѧ��   ��ѧ�о���   (��ʿ)  ѧ��(�ڶ�)......."
public class Test3 {
	public static void main(String[] arg){
		System.out.println(test("ѧ��(�ڶ�)"));
		
	}
	
	public static boolean test(String str){
		String str1 = str.replaceAll("\\s+", "");  
		String str2 = str1.replaceAll("[;��,������\\./~]+", "/"); 
		String str3 = str2.replaceAll("\\((.*?)\\)", "��$1��"); 
		String str4 = str3.replaceAll("\\��(.*?)\\��", "$1");
		
		if(str4.matches("^(.*)(ѧ��|�ڶ�|�о���|������|˶ʿ��?|��ʿ��?)$")){
			return true;
		}
		
		String[] strs = str4.split("/");
		for(String s :strs){
			if(s.matches("^(.*)(ѧ��|�ڶ�|�о���|������|˶ʿ��?|��ʿ��?)$")){
				return true;
			}
		}
		
		return false;
	}
}
