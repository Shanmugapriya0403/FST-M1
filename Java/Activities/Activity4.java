package javapractice;

import java.util.Arrays;

public class Activity4 {
	static void ascendingSort(int[] arr) {
		int temp;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("Array after sort:" + Arrays.toString(arr));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numarr= {4,2,1,8,9,3};
		System.out.println("Array before sort:" +Arrays.toString(numarr));
		ascendingSort(numarr);
	
	}

}
