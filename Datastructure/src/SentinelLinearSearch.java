//Time Complexity: O(n+2)  && Space Complexity: O(1)


public class LinearSetinelSearch {
	public static void main(String[] args) {
		int arr[] = {3,4,1,7,9};
		System.out.println(search(arr,10));
	}
  
	public static int search(int arr[],int key) {
		int last = arr[arr.length-1];
		arr[arr.length-1] = key;
		int i =0;
		while(arr[i] != key) {
			i++;
		}
		arr[arr.length-1] = last;
		if(i<arr.length-1 || arr[arr.length-1] == key) {
			return i;
		}
		return -1;
	}

}
