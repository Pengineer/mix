package edu.hust.template;

/**
 * 模板设计模式
 * 1. 概述
 *    定义一个操作中的算法的骨架，而将步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义算法的某些特定步骤。
 * 2. 模式中的角色
 *   2.1 抽象类（AbstractClass）：实现了模板方法，定义了算法的骨架。
 *   2.2 具体类（ConcreteClass）：实现抽象类中的抽象方法，已完成完整的算法。
 * 3. 模式总结
 *   3.1 优点
 *     3.1.1 模板方法模式通过把不变的行为搬移到超类，去除了子类中的重复代码。
 *     3.1.2 子类实现算法的某些细节，有助于算法的扩展。
 *     3.1.3 通过一个父类调用子类实现的操作，通过子类扩展增加新的行为，符合“开放-封闭原则”。
 *   3.2 缺点
 *     3.2.1 每个不同的实现都需要定义一个子类，这会导致类的个数的增加，设计更加抽象。
 *   3.3 适用场景
 *     3.3.1 在某些类的算法中，用了相同的方法，造成代码的重复。
 *     3.3.2 控制子类扩展，子类必须遵守算法规则。
 * 
 * 数组划分问题
 * 
 * 不同的划分方式：按奇偶、按正负等。但是划分的方法是一致的，定义两个指针，分别指向头尾，然后循环判断交换。
 * 
 * smdb中使用：爬虫，具体的爬虫任务由子类本身实现；BaseAction，整个web使用同一套列表，具体数据的获取和操作由子类实现。
 * 
 * @author 2015-12-06~07
 *
 */

public abstract class ArrayProcessor {

	public abstract boolean process(int n);
	
	public void doElements(int[] arr, int len) {
		if(arr == null || len <=0) {
			throw new RuntimeException("Invalid parameter");
		}
		
		int start =0, end = len-1;
		while(start < end) {
			while(start < len && !process(arr[start])) {
				start++;
			}
			while(start < len && process(arr[end])) {
				end--;
			}
			if(start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
	}
}
