public class SquareRootDecomposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		table obj = new table();
		obj.construct(new int[]{1, 5, 2, 4, 6, 1, 3, 5, 7, 10});
		//obj.display();
		
		System.out.println(obj.sum_query(4,7));
	}

}

class table{
	int sum_table[];
	int temp[];
	int index = -1;
	int size =0;
	public void construct(int arr[]){
		size = (int)Math.ceil(Math.sqrt(10));
		temp = new int[arr.length];
		sum_table = new int[size];
		sum(arr);
	}
	public void sum(int arr[]){
		for(int i =0;i<arr.length;i++){
			temp[i] = arr[i];
			if(i%size == 0){
				index++;
			}
			sum_table[index]+=arr[i];
			
		}
	}
	public void display(){
		for(int i =0;i<size;i++){
			System.out.println(sum_table[i]);
		}
	}
	
	 public void update(int index,int val){
		 int pos = index/size;
		 int temp_val = temp[index];
		 temp[index] = val;
		 temp[pos] = val;
		 sum_table[pos] = sum_table[pos] - temp_val+val;
	 }
	 public int sum_query(int l,int r){
		 int range_sum = 0;
		 if(l>r){
			 System.out.println("enter  a valid range");
			 return -1;
		 }
		 for(int i =l;i<=r;){
			 if(i%size ==0 && i+size-1<=r){
				 range_sum+=sum_table[i/size];
				 i+=size;
			 }else{
				 range_sum+=temp[i];
				 i++;
			 }
		 }
		 return range_sum;
	 }
}
