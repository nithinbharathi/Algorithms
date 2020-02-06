
import java.util.*;
import java.lang.*;
import java.io.*;

class FermatnCr
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int m = input.nextInt();
		calculate_ModularInverse(a,m);
	}
	public static void calculate_ModularInverse(int a,int m){
	    if(gcd(a,m) != 1){
	        System.out.println("Inverse of "+a+" "+"Does Not Exist");
	    }else{
	        System.out.println("Inverse of a"+" "+power(a,m-2,m));
	    }
	}
	public static long power(int a,int p,int m){
	    long res =1;
	    while(p>0){
	        if((p&1) == 1){
	            res = (res*a)%m;
	        }
	        p/=2;
	        a= (a*a)%m;
	        
	        
	    }
	    return res;
	}
	public static int gcd(int a,int b){
	    return b==0?a:gcd(b,a%b);
	}
}
