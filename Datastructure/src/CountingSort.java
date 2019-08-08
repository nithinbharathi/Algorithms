
public class CountSort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{2,1,5,4,6,2,5,4,4,4};
		counting_sort(arr);
		
	}
	public static void counting_sort(int arr[]){
		int MAX = Integer.MIN_VALUE;
		for(int n:arr)MAX = Math.max(MAX, n);
		int count[] = new int[MAX+1];
		for(int n:arr){
			count[n]++;
		}
		int index =0;
		int sort_array[]  = new int[arr.length];
		for(int i =0;i<=MAX;i++){
			int temp = count[i];
			while(temp>0){
				sort_array[index++] = i;
				temp--;
			}
		}
		for(int i =0;i<arr.length;i++){
			System.out.print(sort_array[i]+" ");
		}
		
	}
}	
