
import java.util.*;
import java.lang.*;
import java.io.*;

class SegmentTree2D
{
    static int segment_tree[][];
    static int segment_tree2d[][];
    static int arr[][];
	public static void main (String[] args) throws java.lang.Exception
	{
	    //2InputReader input = new InputReader(System.in);
	    //OutputWriter out = new OutputWriter(System.out);
	   Scanner input = new Scanner(System.in);
	   int n = input.nextInt();
	   int m = input.nextInt();
       arr = new int[n][m];
       segment_tree = new int[n][2*m];
       segment_tree2d = new int[2*n][2*m];
       for(int i=0;i<n;i++){
           for(int j =0;j<m;j++){
               arr[i][j] = input.nextInt();
           }
       }
       for(int i=0;i<n;i++){
           constructSegmentTree(0,m-1,0,i);
       }
       construct2d(0,n-1,0);
       for(int i=0;i<2*n;i++){
           for(int j =0;j<2*m;j++){
               System.out.print(segment_tree2d[i][j]+" ");
           }
           System.out.println();
       }
       System.out.println(query(1,1,2,2,0,n-1,0,m));
	}
	public static void constructSegmentTree(int l,int r,int pos,int row){
	    if( l == r){
	        segment_tree[row][pos] = arr[row][l];
	        return;
	    }
	    int mid = (l+r)/2;
	    constructSegmentTree(l,mid,2*pos+1,row);
	    constructSegmentTree(mid+1,r,2*pos+2,row);
	    segment_tree[row][pos] = segment_tree[row][2*pos+1]+segment_tree[row][2*pos+2];
	}
	public static void construct2d(int l,int r,int pos){
	    if(l == r){
	        for(int i=0;i<segment_tree[l].length;i++){
	            segment_tree2d[pos][i] = segment_tree[l][i];
	        }
	        return;
	    }
	    int mid = (l+r)/2;
	    construct2d(l,mid,2*pos+1);
	    construct2d(mid+1,r,2*pos+2);
	    for(int i=0;i<segment_tree[0].length;i++){
	        segment_tree2d[pos][i] = segment_tree2d[2*pos+1][i]+segment_tree2d[2*pos+2][i];
	    }
	}
	public static int query(int x1,int y1,int x2,int y2,int l,int r,int pos,int m){
	    if(y2<l||y1>r)return 0;
	    if(l>=y1 && r<=y2){
	        return dquery(x1,x2,0,m-1,0,pos);
	    }
	    int mid = (l+r)/2;
	    int left = query(x1,y1,x2,y2,l,mid,2*pos+1,m);
	    int right = query(x1,y1,x2,y2,mid+1,r,2*pos+2,m);
	    return left+right;
	}
	public static int dquery(int x1,int x2,int l,int r,int pos,int node){
	   if(x2<l || x1>r)return 0;
	   if(l>=x1 && r<=x2)return segment_tree2d[node][pos];
	   int mid = (l+r)/2;
	   int left = dquery(x1,x2,l,mid,2*pos+1,node);
	   int right = dquery(x1,x2,mid+1,r,2*pos+2,node);
	   return left+right;
	}
}
