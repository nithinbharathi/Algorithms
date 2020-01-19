
import java.util.*;
import java.lang.*;
import java.io.*;

class FermatPrimalityTest
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner input = new Scanner(System.in);
		int p = input.nextInt();
		int res = fermat_primality(p);
		if(res == 1)System.out.println("Prime");
		else System.out.println("Not Prime");
	}
	public static int fermat_primality(int p){
	    if(p<=1 || p == 4)return 0;
	    if(p<=3)return 1;
	    for(int i =2;i<p;i++){
	        if(gcd(i,p) == 0)return 0;
	        if(exp(i,p-1,p) == 0){
	            return 0;
	        }
	        
	    }
	    return 1;
	}
	public static int gcd(int a,int b){
	    return b == 0?a:gcd(b,a%b);
	}
	public static int exp(int a,int p,int mod){
	    int res =1;
	    while(p>0){
	        if(p%2 == 1){
	            res = (res*p)%mod;
	        }
	        p/=2;
	        a = (a*a)%mod;
	    }
	    return res==1?1:0;
	}
}
