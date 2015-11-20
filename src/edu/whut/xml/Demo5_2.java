package edu.whut.xml;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * xpath��һ��Ӧ�ã������������XML�ĵ�����ʽ�洢�ģ��ɽ������ݿ���˺�����ƥ��
 */

public class Demo5_2 {

	public static void main(String[] args) throws DocumentException {
		
		String username = "zhangsan";
		String password = "123";
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/edu/whut/xml/user.xml"));
		//ע�ⵥ����
		Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		
		if(node == null){
			System.out.println("�û������������");
		}else{
			System.out.println("��¼�ɹ�");
		}
	}
}
