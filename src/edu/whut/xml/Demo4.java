package edu.whut.xml;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * ����DOM4j������������XML�ĵ��������DOM������SAX��������
 */

public class Demo4 {

	public static void main(String[] args) throws Exception {
	//	read();
	//	readAttr();
	//	add1();
	//	add2();
	//	delete();
		update();
	}
	
	/*��ȡָ����ǩ*/
	public static void read() throws Exception{		
		//1���õ�SAX��ȡ��
		SAXReader reader = new SAXReader();
		//2���õ��ĵ���Document����
		Document document = reader.read("src/edu/whut/xml/book.xml");
		//3��ͨ�����ڵ��ȡ�����ڵ㣨��JAXP����һ�㣩
		Element root = document.getRootElement();
		Element book = root.elements("��").get(1);
		String name = book.element("����").getText();
		System.out.println(name);
		
	}
	
	/*��ȡָ����ǩ������ֵ*/
	public static void readAttr() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book.xml");
		Element root = document.getRootElement();
		Element book = root.elements("��").get(1);
		Attribute attr = book.element("����").attribute("name");
		String name = attr.getValue();
		//��������д��String name1 = book.element("����").attributeValue("name");
		System.out.println(name);
	}
	
	/*Ϊָ����ǩ����ӱ�ǩ�� <���ۼ�>30</���ۼ�>*/
	public static void add1() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book.xml");
		Element root = document.getRootElement();
		Element book = root.elements("��").get(1);
		book.addElement("���ۼ�").setText("30.00RMB");
		
		//���޸ĺ��documentд���ļ��У������漰�������ʽ�����⡣����XML�ĵ���ʲô���룬document
		//���ڴ��еı��������ʽ����UTF-8��FileWriter������Ĭ�ϱ�����GB2312��ϵͳ�ڴ��У���
		//��ˣ�XMLWriter writer = new XMLWriter(new FileWriter());�õ��Ŀ϶������롣
		
		//----��һ�ֽ����ʽ���������ָ�����뷽ʽ��Writer���ࣺOutputStreamWriter
		//XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"),"UTF-8"));
		
		//----�ڶ��ֽ�����������XML�ĵ�����GB2312�ı�����ʽ����ʱ��ҪΪXMLWriterָ��һ�������ʽ��
		//                   ��GB2312����������GB2312�ı��뷽ʽд�뵽XML�ĵ��С�
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GB2312");	
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"),format);
		//��XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"),"gb2312"),format);
		writer.write(document);
		writer.close();
	}
	
	/*��ָ����ǩ��ָ��λ�ô�����ӱ�ǩ��Ĭ�������������ӣ�����add1�������ǣ�*/
	public static void add2() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book.xml");
		
		Element book = document.getRootElement().element("��");//�õ���һ����
		List<Element> list = book.elements(); //�õ���һ����������ӽڵ�
		
		Element price = DocumentHelper.createElement("���ۼ�");//ͨ��DocumentHelper������ǩ
		price.setText("60.00RMB");
		list.add(2, price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GB2312");	
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"),format);
		writer.write(document);
		writer.close();
	}
	
	/*ɾ��ָ��λ�ñ�ǩ*/
	public static void delete() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book1.xml");
		
		Element book = document.getRootElement().elements("��").get(0);//�õ���һ����
		List<Element> list = book.elements();
		
		list.remove(2);
		
		/*����������ķ�����
		 * Element price = document.getRootElement().element("��").element("�ۼ�");
		 * price.getParent().remove(price);
		 */
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GB2312");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"),format);
		writer.write(document);
		writer.close();
	}
	
	/*���±�ǩ����*/
	public static void update() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/edu/whut/xml/book1.xml");
		
		Element book = document.getRootElement().element("��");
		List<Element> list = book.elements();
		Element price = list.get(2);
		price.setText("65.00RMB");
		
		OutputFormat format = new OutputFormat();
		format.setEncoding("GB2312");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/edu/whut/xml/book1.xml"));
		writer.write(document);
		writer.close();	
	}
}
