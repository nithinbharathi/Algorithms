//Time Complexity: O(logn) Space Complexity: O(1)


public class TernarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,4,7,10,15,22,25};
		System.out.println(search(arr,25));

	}
	public static int search(int arr[],int key) {
		int low =0;
		int high = arr.length-1;
		int mid1,mid2;
		while(low<=high) {
			mid1 = low+(high-low)/3;
			mid2 = high - (high-low)/3;
			if(arr[mid1] == key) {
				return mid1;
			}else if(arr[mid2] == key) {
				return mid2;
			}else if(key<arr[mid1]) {
				high = mid1-1;
			}else if(key>arr[mid2]) {
				low = mid2+1;
			}else {
				low = mid1+1;
				high = mid2-1;
			}
			
		}
		return -1;
	}
}
