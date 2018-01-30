package BubbleSort;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[10];
		int pot=0;
		int temp;
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr.length;i++){		
			pot++;
			for(int j=0;j<arr.length-pot;j++){
		
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		
		}
		for(int i=0;i<arr.length;i++){
			System.out.println("after"+arr[i]);
		}
	}

}
