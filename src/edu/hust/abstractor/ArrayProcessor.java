package edu.hust.abstractor;

/**
 * 数组划分问题
 * 
 * 不同的划分方式：按奇偶、按正负等。但是划分的方法是一致的，定义两个指针，分别指向头尾，然后循环判断交换。
 * 
 * @author 2015-12-06
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
