package edu.hust.comparable;

public class ObjectSort {
	
	public static void main(String[] args) {
		Cat[] c = {new Cat(1, "a"), new Cat(7, "b"), new Cat(5, "c")};
		sort(c);
		
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
	}
	
	//实现了Comparable的类都可以用此排序（多态）
	public static void sort(Object[] o) {
		for (int i=0; i<o.length; i++) {
			for(int j=0; j<o.length-i -1; j++) {
				Comparable c1 = (Comparable)o[j];
				Comparable c2= (Comparable)o[j+1];
				if(c1.compareTo(c2) == 1) {
					swap(o, j, j+1);
				}
			}
		}
	}
	
	public static void swap(Object[] o, int i, int j) {
		Object tmp = o[i];
		o[i] = o[j];
		o[j] = tmp;
	}
	
	
}
