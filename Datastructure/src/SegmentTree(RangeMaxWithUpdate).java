/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class RangeMaximumSegmentTree
{
    static int segment_tree[];
    static int arr[];
	public static void main (String[] args) throws java.lang.Exception
	{
		arr = new int[]{1,2,5};
		segment_tree = new int[2*arr.length];
		construct_tree(0,arr.length-1,0);
		System.out.println(sum_query(0,0,arr.length-1,0,2));
		int index = 2,value = 2;
		update_query(index,value);
		System.out.println(segment_tree[0]);
		
	}
	public static void construct_tree(int start,int end,int index){
	    if(start == end){
	        segment_tree[index] = arr[start];
	        return;
	    }
	    int mid = (start+end)/2;
	    construct_tree(start,mid,2*index+1);
	    construct_tree(mid+1,end,2*index+2);
	    segment_tree[index] = segment_tree[2*index+1]+segment_tree[2*index+2];
	}
	public static int sum_query(int root,int sl,int sr,int l,int r){

	    if(l<=sl && r>=sr){
	        return segment_tree[root];
	    }
	    if(sr<l || sl>r){
	        return 0;
	    }
	    int mid  = (sl+sr)/2;
	    return sum_query(2*root+1,sl,mid,l,r)+ sum_query(2*root+2,mid+1,sr,l,r);
	}
	public static void update_query(int index,int val){
	    int diff = val - arr[index];
	    arr[index] = val;
	    update(0,diff,0,arr.length-1,2);
	}
	public static void update(int pos,int val,int sl,int sr,int index){
	    if(sr<index || sl>index){
	        return;
	    }
	    segment_tree[pos]+=val;
	    if(sl != sr){
	        int mid = (sl+sr)/2;
	        update(2*pos+1,val,sl,mid,index);
	        update(2*pos+2,val,mid+1,sr,index);
	    }
	}
}
