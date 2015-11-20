package edu.whut.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * JAXP:
 *    1��JAXP��������J2SE��һ���֣���˿���ʱ���ö��⵼��������javax.xml��org.w3c.dom��org.xml.sax�������Ӱ���ɣ�
 *    2����javax.xml.parsers���У������˼��������࣬����Ա������Щ�����࣬���Եõ�xml�ĵ���
 *       DOM����SAX���������Ӷ�ʵ�ֶ�xml�ĵ��Ľ�����
 */

/**
 * ʹ��JAXP����DOM������ 
 * 	  javax.xml.parsers���е�DocumentBuilderFactory���ڴ���DOMģʽ�Ľ��������� DocumentBuilderFactory
 *    ��һ�����󹤳��࣬������ֱ��ʵ�������������ṩ��һ��newInstance�����������������ݱ���ƽ̨
 *    Ĭ�ϰ�װ�Ľ��������Զ�����һ�������Ķ��󲢷��أ�Ȼ��ͨ���ù�����newDocumentBuilder��������
 *    һ��DOM������DocumentBuilder��
 *    
 *    dom�����£�xml�ĵ���ÿһ����ɲ��ֶ�����һ�������ʾ�������ǩ��Element��������Attr������
 *    ��ʲô���󣬶���Node�����࣬�����ڿ����У����԰ѻ�ȡ������ڵ㶼����Node�Դ���
 */

public class Demo2 {

	public static void main(String[] args) throws Exception {
		//1������DOM���������� 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2���õ�DOM������
		DocumentBuilder builder = factory.newDocumentBuilder();

		//3������xml�ĵ����õ������ĵ���Document����
		Document document = builder.parse("src/edu/whut/xml/book.xml");
		
		
		//---------------���ĵ��ľ������------------------------------		
	//	read1(document);
	//	System.out.println("-----------------------------");
	//	read2(document);
	//	System.out.println("-----------------------------");
	//	read3(document);
	//	System.out.println("-----------------------------");
	//	add1(document);
	//	System.out.println("-----------------------------");
	//	add2(document);
	//	System.out.println("-----------------------------");
	//	addAttr(document);
	//	System.out.println("-----------------------------");
	//	delete1(document);
	//	System.out.println("-----------------------------");
	//	delete2(document);
	//	System.out.println("-----------------------------");
		updata(document);
		System.out.println("-----------------------------");
	}

	/*��ȡָ����ǩ����*/
	private static void read1(Document document) {
		NodeList list = document.getElementsByTagName("����");
		Node node = list.item(1);
		System.out.println(node.getTextContent());
	}
	
	/*��ӡ���б�ǩ��ͨ�����ڵ����*/
	private static void read2(Document document) {
		Node root = document.getElementsByTagName("���").item(0);
		list(root);
	}
	private static void list(Node node) {
		if(node instanceof Element){
			System.out.println(node.getNodeName());
		}
		NodeList childs = node.getChildNodes();
		for(int i=0 ; i<childs.getLength() ; i++){
			Node child = childs.item(i);
			list(child);			
		}		
	}
	
	/*��ȡ��ǩ������ֵ*/
	private static void read3(Document document) {
		//Ϊ��ʹ�ø���ķ�������Node�ڵ�ǿת���������
		Element element = (Element)document.getElementsByTagName("����").item(0);
		String value = element.getAttribute("name");
		System.out.println(value); 
	}
	
	/*��xml�ĵ�����ӽڵ�*/
	private static void add1(Document document) throws Exception {
		Element price = document.createElement("���ۼ�");
		price.setTextContent("69.00RMB");
		
		Element book = (Element)document.getElementsByTagName("��").item(0);
		book.appendChild(price);//���˲���ֻ�����ڴ��е�book.xml�ļ�����˽ڵ�
		
		//�������ͨ���ڴ��е�book.xml������Ӳ���ϵ�book.xml�ļ�,�������ģʽ��API�ĵ���
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));
		
		System.out.println("add success");
	}
	
	/*��xml�ĵ���ָ��λ�ô���ӽڵ�*/
	private static void add2(Document document) throws Exception {
		Element price = document.createElement("���ۼ�");
		price.setTextContent("69.00RMB");
		
		//��ȡ�ο��ڵ�λ��
		Element referencenode = (Element)document.getElementsByTagName("�ۼ�").item(0);
		
		Element book = (Element)document.getElementsByTagName("��").item(0);
		book.insertBefore(price, referencenode);
		
		//�������ͨ���ڴ��е�book.xml������Ӳ���ϵ�book.xml�ļ�
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));

		System.out.println("add success");
	}

	/*δָ����ǩ�������*/
	private static void addAttr(Document document) throws Exception {
		Element bookname = (Element)document.getElementsByTagName("����").item(1);
		bookname.setAttribute("name", "cba");
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));
	}
	
	/*ɾ���ڵ�*/
	private static void delete1(Document document) throws Exception{
		//�õ�Ҫɾ���Ľڵ�
		Element oldprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		//�õ�Ҫɾ���ڵ�ĸ��ڵ�
		Element oldpricefather = (Element)document.getElementsByTagName("��").item(0);
		
		oldpricefather.removeChild(oldprice);
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));
		System.out.println("delete success");
	}
	/*ɾ���ڵ�ĵڶ��ַ���,�÷��������ã����磬������ɾ���ۼ���XX��������*/
	private static void delete2(Document document) throws Exception{
		//�õ�Ҫɾ���Ľڵ�
		Element oldprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		oldprice.getParentNode().removeChild(oldprice);
	
		//���磺oldprice.getParentNode().getParentNode().removeChild(oldprice.getParentNode());
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));
		System.out.println("delete success");
	}
	
	/*���½ڵ�����*/
	private static void updata(Document document) throws Exception {
		Element oldprice = (Element)document.getElementsByTagName("�ۼ�").item(0);
		oldprice.setTextContent("69.00RMB");
		
		TransformerFactory transfactory = TransformerFactory.newInstance();
		Transformer trans = transfactory.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult(new FileOutputStream(
				"src/edu/whut/xml/book.xml")));
		System.out.println("update success");
	}
}
