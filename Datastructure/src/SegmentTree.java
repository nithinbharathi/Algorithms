//Contruction of Segment tree
//Time Complexity = O(n)
//Space Complexity:O(n)

public class SegmentTree{
	public static void main(String[] args) {
		int input[] = new int[]{-1,2,4,0};
		int size = 2*(input.length)-1;
		int seg[] = new int[size];
		constructSegmentTree(input,seg,0,input.length-1,0);
	  for(int n:seg){
		  System.out.println(n);
	  }
	}
  
	public static void constructSegmentTree(int input[],int seg[],int low,int high,int pos){
		if(low == high){
			seg[pos] = input[low];
			return;
		}
		int mid = (low+high)/2;
		constructSegmentTree(input,seg,low,mid,2*pos+1);
		constructSegmentTree(input,seg,mid+1,high,2*pos+2);
		seg[pos] = Math.min(seg[2*pos+1], seg[2*pos+2]);
	}
}
