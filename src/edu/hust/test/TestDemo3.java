package edu.hust.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo3 {

	public static void main(String[] args) {
		String[] strs = regGroup("abcd123abcd123abcd", "abcd");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
		System.out.println("---------------------------------");
		
		List<String[]> list = regGroupAll("abcd123abcd123abcd", "abcd");
		for(String[] str : list) {
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
		}
	}
	
	public static String[] regGroup(String text, String reg){
		Matcher m = Pattern.compile(reg, Pattern.CASE_INSENSITIVE).matcher(text);
		if (!m.find()) {
			return null;
		}
		String[] res = new String[m.groupCount() + 1];
		for (int i = 0; i <= m.groupCount(); i++) {
			res[i] = m.group(i).trim();
		}
		return res;
	}
	
	public static List<String[]> regGroupAll(String text, String reg){
		List<String[]> ans = new ArrayList<String[]>();
		Matcher m = Pattern.compile(reg, Pattern.CASE_INSENSITIVE).matcher(text);
		while (m.find()) {
			String[] res = new String[m.groupCount() + 1];
			for (int i = 0; i <= m.groupCount(); i++) {
				res[i] = m.group(i).trim();
			}
			ans.add(res);
		}
		return ans;
	}

}
