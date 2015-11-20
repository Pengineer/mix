package edu.whut.xml;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 *��XML�ĵ��Ĳ�νṹ�ϸ���ʱ����XML�ĵ��Ķ�ȡ�ͻ��ԵúܷѾ�������һ�����XPath API����XML�ĵ�
 *�Ķ�ȡ������
 */

public class Demo5_1 {	
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book.xml");
		
		//selectSingleNode�����ص�һ��ƥ��ڵ�
		String author = document.selectSingleNode("//����").getText();
		System.out.println(author);
	}

}
