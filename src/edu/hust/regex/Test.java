package edu.hust.regex;

import java.io.ObjectInputStream.GetField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args){
		test1("11111111111111111X");
		
		//System.out.println(test("��Ͽ��ѧ  ��ѧ�봫ýѧԺ"));
			
		//System.out.println(getName("   ��   ��"));
	}
		
	public static String test(String str){
		//"��ɽ��ѧ"��"��Ͽ��ѧ  ��ѧ�봫ýѧԺ"��" ���ݹ���ѧԺ"��"�Ϻ���ͨ��ѧ����ѧԺ��ʷϵ"��"�����缱��ҽѧ��־���༭��"��"�й����ʴ�ѧ���人��"
		//"�й����ʴ�ѧ���人��������"��"�й�ʯ�ʹ�ѧ(����)"��"�й�ʯ�ʹ�ѧ��������"��"�й���ҵ��ѧ��ί�졢��촦"��"�й�����ѧԺ���人��ѧ��ʿ�ڶ���"
		//"��������ѧ�����˼���壩ѧԺ"��"����ʦ��ѧԺ����ѧԺ���ڶ���ʿ��"��"��Ϣ����ѧԺ������ѧԺ��"��"�Ͼ�����ѧѧ��������ѧ�棩"
		//"��ί�칫��/Ժ���칫��"��"��ί�칫�ҡ�Ժ���칫��"��"��ί��У�����칫��"
		//"��չ�滮��"��"��չ�滮�����ߵȽ����о���"��"��չ�滮����ҽѧ�����о����ģ�"
		//"���ִ�ѧ��ѧԺ/�߽������о�����","���ִ�ѧ��ѧԺ �߽������о�����","ѧ���༭��/֪ʶ��Ȩ����"
		//"��������ҵ��ѧ��������������"��"��������ҵ��ѧ������ѧԺ","��ˮʦ��ѧԺ��������������ѧ��"
		//"��ѧԺ�����ڹ����о�����"��"��ѧԺ  �����ѧ�빤��ϵ"��"��ѧԺ���غ��ؽ���չ�о�Ժ","��ѧԺ�����ݳ���һ�廯�о�Ժ","��ѧ��������ѯ���ģ��Կ�ѧ�о���"
		//"���� �ӱ����ϴ�ѧ����ѧԺ"��"��տ��ʦ��ѧԺ����ѧԺ"��"WTO�о�����ѧԺ"," ��Ʋ�"��"��Ͽ��ѧ�����о�����"��"�Ϻ����̼�����ѧѧ��������������"
		 
		String str1 = str.replaceAll("\\((.*?)\\)", "��$1��"); //Ӣ�����ű���������
		String str2 = str1.replaceAll("��*", "").replaceAll("\\s+", "");  //ȥ����ʼ�ģ�
					
		if(str2.contains("ѧԺ") && !str2.endsWith("ѧԺ") && !str2.contains("��")){  //���ִ�ѧ��ѧԺ�߽������о�����      ��ѧԺ�����ѧ�빤��ϵ          ��ѧԺ (xxx)  ��ѧԺ
			int index = str2.indexOf("ѧԺ");
			String[] strs = str2.split("ѧԺ");
			
			if(strs.length == 1){
				str2 = strs[0]+"ѧԺ��";
			}else if(strs.length == 2){
				str2 = strs[0]+"ѧԺ��"+strs[1];
			}
		}
		
		return str2;
	}
	
	public static String getName(String name) {
		name = name.replaceAll("[\\.��,����]+", "��").replaceAll("[^A-Za-z\\u4e00-\\u9fa5 ��]+", "").replaceAll("^[�� ]+", "").replaceAll("[�� ]+$", "");
		Pattern p = Pattern.compile("[A-Za-z]");
		Matcher m = p.matcher(name);
		if (m.find()) {
			name = name.replaceAll("[�� ]+", " ");
		} else {
			name = name.replaceAll("\\s+", "").replaceAll("��+", "��");
		}
		return name;
	}
	
	public static void test(){
		String s = "ab";
		String[] ss = s.split("a");
		System.out.println(ss[1]);
	}
	
	public static void test1(String str){
		System.out.println(str.matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)"));
	}
}