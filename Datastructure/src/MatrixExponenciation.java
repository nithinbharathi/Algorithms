/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class MatrixExponenciation
{   
  static long dp[][][];
  
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    long result = nth_fib(4);
	    System.out.println(result);
	    
	} 
	public static long nth_fib(int n){
	    if(n<0){
	        System.out.println("Enter a valid n value!");
          
	    }else if(n == 0 || n == 1){            //the 0th and the first number of the sequence is 1
	        return 1;
	    }
	     dp = new long[64][2][2];             //each dp[i] stores a 2d matrix of size 2X2
       
	    dp[0] = new long[][]{{1,1},{1,0}};   //since 2^0 is 1 dp[0] is the matrix itself initially
      
	    for(int i =1;i<64;i++){
	        dp[i] = power(dp[i-1]);            //any index i in the dp array gives us the matrix when dp[0] raised to the power 2^i             
	    }
	    
	    long ans = binary_exponenciation(n-1);
	    return ans;
	}
	public static long[][] power(long m[][]){        //calculates the power for the dp array
	    return multiply(m,m);
	}
	private static long[][] multiply(long[][] matrix1, long[][] matrix2) {

        final long[][] result = new long[matrix1.length][matrix2[0].length];   //usual matrix multiplication
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    
                }
            }
        }
        return result;
    }
	public static long binary_exponenciation(int n){        
	    long[][] result = new long[][]{{1, 0}, {0, 1}};   //identity matrix for multiplying the result just like how we multiply numbers 
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {   /*check if that bit is set basically we are going through each and every bit 
                                                     in powers of 2 and checing if it is set
                                                      12=> binary:  1 1 0 0
                                                                =>  8 4 2 1 each os the bases is in powers of 2 as we already no
                                       1<<i is nothin but 1*2^i so we are checking if 2^3 bit is set 2^2 bit is set 2^1 bit is set........
                                       the reason we are starting from 31st bit is we want the highest power of 2 that is set*/
            
                result = multiply(result, dp[i]);    // similar to int result = 1;result = result*3....
            }
        }
        
	    return result[0][0]+result[0][1];              //once done add the two elements in the first row but its actually
                                                     //after multiplying each power of 2 we will get 
                                                                                                      
                                     //|2 1| *|1| where |1| corresponds to the base case f(n-1) & f(n-2) i.e when n=2 f(n-1)= f(1)
                                       |4 1|  |1|       |1|    and f(n-2) = f(0) remember returning 1 if n == 0 || n==1 that is why 1
                                                              is substituted in the place of f(1) & f(0) 
                                                       
	}
}
