package edu.hust.test;

import java.util.Arrays;

/**
 * 数组工具类/方法：
 * （1）Arrays;
 * 
 * （2）System.arraycopy();
 */

public class ArraysTest {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(Arrays.binarySearch(a, 6));
		
		System.out.println(Arrays.binarySearch(a, 0, 5, 5));
		
		int[] b1 = Arrays.copyOf(a, 10);        //copy整个数组，不足补0：底层调用System.arraycopy
		System.out.println(b1.length);
		int[] b2 = Arrays.copyOfRange(a, 1, 3); //copy数组的一部分：底层调用System.arraycopy
		System.out.println(b2.length);
		
		int[] s = {5,7,4,9,32,8,3};
		Arrays.sort(a);  //底层快排
	}
}
