
import java.util.*;
import java.lang.*;
import java.io.*;

class Exponenciation
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int p = input.nextInt();
		int res1 = rec_exp(n,p);
		int res2 = iter_exp(n,p);
		System.out.println(res1);
		System.out.println(res2);
	}
	public static int iter_exp(int n,int p){    //Time Complexity O(P), Space Complexity = O(1)
	    int res =1;
	    for(int i=0;i<p;i++){
	        res*=n;
	    }
	    return res;
	}
	public static int rec_exp(int n,int p){     //Time complexity (P), Space Complexity = O(P)
	    if(p == 0)return 1;
	    return n*rec_exp(n,p-1);
	}
}
