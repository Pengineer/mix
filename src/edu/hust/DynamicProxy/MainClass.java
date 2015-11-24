package edu.hust.DynamicProxy;

/**
 * 静态代理的示例中，有一个明显的局限，就是要对每个需要代理的类写一个代理类，如果要记录Car的日志，还得
 * 写一个CarLogProxy类，这样就会产生很多类。动态代理解决了代理类无限扩张的问题，只需要一个Proxy类即可。
 *
 * @author 2015-11-23
 */
public class MainClass {
	public static void main(String[] args) throws Exception {
		dynamicProxyTest();
	}
	
	public static void dynamicProxyTest() throws Exception {
		Movable m = new Tank();
		Movable tlp = (Movable)Proxy.newProxyInstance(Movable.class);
		tlp.move();
	}
}
