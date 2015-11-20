package edu.whut.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *ʹ��JAXP����sax������
 *sax�����¼�����ķ�ʽ����XML�ļ�������sax����XML�ĵ�������������֣����������¼���������
 *1������������ʹ��jaxp��API������������SAX�������󣬼�����ָ��������ȥ����ĳ��XML�ĵ���
 *2������������sax��ʽ�ڽ���ĳ��XML�ĵ�ʱ����ֻҪ������XML�ĵ���һ����ɲ��֣�����ȥ�����¼�������
 *   ��һ���������������ڵ����¼��������ķ���ʱ����ѵ�ǰ��������XML�ĵ�������Ϊ�����Ĳ������ݸ�
 *   �¼���������
 *3���¼��������ɳ���Ա��д������Աͨ���¼��������еķ����Ĳ������Ϳ��Ժ����ɵصõ�sax������������
 *   �����ݣ��Ӷ����Ծ�����ζ����ݽ��д���
 *   
 *   ����ν�¼���������ָһ�ֻ��ڻص���CALLBACK�����Ƶĳ������з�������
 */
public class Demo3_1 {
	
	public static void main(String[] arg) throws Exception{
		//1��������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2���õ�������
		SAXParser sp = factory.newSAXParser();
		
		//3���ɽ������õ���ȡ��,���ö�ȡ��ȥ��XML�ĵ�(dom������ֱ���ý�����ȥ����XML�ĵ�)
		XMLReader reader = sp.getXMLReader();
		
		//4���������ݴ�������HandlerList�൱���¼���������û��ȡ��һ�����ͻ�ִ����Ӧ�ķ�����
		reader.setContentHandler(new HandlerList());
		
		//5����ȡXML�ĵ����ݣ���ʼ����
		reader.parse("src/edu/whut/xml/book.xml");
	}	
}

/**����һ��handler������ȡ�ĵ����������ݣ�ʵ����һ��̳�DefaultHandler����д�������Ҫ�ķ�����������ʵ��ContentHandler�ӿڣ�*/
class HandlerList implements ContentHandler{
	
	//�ĵ���ʼʱ��ִ�и÷���
	@Override
	public void startDocument() throws SAXException {
		
	}
	
	/**������XML�ĵ���һ����ǩʱ��ִ�и÷����������ǩ����ʱ�����Ķ�����
	 * ������uri�����ƿռ� URI�����Ԫ��û�����ƿռ� URI������δִ�����ƿռ䴦����Ϊ���ַ���
	 * 		 localName���������ƣ�����ǰ׺�������δִ�����ƿռ䴦����Ϊ���ַ�����
	 * 	     qName���޶���������ǰ׺��������޶��������ã���Ϊ���ַ�����
	 *       atts�Ǳ�ǩ���������ԣ�
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("<"+qName+">");
		
		for(int i=0 ;atts!=null && i<atts.getLength() ; i++){
			String name = atts.getQName(i);
			String value =atts.getValue(name);
			System.out.println(name+"="+value);
		}
	}
	
    /**
     * ������һ����ǩ�Ե���ʼ��ǩ��Ҳ����ִ����startElement�󣬾ͻ�ִ�и÷��������ڶ�ȡ��ǩ
     * ������ַ������ݣ��е��У��е�û�У�һ�㸸���ǩû�У��޿ո�ģ���
     * ������ch����ȡ����XML�ĵ��е������ַ�(�����ո�)������ͨ��new String������ַ������ָ�������ַ���
     *       start�����ζ�ȡ�����ַ���ch�����е���ʼλ�ã�
     *       length�����ζ�ȡ�����ַ��ĳ��ȣ�
     */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content = new String(ch,start,length);//�����ζ�ȡ�����ַ���װ���ַ�������
		System.out.println(content);
	}

	//������XML�ĵ���ĳһ����ǩ�Ľ�βʱ���ͻ�ִ�и÷���
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
	
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
	
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {

	}

	@Override
	public void setDocumentLocator(Locator locator) {
	
	}

	@Override
	public void skippedEntity(String name) throws SAXException {

	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
	
	}
	@Override
	public void endDocument() throws SAXException {

	}
	
}
