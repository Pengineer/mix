package edu.whut.reflect;

/**��Ŀ�����е�JRE System LibraryĿ¼�¾��ṩ��ϵͳ�������Զ���Class�࣬�������������*/

public class ClassLoaderDemo {

	public static void main(String[] args) {
		//1��ͨ��Class�����ȡ��������������Ȼ��õ����������Class�࣬Ȼ��������
		System.out.println(
				ClassLoaderDemo.class.getClassLoader().getClass().getName());
		//�����sun.misc.Launcher$AppClassLoader@1372a1a��˵���������������������AppClassLoader
		
		//2����ȡϵͳ�Զ�������������
		System.out.println(System.class.getClassLoader());
		//�����null��˵��System������������BootStrap��Ƕ����JVM�е���ײ������������C++��д�ķ�java�ࣩ
	
	}

}
