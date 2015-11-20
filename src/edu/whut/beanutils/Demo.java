package edu.whut.beanutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class Demo {
	/*
	 * function:��������ֵ������Ҫ��ͨ��Introspector�������õ�set������
	 */
	@Test
	public void test1() throws Exception{ 
		Person p = new Person();
	
		BeanUtils.setProperty(p, "name", "Smith");
		
		System.out.println(p.name);
		
	}
	
	/*
	 * function:����ʵ�����ύ�ı����ݣ�ȫ����String���ͣ���������Ա���ԡ�
	 */
	@Test
	public void test2() throws Exception{ 
		Person p = new Person();
		//�û��ύ�ı����ݣ�����age��Ӧ����int
		String name = "Jhon";
		String age = "23";
		//age������int���͵ģ���������String���ͣ��ڸ�ֵʱ�����߰����Զ���������ת��
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "age", age);
		
		System.out.println(p.name);
		System.out.println(p.age);
		
	}
	
	/*
	 * function:����ʵ�����ύ�ı����ݣ�ȫ����String���ͣ���������Ա���ԡ�
	 *       ***���Ǹù��߰�Ĭ��ֻ֧��8�ֻ�����������֮���ת����Ҫ��ʵ�ָ����ӵ�ת����Ӧ����
	 *       ***ע��һ������ת������
	 */
	@Test
	public void test3() throws Exception{ 
		Person p = new Person();

		String name = "Jhon";
		String age = "23";
		String birthday = "1991-01-01";
		
		//ע������ת����,��String����ת����Data����
		ConvertUtils.register(new Converter(){
			@Override
			public Object convert(Class type, Object value) {
				//û��������
				if(value==null)
					return null;
				//����Ĳ����ַ���
				if(!(value instanceof String))
					throw new ConversionException("ֻ֧��String����תData����");
				//�����ȫ�ǿո�
				if(value=="")
					return null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return format.parse((String)value);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
			
		}, Date.class);

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.birthday);
		//���Tue Jan 01 00:00:00 CST 1991��������yyyy-MM-dd��ʽ������Ϊbirthday��date���ͣ�
		//sop��ӡʱ����Ϊ�ַ�����ӡ��Ҳ����˵��������toString����
		System.out.println(p.birthday.toLocaleString());
	}
	
	/*
	 * function:ʹ�ù��߰��Դ�������ת����ʵ��ת������һ��ȱ�㣺�Կ��ַ������벻�ܼ�⣩
	 */
	@Test
	public void test4() throws Exception{ 
		Person p = new Person();

		String name = "Jhon";
		String age = "23";
		String birthday = "2000-01-01";
		
		ConvertUtils.register(new DateLocaleConverter(),Date.class);//�Դ�������ת����
		
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.birthday);
		//���Tue Jan 01 00:00:00 CST 1991��������yyyy-MM-dd��ʽ������Ϊbirthday��date���ͣ�
		//sop��ӡʱ����Ϊ�ַ�����ӡ��Ҳ����˵��������toString����
		System.out.println(p.birthday.toLocaleString());
	}
	
	/*
	 * function:���ϵķ�������ͨ��BeanUtils.setProperty���������ԡ�
	 *          ����һ�ַ��� ����ͨ��map����ͨ��BeanUtils.populate�������Ը�ֵ��
	 */
	@Test
	public void test5() throws Exception{
		Map m = new HashMap();
		
		m.put("name", "Smith");
		m.put("age", "23");
		m.put("birthday", "2000-01-01");
		
		ConvertUtils.register(new DateLocaleConverter(),Date.class);//�Դ�������ת����
		
		Person p = new Person();
		BeanUtils.populate(p, m);
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.birthday);
	}
}
