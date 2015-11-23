package edu.hust.DynamicProxy.update;

/**
 *	在edu.hust.DynamicProxy中由于代理的方式还是比较固定，它只能做日志代理
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
