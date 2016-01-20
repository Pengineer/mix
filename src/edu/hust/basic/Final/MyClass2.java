package edu.hust.basic.Final;

/**
 * 辅助类2：final修饰的参数类型是引用数据类型。
 * @author liangjian
 * @since 2016-01-20
 */
public class MyClass2 {
	public void changeValue(final StringBuffer buffer) { 
		buffer.append("world");
	}
}
