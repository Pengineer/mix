package edu.whut.xml;

/**
 * XML Schema : �����滻DTD��XML�ĵ�Լ������
 * 
 * �����DTD���ص㣺
 * 1��XML Schema����XML�﷨�ṹ����һ��XMLȥԼ����һ��XML����
 * 2��DOM��SAX��XML API�����׽�����XML Schema�ĵ��е����ݣ�
 * 3��XML Schema�����ʿռ�֧�ֵķǳ��ã�
 * 4��XML Schema��XML DTD֧�ָ�����������ͣ���֧���û��Զ����µ����ͣ�
 * 5��XML Schema����Լ���������ǳ�ǿ�󣬿��Զ�XMLʵ���ĵ�����ϸ�µ�������ƣ�
 * 6����ȱ�㣩XML Schema������XML DTDһ������ʵ�壬����DTD�����ӣ���XML Schema�Ѿ���w3c��֯�ı�׼������ȡ��DTD��
 *
 * ����XML SchemaԼ����
 * 1��XML Schema�ļ��������һ��XML�ļ�����������չ��ͨ��Ϊ.xsd��
 * 2��һ��XML Schema�ĵ�ͨ����֮Ϊģʽ�ĵ���Լ���ĵ�������ѭ����ĵ���д��XML�ļ���֮Ϊʵ���ĵ���
 * 3����XML�ļ�һ����һ��XML Schema�ĵ�Ҳ������һ�����ڵ㣬��������ڵ������Ϊschema��
 * 4����д��XML SchemaԼ���ĵ�֮��ͨ����Ҫ������ļ���������Ԫ�ذ󶨵�һ��URL��ַ�ϣ���XML Schema
 *    ��������һ��רҵ����������������̣�����XML Schema�ĵ�������Ԫ�ذ󶨵�һ�����ƿռ��ϣ��Ժ�XML
 *    �ļ��Ϳ���ͨ�����URL�������ƿռ䣩�����߽������棬XML�ĵ��б�д��Ԫ�����������˭Լ����
 *    
 * xmlns��������һ�����ƿռ䡣xmlns:itcast="http://www.itcast.com" ������һ������Ϊitcast�����ƿռ�
 * 
 * ���磺
 * <?xml version="1.0" encoding="UTF-8"?>
 * <itcast:���  xmlns:itcast="http://www.itcast.com"         ��xmlns����һ�����ƿռ䣬�����ƿռ��Լ���ĵ������targetnamespace���Զ�������ƿռ䣨���ڽ�Լ���ĵ��еı�ǩ�󶨵���URI�ϣ�һ����ָ����ܱ�ǩ�����Ը����ƿռ�
 *             xmlns:xsi="http://www.w3.org/2001/XMLSchema-Instance"   ��xmlns������һ�������ƿռ䣬���󶨵�ǰ׺xsi�ϣ������ƿռ��Ӧ��Լ���ĵ�����ָ��
 *               xsi:schemaLocation="http://www.itcast.com  edu/whut/xml/book.xsd">  �������ƿռ䱾�����һ���Ƚ���ĸ����˵�һ�в�����ָ��Լ���ĵ��ľ���λ�ã�����Ҫ��schemaLocation������ָ�����ƿռ��Ӧ��Լ���ĵ��ľ���λ�ã���һ�����������ƿռ䣬�ڶ���������Լ���ĵ���·����schemaLocation��������xsiָ�������ƿռ䣬�������ƿռ䡣Ҳ�������������ƿռ������schemaLocation��ָ��Լ���ĵ���λ�á�
 *     <itcast:��>
 *         <itcast:����>...</itcast:����>
 *         <itcast:����>...</itcast:����>
 *         <itcast:�ۼ�>...</itcast:�ۼ�>
 *     </itcast:��>
 * </itcast:���>
 * 
 * ���ƿռ䣺
 *    ��XML schema�У�ÿ��Լ���ĵ�����������һ��Ψһ�����ƿռ䣬���ƿռ���һ��URI��uniform resource identifier ͳһ��Դ��ʶ��������ʾ��
 * ��XMLʵ���ļ�����д��ǩʱ������ͨ�����ƿռ�������xmlns������ָ���ñ�ǩ�������
 * ע�⣺���ƿռ�������������˲��������������http://��ͷ������������URL������ָ��һ������ģʽ������ļ�����ʵ�ϣ����URI����û��ָ���κ�
 * �ļ���ֻ��һ����������֡�   
 */

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
