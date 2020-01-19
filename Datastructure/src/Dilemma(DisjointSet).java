
//Problem Link
//https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/teachers-dilemma-3/



import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static int arr[];
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int v = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		arr = new int[v+1];
		Arrays.fill(arr,-1);
		for(int i=0;i<e;i++){
		    s = br.readLine().split(" ");
		    int a = Integer.parseInt(s[0]);
		    int b = Integer.parseInt(s[1]);
		    union(a,b);
		}
 // System.out.println(Arrays.toString(arr));
		long res =1;
		int mod = 1000000007;
		for(int i=1;i<=v;i++){
		    if(arr[i]<0){
		        int a = Math.abs(arr[i]);
		        res = (res*a)%mod;
		    }
		}
		System.out.println(res);
	}
	public static void union(int a,int b){
	    int res1 = find(a);
	    int res2 = find(b);
	    if(res1 == res2)return;
	    arr[res1] +=arr[res2];
	    arr[res2] = res1;
	}
	public static int find(int a){
	    while(arr[a]>0){
	        a = arr[a];
	    }
	    return a;
	}
}
