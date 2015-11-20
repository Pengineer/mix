package edu.hust.comparator;


//自定义比较器
public class WeightComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Cat w1 = (Cat)o1;
		Cat w2 = (Cat)o2;
		if(w1.getWeight() > w2.getWeight()) return 1;
		else if(w1.getWeight() < w2.getWeight()) return -1;
		return 0;
	}
	
}
