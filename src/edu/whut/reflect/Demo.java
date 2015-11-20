package edu.whut.reflect;

import java.lang.reflect.Array;

public class Demo {

	public static void main(String[] args) throws Exception{
		String str = "abc";
		
		//��ȡ�ֽ�������ֳ�������
		
		Class cls1 = str.getClass();
		
		Class cls2 = String.class;
		
		Class cls3 = Class.forName("java.lang.String");
		
		System.out.println(cls1 == cls2);
		System.out.println(cls1 == cls3);
		
		System.out.println(cls1.isPrimitive());  //String����ԭʼ������������
		System.out.println(int.class.isPrimitive());
		
		System.out.println(int.class == Integer.class);//int��Integer
		System.out.println(int.class == Integer.TYPE);
		/*
		int a = Integer.parseInt("123");
		int b = Integer.valueOf("12");
		System.out.println(a + " ,  " + b);
		
		String s1 = 1 + "";
		//String s2 = a.toString();
		String s2 = new Integer(a).toString();
		*/
		
		int[] a = new int[]{1,2,3};
		printObject(a);
		printObject("abc");
	}
	//���󣺴�ӡ�����ֵ
	//�������������ͨ�����ֱ�Ӵ�ӡ��������������Ҫ���жϡ�
	//		��������жϾ�ʹ�õ��˷��似��,�ֽ���ķ�����Class.isArray();
	//      �Խӿ�,ö�ٵ��ж�Ҳ�ø÷�����
	public static void printObject(Object obj) {
		Class cls = obj.getClass();
		if(cls.isArray()){
			int len = Array.getLength(obj);
			int num = Array.getInt(obj, 0);
			System.out.println(len+","+num);
		}
		else
			System.out.println(obj);
	}

}
