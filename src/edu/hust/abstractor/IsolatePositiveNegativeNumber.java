package edu.hust.abstractor;

public class IsolatePositiveNegativeNumber extends ArrayProcessor {
	public static void main(String[] args) {
		int[] arr = {1,-2,3,4,-5,6,7,-8,9};
		
		IsolatePositiveNegativeNumber isolate = new IsolatePositiveNegativeNumber();
		isolate.doElementsOddEven(arr, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void doElementsOddEven(int[] arr, int len) {
		doElements(arr, len);
	}
	
	@Override
	public boolean process(int n) {
		return n > 0;
	}
}
