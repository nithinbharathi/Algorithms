
import java.util.*;
import java.lang.*;
import java.io.*;

class nCrMod
{
    static long fact[];
    static int mod;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int r = input.nextInt();
		  mod = input.nextInt();
		fact = new long[n+1];
		fact[0] = 1;
		for(int i=1;i<=n;i++){
		    fact[i] = (i*fact[i-1])%mod;
		}
		System.out.println(calculate_nCr(n,r));
	}
	public static long calculate_nCr(int n,int r){
	    return ((fact[n] * inverse(fact[r],mod))%mod*fact[n-r])%mod;
	}
	public static long inverse(long a,long p){
	    long res = 1;
	    while(p>0){
	        if((p&1)==1)res = (res*a)%mod;
	        p>>=1;
	        a= (a*a)%mod;
	    }
	    return res;
	    
	}
}
