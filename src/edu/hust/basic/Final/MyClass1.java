package edu.hust.basic.Final;

/**
 * 辅助类1：final修饰的参数类型是基本数据类型。
 * @author liangjian
 * @since 2016-01-20
 */
public class MyClass1 {

	public void changeValue(final int i) {
		// error: The final local variable i cannot be assigned. It must be blank and not using a compound assignment
//		i++;
	}
}
