package edu.hust.test;

public class InstanceOfTest {
	
	public static void main(String[] args) {
		
		String[] strings = new String[1];
		
		Object object=null;
		
		object = strings;
		
		if (object instanceof Object) {
			System.out.println(".");
		} 
		
		if (object instanceof Object[]){
			System.out.println("..");
		} 
		
		Object[] obj1 = new Object[1];
		if (obj1 instanceof Object) {
			System.out.println("...");
		}
	}
}
