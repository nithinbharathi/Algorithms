//Time Complexity: O(NM) where N is the total number of strings and M is the length of the smallest string
//Space Complexity:O(1)

import java.util.*;
import java.lang.*;
import java.io.*;

class LCP
{
   public static int mod = (int)1e9+7;
   static int n =0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		String arr[] = {"abcfde","abcf","abcftr","abcfq","abcfe"};
		String prefix = solve(arr);
		System.out.println(prefix);
	}
	public static String solve(String arr[]){
	    int min = Integer.MAX_VALUE;
	    String res= "";
	    for(int i=0;i<arr.length;i++){
	        if(min>arr[i].length()){
	            min = arr[i].length();
	        }
	    }
	    int l =0;
	    int r = min-1;
	    while(l<=r){
	        int mid = (l+r)/2;
	        if(compare(arr,l,mid)){
	            res = arr[0].substring(0,mid+1);
	            l = mid+1;
	        }else{
	            r = mid-1;
	        }
	    }
	    return res;
	}
	public static boolean compare(String arr[],int l,int h){
	    for(int i=0;i<arr.length;i++){
	        String t = arr[i];
	        
	        for(int j =l;j<=h;j++){
	            if(t.charAt(j) != arr[0].charAt(j)){
	                return false;
	            }
	        }
	    }
	    return true;
	}
}
