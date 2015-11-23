package edu.hust.DynamicProxy.update;

import java.lang.reflect.Method;

/**
 * 方法调用的执行接口：执行器
 * 
 * invocation：调用
 * handler：执行
 */
public interface InvocationHandler {
	
	public void invoke(Object o, Method m);
}
