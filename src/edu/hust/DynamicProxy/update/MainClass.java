package edu.hust.DynamicProxy.update;

/**
 *	在edu.hust.DynamicProxy中由于代理的方式还是比较固定，它只能做日志代理
 *
 * 本例中，代理类$Proxy不在直接执行被代理对象的方法，而是实现代理对象接口中的所有方法后，在方法体中通过接口调用一个执行器来执行，
 * 具体的执行器才是最终的方法执行者。
 *
 *@author 2015-11-23
 */
public class MainClass {
	public static void main(String[] args) throws Exception {
		dynamicProxyTest();
	}
	
	public static void dynamicProxyTest() throws Exception {
		Movable m = new Tank();
		Movable tlp = (Movable)Proxy.newProxyInstance(Movable.class, new LogHandler(m)); //这里默认是对接口中的所有方法进行代理
		tlp.move();
	}
}
