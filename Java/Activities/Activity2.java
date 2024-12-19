package javapractice;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrVal= {10, 77, 10, 54, -11, 10};
		System.out.println("Original Array value:" + Arrays.toString(arrVal));
		
		int fixedSum = 30;
		int searchNum =10;
		
		System.out.println("Result:" + result(arrVal, fixedSum, searchNum));
		

	}

	public static boolean result(int[] numbers,int fixedSum,int searchNum) {
		int tempSum=0;
		for(int number:numbers) {
			if(number==searchNum) {
				tempSum+=number;
			}
			if(tempSum>fixedSum) {
				break;
			}
		}
		return tempSum==fixedSum;
		
	}
}
