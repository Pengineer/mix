package edu.hust.staticProxy;

public class TankLogProxy implements Movable {
	Movable m;

	public TankLogProxy(Movable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("start log...");
		m.move();
		System.out.println("stop log...");
	}
	
	
}
