package edu.hust.DynamicProxy.update;

import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	Object target; //代理对象
	
	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("start...");
		
		try {
			m.invoke(target); //执行原始target的方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end...");
	}

}
