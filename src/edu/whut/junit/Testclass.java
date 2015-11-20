package edu.whut.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Description��ΪPrototypeclass�ഴ���Ĳ����ࡣ
 * 			����Ҫ��������Testclass�������еķ���ʱ��������outline�����У�ѡ��Testclass���һ�ѡ��Run as > Junit Test;
 * 			���ֻ��Ҫ����ÿһ�����������ǿ�����outline������ѡ�и÷�����Ȼ���һ�ѡ��Run as > Junit Test;
 * 
 * @attention��ע��before/after �� beforeclass/afterclass ������ǰ������ÿһ�����Է��������ж���ɶ�ִ��һ�Σ�������
 * 			        ������Testclass����������ǰ�����к�ִ�У�ִֻ��һ�Ρ���Σ���������Ǿ�̬�ġ�
 */

public class Testclass {
	Prototypeclass p ;
	
	@BeforeClass
	public static void beforeclass(){
		System.out.println("beforeclass");
	}
	
	/*
	 * @Function:����������ǰ���������Զ�����before����
	 */
	@Before
	public void before(){
		p = new Prototypeclass();
		System.out.println("before");
	}
	
	/*
	 * @Function:����Prototypeclass���е�method1����
	 */
	@Test
	public void testmethod1(){
		p.method1();
		System.out.println("method1 run");
	}
	
	/*
	 * @Function:����Prototypeclass���е�method2����
	 */
	@Test
	public void testmethod2(){
		p.method2();
		System.out.println("method2 run");
	}
	
	/*
	 * Assert��һ�������࣬�����������Ժ��������磺���Զ����Ƿ���ȣ�ֵ�Ƿ���ȣ������Ƿ�Ϊ�յȣ�
	 * 		���Է����ִ���Ϣ�ĺͲ�����Ϣ�ģ�����Ϣ�ľ��ǵ�ʵ��ֵ������ֵ��һ��ʱ�����������Ϣ
	 */
	@Test
	public void testmethod3(){
		Assert.assertEquals("���Է���ֵ����", "method3", p.method3());
	}
	
	/*
	 * ���Խ���ʱ��ϵͳ���Զ�����after����
	 */
	@After
	public void after(){
		p = null;
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterclass(){
		System.out.println("afterclass");
	}
}
