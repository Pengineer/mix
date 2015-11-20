package edu.hust.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestDemo1 {
	public static void main(String[] args){
//		System.out.println("fdsa地方著".matches("^.*[、，等著编（）() ？；].*$"));
		System.out.println(System.getProperty("user.home"));
	}
	public static void test1(){
		String str1 = null;
		String str2 = null;
		if(str1 != null && Integer.parseInt(str1)>3){
			System.out.println("hehe");
		}else{
			System.out.println("xixi");
		}
	}
	
	public void test2(){
		Map<String, ArrayList<String>> testMap = new HashMap<String, ArrayList<String>>();
		for (int i=0; i<500000; i++){
			testMap.put(System.currentTimeMillis() +"", new ArrayList<String>());
		}
		
		Date begin = new Date();
		ArrayList<String> str = testMap.get(System.currentTimeMillis()+"");
		System.out.println(new Date().getTime() - begin.getTime() + "..."+ str);
	}
	
	public static void cmp() {
		byte[] bytes = new byte[1024];
		bytes[0] = 12;
		bytes[1] = 'a';
		int abc = bytes[1];
		System.out.println(bytes[0]);
		System.out.println(bytes[1]);
	}
	
	 public static int readInt(byte[] bytes, int start) {
		    return (((bytes[start  ] & 0xff) << 24) +
		            ((bytes[start+1] & 0xff) << 16) +
		            ((bytes[start+2] & 0xff) <<  8) +
		            ((bytes[start+3] & 0xff)));

		  }
	
}
