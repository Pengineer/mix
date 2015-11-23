package edu.hust.staticProxy;

public class TankTimeProxy implements Movable {
	Movable m;

	public TankTimeProxy(Movable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("starttime...");
		m.move();
		System.out.println("stoptime...");
	}
	
	
}
