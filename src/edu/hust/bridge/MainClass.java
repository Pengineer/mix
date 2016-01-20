package edu.hust.bridge;

/**
 * 桥接模式（bridge）：子类有多维度的扩展，多维度之间可以自由组合 ---> 用得少
 * 
 * 桥接模式记住一句话：抽象角色引用实现角色，或者说抽象角色的部分实现是由实现角色完成的。
 * 
 * WarmGift和WildGift继承至Gift；Flower继承至GiftImpl；GiftImpl是Gift的属性。
 * 
 * @author 2015-11-24
 *
 */
public class MainClass {
	public static void main(String[] args) {
		Gift g1 = new WarmGift(new Flower());
		Gift g2 = new WildGift(new Flower());
		
		g1.setName("茉莉花");
		g2.setName("玫瑰花");
	}
}
