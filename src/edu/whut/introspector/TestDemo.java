package edu.whut.introspector;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * �������裺ͨ����������������ȡ���Ե�set��get����
 */

public class TestDemo {
	/*
	 * function:�õ�bean����������
	 */
	@Test
	public void test1() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);
		PropertyDescriptor[] prop = info.getPropertyDescriptors();
		for(PropertyDescriptor p : prop){
			System.out.println(p.getName());
		}
	}
	
	/*
	 * function:����bean��ָ������
	 */
	@Test 
	public void test2() throws Exception{
		Person p = new Person();
		//����age���Ե�����������
		PropertyDescriptor des = new PropertyDescriptor("age", Person.class);
		//�����д���Է�����public void setAge(int age)
		Method m1 = des.getWriteMethod();   
		m1.invoke(p, 23);
		
		Method m2 = des.getReadMethod();   //public int getAge()
		System.out.println(m2.invoke(p, null));
	}
	
	/*
	 * function:��ȡ��ǰ�������Ե�����
	 */
	@Test
	public void test3() throws Exception{
		Person p = new Person();
		PropertyDescriptor des = new PropertyDescriptor("age", Person.class);
		Class c = des.getPropertyType();
		System.out.println(c);
	} 
}
