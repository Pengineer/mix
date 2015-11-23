package edu.hust.regex;

public class RegexTest {
	public static void main(String[] args){		
		System.out.println(test("��ѧԺ.�������غ��ؽ���չ�о�Ժ"));
	}
	
	
	
	public static String test(String str){
		//"��ɽ��ѧ"��"��Ͽ��ѧ  ��ѧ�봫ýѧԺ"��" ���ݹ���ѧԺ"��"�Ϻ���ͨ��ѧ����ѧԺ��ʷϵ"��"�����缱��ҽѧ��־���༭��"��"�й����ʴ�ѧ���人��"
		//"���пƼ���ѧ�Ļ�ѧԺ"
		//"�й����ʴ�ѧ���人��������"��"�й�ʯ�ʹ�ѧ(����)"��"�й�ʯ�ʹ�ѧ��������"��"�й���ҵ��ѧ��ί�졢��촦"��"�й�����ѧԺ���人��ѧ��ʿ�ڶ���"
		//"��������ѧ������˼���壩ѧԺ"��"����ʦ��ѧԺ����ѧԺ���ڶ���ʿ��"��"��Ϣ����ѧԺ������ѧԺ��"��"�Ͼ�������ѧѧ��������ѧ�棩"
		//"��ί�칫��/Ժ���칫��"��"��ί�칫�ҡ�Ժ���칫��"��"��ί��У�����칫��"
		//"��չ�滮��"��"��չ�滮�����ߵȽ����о���"��"��չ�滮����ҽѧ�����о����ģ�"
		//"���ִ�ѧ��ѧԺ/�߽������о�����","���ִ�ѧ��ѧԺ �߽������о�����","ѧ���༭��/֪ʶ��Ȩ����"
		//"��������ҵ��ѧ��������������"��"��������ҵ��ѧ������ѧԺ","��ˮʦ��ѧԺ��������������ѧ��"
		//"��ѧԺ�����ڹ����о�����"��"��ѧԺ  ������ѧ�빤��ϵ"��"��ѧԺ���غ��ؽ���չ�о�Ժ","��ѧԺ�����ݳ���һ�廯�о�Ժ","��ѧ��������ѯ���ģ��Կ�ѧ�о���"
		//"���� �ӱ����ϴ�ѧ����ѧԺ"��"��տ��ʦ��ѧԺ����ѧԺ"��"WTO�о�����ѧԺ"," ��Ʋ�"��"��Ͽ��ѧ�����о�����"��"�Ϻ����̼�����ѧѧ��������������"
		
		String str1 = str.replaceAll("\\s+", "");  //ɾ���ո�,trimֻ��ɾ����β�ո�
		String str2 = str1.replaceAll("[;��,������\\./~]+", "��"); //��ѧԺ���غ��ؽ���չ�о�Ժ        ��ѧԺ�����ݳ���һ�廯�о�Ժ      ���ִ�ѧ��ѧԺ/�߽������о�����
		String str3 = str2.replaceAll("\\((.*?)\\)", "��$1��"); //Ӣ�����ű���������
		String str4 = str3.replaceAll("��*", "").trim();
		String str5 = str3.replaceAll("\\��(.*?)\\��", ""); //ȥ�����ż�������(�����ж�)
		
		if(str5.contains("��ѧ")){
			if(str5.endsWith("��ѧ")){  //��ɽ��ѧ
				return ""; //����null����ȷ����
			}
			
			String[] strs = str4.split("��ѧ");
			if(strs[1].matches("\\��(.*?)\\��")){  //�й����ʴ�ѧ���人��
				return "";  //����null����ȷ����
			}else if (strs[1].startsWith("��", 0)){  //�й����ʴ�ѧ���人��������
				return strs[1].replaceAll("\\��(.*?)\\��", "");
			}else if (strs[1].matches("[,��/����;-~]+(.*?)")){ //��������ҵ��ѧ������ѧԺ
				return strs[1].replaceAll("[,��/����;-~]+", "");
			}else {
				return strs[1];  
			}
		} 
		
		return str4;
		
	}
}