package ArrayDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = new int[3];
		
/*		int arr[];
		arr =new int[3];*/
		
//		int arr[]={1,2,3};
		
//		int arr[]=new int[]{1,2,3};
		
//		System.out.println(arr[0]);
		
	
/*		int arr[]=new int[10];
		int temp=0;
		for(int i=0;i<arr.length ;i++){
			arr[i]=(int)(Math.random()*100);
		}
		for(int i=0;i<arr.length ;i++){
			
			if(temp<arr[i]){
				temp=arr[i];
			}
			
		}
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=temp;
		System.out.println("最大值为"+temp);
		for(int i=0;i<arr.length ;i++){
			
			System.out.println(arr[i]);
		
		}*/
		
		/*int[] arr1={1,2,23,45,8,6,5};
		int[] arr2=new int[5];

		System.arraycopy(arr1, 1, arr2, 1,3 );
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}*/
		
		int arr[]={12,54,8,69,4,14,21,122,46};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
