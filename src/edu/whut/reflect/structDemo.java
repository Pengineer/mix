package edu.whut.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class structDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//1�����������ļ�
		InputStream inputstream = new FileInputStream("config.properties");
		/*�������ļ���Դ�ļ���ʱ��InputStream inputstream = structDemo.class.getClassLoader().getResourceAsStream("edu/whut/reflect/config.properties");
		 *                 ����InputStream inputstream = structDemo.class.getResourceAsStream("config.properties");*/
		Properties pro = new Properties();
		pro.load(inputstream);
		inputstream.close();
		
		//2����ȡ�����ļ�������Ϣ��������������ֽ����ļ�������ʵ������
		String className = pro.getProperty("className");
		Collection collection = (Collection) Class.forName(className).newInstance();
		//���÷���ʱд����Collection collection = new Hashset();
		
		//3�����õ�������ķ���������Ӧ����
		Person p1 = new Person("zhang",20);
		Person p2 = new Person("li",21);
		Person p3 = new Person("li",20);
		
		collection.add(p1);
		collection.add(p2);
		collection.add(p3);
		collection.add(p1);
		
		System.out.println(collection.size());
	}

}
