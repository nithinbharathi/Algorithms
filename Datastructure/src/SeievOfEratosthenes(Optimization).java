/* Unlike the traditional seive we bring down the memeory to n/2 by making use of the fact that every prime number 
other than 2 is odd*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Seive
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int max = 100000001;
		boolean dp[] = new boolean[max/2];
		for(int i=3;i*i<max;i+=2){
		    if(dp[i/2] == false){
		        for(int j =i*i;j<max;j+=2*i){
		            dp[j/2] = true;
		        }
		    }
		}
		System.out.println("2");
		int c = 2;
		for(int i=3;i<max;i+=2){
		    if(dp[i/2] == false){
		       if(c%100 == 1){
		           System.out.println(i);
		       }
		       c++;
		    }
		}
	}
}
