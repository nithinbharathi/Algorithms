//Subset generation Iterative

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = {1,2,3};
		long size = power(2,n);
	
		for(int i=0;i<size;i++){
		    System.out.print("[");
		    int c =0;
		    for(int j =0;j<n;j++){
		        if((i&(1<<j)) != 0){
		            if(c>0)System.out.print(",");
		            System.out.print(arr[j]);
		            c++;
		        }
		    }
		    System.out.println("]");
		}
        
	}
	public static long power(int base,int power){
	    long res = 1;
	    while(power>0){
	        if((power&1) == 1)res*=base;
	        power>>=1;
	        base*=base;
	    }
	    return res;
	}
}
