package edu.whut.reflect;

/**
 * @Description:ע�ⷴ�似����Ҫ����������ܵģ�����ǻ��������ļ��ġ�����������������
 */

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReflectPerson {
	/*************************��ȡ���캯��*******************************************/
    /*
     * function:����ͨ�����似����ȡperson����޲ι��캯������ͨ���ù��캯������personʵ������
     * attention�����似����getConstructorֻ�ܻ�ȡpublic���εĹ��캯��
     */
	@Test
	public void reflectDemo1_1() throws Exception{
		
		//��person����ص��ڴ��У���ȡperson����ֽ���
		Class clazz = Class.forName("edu.whut.reflect.Person");
		//��ȡ�ֽ����еĿղ������캯��
		Constructor con = clazz.getConstructor(null);
		//ͨ�����캯������ʵ������
		Person p = (Person) con.newInstance(null);
	} 
	
	/*
	 * function:��ȡ��һ�������Ĺ��캯��
	 */
	@Test
	public void reflectDemo1_2() throws Exception{
		
		Class clazz = Class.forName("edu.whut.reflect.Person");
		//���봫��������͵��ֽ�����ʽ
		Constructor con = clazz.getConstructor(String.class);		
		Person p = (Person) con.newInstance("with paragram");
	}
	
	/*
	 * function:��ȡ������εĹ��캯��
	 */
	@Test
	public void reflectDemo1_3() throws Exception{
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Constructor con = clazz.getConstructor(String.class,int.class);//int.class
		Person p = (Person) con.newInstance("Jhon",20);
	}
	
	/*
	 * function: ��ȡ˽�й��캯��
	 * addition:1��getConstructorֻ�ܷ���public���εĹ��캯����getDeclaredConstructor����
	 * 			2����˽�л��ĳ�Աһ���ǲ��ɱ������ʵģ������ڷ��似���ǿ��Եģ����������䣺setAccessible
	 */
	@Test
	public void reflectDemo1_4() throws Exception{
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Constructor con = clazz.getDeclaredConstructor(List.class);
		con.setAccessible(true);//�������䣬��ȡ˽�й��캯����ʵ������
		Person p = (Person) con.newInstance(new ArrayList());
	}
	
	/*
	 * function:��ȡ�޲ι��캯������һ�ַ�������ͬ��reflectDemo1
	 */
	@Test
	public void reflectDemo1_5() throws Exception{
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Person p = (Person) clazz.newInstance();
	}
	
	/************************��ȡ��Ա����********************************************/
	/*
	 * function����ȡ�޲εĳ�Ա�������������ж���
	 */
	@Test
	public void reflectDemo2_1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getMethod("method1", null);
		mt.invoke(p, null);//ִ��method1����
	}
	
	/*
	 * function:��ȡ���εĳ�Ա�������������ж���
	 */
	@Test
	public void reflectDemo2_2() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getMethod("method2", int[].class);
		mt.invoke(p, new int[]{20,21});
	}
	
	/*
	 * function:��ȡ�з���ֵ���͵ĳ�Ա�������������ж���
	 */
	@Test
	public void reflectDemo2_3() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getMethod("method3", null);
		String str = (String) mt.invoke(p, null); 
		System.out.println(str);
	}
	
	/*
	 * function:��ȡ˽�г�Ա�������������ж���
	 */
	@Test
	public void reflectDemo2_4() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getDeclaredMethod("method4", null);
		mt.setAccessible(true);
		mt.invoke(p, null);
	}
	
	/*
	 * function:��ȡ��̬��Ա���������Բ����ж��󣬿��п���
	 */
	@Test
	public void reflectDemo2_5() throws Exception{
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getMethod("method5", null);
		mt.invoke(null, null);
	}
	/*
	 * function:��ȡmain������
	 * attention���Բ���Ϊ�ַ�������ķ�����ע�⣬invoke(Object obj, Object... args)�����ĵڶ���������һ��
	 *            �ɱ�������ͣ����������飬��˴���һ��new String[]{"Smith","Jhon"}��ϵͳ�Ὣ����ֳ�����String
	 *            ���Ͳ����������ǵ�����һ������(**��ʱ��֪��ΪʲôreflectDemo2_2�е�int�������ֱ�Ӵ��ݣ�������**--�ѽ������Ϊ21��int�������ͣ����ܵ�����Ϊ������ڣ�ֻ��int[]������Ƕ���)��
	 *            SUN������Ŀ����Ϊ�˼����޿ɱ���������ڰ汾������ ���ڶ������Ա������invoke�ĵڶ���������һ��Object���飬
	 *            ��invoke���յ�һ������ʱ�����Զ�����������в�֣���ɶ��������          
	 *            �������: 1��������������ٴη�װ��Object���͵����飬������Object���ʱ���ͻ�õ�һ��String�������顣
	 *                      2�������鵱����������������������*һ��*Object���󡣣�java��һ�����ݶ�������ڵ��࣬��Щ�඼��Object�����ࣩ
	 */
	@Test
	public void reflectDemo2_6() throws Exception{
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Method mt = clazz.getMethod("main", String[].class);
		//mt.invoke(null, new String[]{"Smith","Jhon"});
		//mt.invoke(null, new Object[]{new String[]{"Smith","Jhon"}});  �������һ
		mt.invoke(null, (Object)new String[]{"Smith","Jhon"});       // ���������
	}
	
	/************************��ȡ��Ա���ԣ��ֶΣ�****************************************/
	@Test
	public void reflectDemo3_1() throws Exception{
		Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Field f = clazz.getField("str");
		Object value = f.get(p);//��ȡ�ֶε�ֵ
		Class obj = f.getType();//��ȡ�ֶ�����
		if(obj == String.class)
			System.out.println(value);
		
		f.set(p, "ABC");//�����ֶε�ֵ
		System.out.println(p.str);
	}
	@Test
	public void reflectDemo3_2() throws Exception{
		//Person p = new Person();
		Class clazz = Class.forName("edu.whut.reflect.Person");
		Field f = clazz.getField("a1");//f�������ֶζ���ͨ������ķ�����ȡֵ
		Object value = f.get(clazz.newInstance());
		Class type = f.getType();
		if(type == int[].class){
			System.out.println(value);
			int len = Array.getLength(value);
			int num = Array.getInt(value, 0);
			System.out.println(len+","+num);
		}
	}
}
