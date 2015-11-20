package edu.whut.xml;

/**
 * ��ʵ�ʿ����У�����Ҫ�������������ݷ�װ�������У���Demo���ǽ����װ�ɶ���Ȼ��add��list������
 * 
 * SAX���������׳��ֿ�ָ���쳣����Ϊ��ǩ��Ŀո�ᱻ��ȡ������Ҫ���жϵ���ԡ�
 */

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo3_3 {
	
	public static void main(String[] args) throws Exception{
	
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser sp = factory.newSAXParser();
		XMLReader reader = sp.getXMLReader();
		reader.setContentHandler(new BeanListHandler());//Ϊ��ȡ��ע��һ��������
		reader.parse("src/edu/whut/xml/book.xml");
	}
}

class BeanListHandler extends DefaultHandler{
	private String currentTag;
	private String name;
	private String author;
	private String price;
	Demo3_3_Book book;
	List<Demo3_3_Book> list = new ArrayList<Demo3_3_Book>();
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentTag = qName;
		if("��".equals(currentTag)){
			book = new Demo3_3_Book();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("����".equals(currentTag)){
			name = new String(ch,start,length);
			book.setName(name);
		}
		if("����".equals(currentTag)){
			author = new String(ch,start,length);
			book.setAuthor(author);
		}
		if("�ۼ�".equals(currentTag)){
			price = new String(ch,start,length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("��".equals(qName)){
			list.add(book);
			book = null;
		}
		currentTag = null;   //û����һ��ͻᱨ����ָ���쳣,����Ľ�����ǩ֮��book=null�� ��currentTag���ǵ���"�ۼ�"������</book>֮��Ŀո�ʱ��ִ��character�������������ifƥ�䣬����book=null����˿�ָ���쳣
	}

	@Override
	public void endDocument() throws SAXException {
		for(Demo3_3_Book bk : list){
			System.out.println(bk.getName()+","+bk.getAuthor()+","+bk.getPrice());
		}
	}
	
}
