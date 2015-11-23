package edu.hust.staticProxy;

public class Tank implements Movable{

	@Override
	public void move() {
		for(int i=0; i<10000; i++);
		System.out.println("move");
	}

}
