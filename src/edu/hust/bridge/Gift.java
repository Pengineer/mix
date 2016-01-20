package edu.hust.bridge;

/**
 * 桥接类：业务抽象类
 * @author liangjian
 *
 */
public class Gift {
	protected GiftImpl impl; // 核心
	
	public String name;
	public Float price;

	public GiftImpl getImpl() {
		return impl;
	}
	public void setImpl(GiftImpl impl) {
		this.impl = impl;
	}
	
	//业务自己的行为属性
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
