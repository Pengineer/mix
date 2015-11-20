package edu.whut.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/*
 * function:��ȡXML�ĵ�ָ�����ݣ���ǩ����Ϊ����
 */

public class Demo3_2 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, Exception {
		//1��������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2���õ�������
		SAXParser sp = factory.newSAXParser();
		
		//3���ɽ������õ���ȡ��,���ö�ȡ��ȥ��XML�ĵ�(dom������ֱ���ý�����ȥ����XML�ĵ�)
		XMLReader reader = sp.getXMLReader();
		
		//4���������ݴ�������HandlerList�൱���¼���������û��ȡ��һ�����ͻ�ִ����Ӧ�ķ�����
		reader.setContentHandler(new TagValueHandler());
		
		//5����ȡXML�ĵ����ݣ���ʼ����
		reader.parse("src/edu/whut/xml/book.xml");
	}
}

/**
 * function����ȡָ����ǩ������
 * 
 *ʵ�ʿ���һ�㲻����Demo3_1������ȥֱ��ʵ��ContentHandler�ӿڣ������Ļ�Ҫ��д�ķ���̫�࣬���
 *����һ��̳���ʵ��ContentHandler�ӿڵ����࣬Ȼ��д����������Ҫ�ķ������ɡ�
 */
class TagValueHandler extends DefaultHandler{
	private String name;             //�������ĵ�ǰ��ǩ��
	private int expectNumber = 2;    //�����������ĵڼ�������
	private int currentNumber = 0;   //��ǰ�������ĵڼ�������
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		name = qName;
		if(name.equals("����")){
			currentNumber++;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)//"����".equals(name)
			throws SAXException {		
		//ע�ⲻ��д��name.equals("����")����Ϊ</����>��</����>��</�ۼ�>֮��Ŀո�ᱻ����
		//���ݵĿյ��ַ�������ʱname=null��Ҳ��û��equals������
		if("����".equals(name) && currentNumber == expectNumber){
			System.out.println(new String(ch,start,length));
		}
		
		/* ����д�ɣ�
		 if(name != null && name.equals("����") && currentNumber == expectNumber){
			System.out.println(new String(ch,start,length)); 
		 }*/
		 
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		name = null;
	}
	
}
