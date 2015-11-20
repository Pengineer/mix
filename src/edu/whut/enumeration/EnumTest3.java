package edu.whut.enumeration;

import org.junit.Test;
/**
 * 
 * @Description:ö�ٳ��÷�������
 * 
 * name(): ��ȡö��ֵ������
 * ordinal():��ȡö��ֵ��λ��
 * valueOf():���ַ���ת��ö������
 * values():����ö��ֵ
 */
public class EnumTest3 {
	@Test
	public void test(){
		System.out.println(stu.A.name());
		System.out.println(stu.A.ordinal());
		
		System.out.println("----------------------------");
		
		//�ô������ڿͻ����ύ�ı����ݶ����ַ������͵ģ�������ǿ��Խ�ĳЩ�ַ���ת��ö�����ͣ������Ƿ��������Ƕ����ö����,�����ǣ����׳��쳣
		String str = "B";
		stu s = stu.valueOf(stu.class, str);
		System.out.println(s.name());
		
		System.out.println("----------------------------");
		
		stu[] stus = stu.values();
		for(stu S : stus){
			System.out.println(S);
		}
	}
	
	enum stu{
		A("90-100"),B("80-89"),C("70-79"),D("60-69"),E("1-59"),F("0");
		
		private String value;
		private stu(String value){
			this.value = value;
		}
		
		public String getvalue(){
			return this.value;
		} 
	}
}
