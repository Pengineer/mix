package edu.hust.bridge;

public class Gift {
	protected GiftImpl impl;
	public String name;
	public Float price;

	public GiftImpl getImpl() {
		return impl;
	}
	public void setImpl(GiftImpl impl) {
		this.impl = impl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}
