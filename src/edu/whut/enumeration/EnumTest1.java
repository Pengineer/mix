package edu.whut.enumeration;

import org.junit.Test;

/**
 * @Description��ö����
 */
public class EnumTest1 {

	@Test
	public void test(){
		System.out.println(stu1.A.name() + "/" + stu1.A.getClass().getName());
		System.out.println(stu2.A.getvalue());
	}
	
	/*
	 * �޳�Ա������ö���࣬����A,B,C,D,E,F���������͵ı�������stu1���͵Ķ���
	 */
	enum stu1{
		A,B,C,D,E,F; //�൱��new��6��stu1����
	}
	/*
	 * �й��캯���ͳ�Ա������ö����
	 */
	enum stu2{
		A("90-100"),B("80-89"),C("70-79"),D("60-69"),E("1-59"),F("0");
		
		private String value;
		private stu2(String value){
			this.value = value;
		}
		
		public String getvalue(){
			return this.value;
		} 
	}

}
