package edu.hust.DynamicProxy.update;

import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	Object target; //被代理对象（Tank）
	
	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) { //通过Proxy中拼接的临时代理的源码可以看出，此处的Object对象是指代理对象$Proxy1
		System.out.println("start...");
		System.out.println(o.getClass().getName());
		try {
			m.invoke(target); //执行被代理对象target的方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end...");
	}

}
