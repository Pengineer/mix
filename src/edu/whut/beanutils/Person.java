package edu.whut.beanutils;

import java.util.Date;


/**
 * @Description��
 * edu.whut.introspector����ʹ�õ��Ǵ�ͳ������
 * edu.whut.beanutils��ʹ�õ��ǵ������������߰�����SUN��˾����ר��������ԵĲ�����
 */

public class Person {
	public String name;
	public int age ;
	public Date birthday;
	
	//����һ����5����Ա���ԣ������ֶΣ���ABC��name��age��birthday��class����Object�̳У�
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getABC(){
		return "ABC";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
