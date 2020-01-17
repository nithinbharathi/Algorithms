
import java.util.*;
import java.lang.*;
import java.io.*;

class FastExponenciation
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int p = input.nextInt();
	    int res1 = itr_fastexp(n,p);
	    int res2 = rec_fastexp(n,p);
	    System.out.println(res1);
	    System.out.println(res2);
	}
	public static int itr_fastexp(int n,int p){
	    int res = 1;
	    while(p>0){
	        if(p%2 == 1)res=res*n;
	        p= p>>1;
	        n*=n;
	    }
	    return res;
	}
	public static int rec_fastexp(int n,int p){
	    if(p == 0)return 1;
	    if(p%2 == 0){
	        int r = rec_fastexp(n,p/2);
	        return r*r;
	    }else{
	        return n*rec_fastexp(n,p-1);
	    }
	}
}
