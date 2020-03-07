
import java.util.*;
import java.lang.*;
import java.io.*;

class SegmentTreeLazyPropagation
{
    static int segment_tree[];
    static int arr[];
    static int lazy_tree[];
	public static void main (String[] args) throws java.lang.Exception
	{
	    arr = new int[]{2,3,-1,4};
	    segment_tree = new int[4*arr.length];
	    lazy_tree = new int[4*arr.length];
	    construct_segTree(0,arr.length-1,0);
        System.out.println(query(0,3,0,arr.length-1,0));

        lazyUpdate(0,3,0,arr.length-1,0,2);
 
        lazyUpdate(2,2,0,arr.length-1,0,4);
  
        System.out.println(lazyQuery(1,2,0,arr.length-1,0));

	}
	public static void construct_segTree(int l,int r,int pos){
	    if( l == r){
	        segment_tree[pos] = arr[l];
	        return;
	    }
	    int mid = (l+r)/2;
	    construct_segTree(l,mid,2*pos+1);
	    construct_segTree(mid+1,r,2*pos+2);
	    segment_tree[pos] = Math.min(segment_tree[2*pos+1],segment_tree[2*pos+2]);
	}
	public static int query(int ql,int qr,int l,int r,int pos){
	    if(ql<=l && qr>=r)return segment_tree[pos];
	    if(qr<l || ql>r)return Integer.MAX_VALUE;
	    int mid = (l+r)/2;
	    int left_min = query(ql,qr,l,mid,2*pos+1);
	    int right_min= query(ql,qr,mid+1,r,2*pos+2);
	    return Math.min(left_min,right_min);
	}
	public static void lazyUpdate(int ql,int qr,int l,int r,int pos,int val){
	    if(l>r)return;
	    if(lazy_tree[pos] != 0){
	        int v = lazy_tree[pos];
	        segment_tree[pos]+=v;
	        if(l != r){
	            lazy_tree[2*pos+1]+=v;
	            lazy_tree[2*pos+2]+=v;
	        }
	        lazy_tree[pos] = 0;
	    }
	    if(qr<l || ql>r)return;
	    
	    if(l>=ql && r<=qr){
	        segment_tree[pos]+=val;
	        if(l != r){
	            lazy_tree[2*pos+1]+=val;
	            lazy_tree[2*pos+2]+=val;
	        }
	        return;
	    }
	    int mid = (l+r)/2;
	   lazyUpdate(ql,qr,l,mid,2*pos+1,val);
	   lazyUpdate(ql,qr,mid+1,r,2*pos+2,val);
	   segment_tree[pos] = Math.min(segment_tree[2*pos+1],segment_tree[2*pos+2]);
	}
	public static int lazyQuery(int ql,int qr,int l,int r,int pos){
	    if(l>r)return Integer.MAX_VALUE;
	    if(lazy_tree[pos] != 0){
	        int v = lazy_tree[pos];

	        segment_tree[pos]+=v;
	        if(l != r){
	            lazy_tree[2*pos+1]+=v;
	            lazy_tree[2*pos+2]+=v;
	        }
	        lazy_tree[pos] = 0;
	    }
	    if(l>qr || r<ql )return Integer.MAX_VALUE;
	    if(l>=ql && r<=qr){
	        return segment_tree[pos];
	    }
	    int mid = (l+r)/2;
	   int left_min  = lazyQuery(ql,ql,l,mid,2*pos+1);
	   int right_min = lazyQuery(ql,qr,mid+1,r,2*pos+2);
	   return Math.min(left_min,right_min);
	}
}
