package edu.hust.staticProxy;

/**
 * 静态/动态代理必须实现同一个接口（现在很多技术如CGLIB不需要），这样代理对象可以通过接口构造，而不需要具体的实现类，同时有利于嵌套代理。
 * Spring框架中有两种动态代理，一种是被代理的类必须实现同一接口，另一种不需要，但是官方推荐使用第一种，即实现接口。
 * 
 * 多态是所有设计模式的核心
 * 
 * @author 2015-11-23
 *
 */
public class MainClass {
	public static void main(String[] args) {
		staticProxyTest();
	}
	
	public static void staticProxyTest() {
		Movable m = new Tank();
		TankTimeProxy ttp = new TankTimeProxy(m); //执行之前先记录时间
		TankLogProxy tlp = new TankLogProxy(ttp); //执行之前先记录日志，使用接口+多态实现嵌套代理
		tlp.move();
	}
}
