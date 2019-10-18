import java.util.*;
import java.lang.*;
import java.io.*;

class KMP
{   static int LPS[];
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String pattern = input.next();
		int pos = kmp(string,pattern);
		if(pos == -1){
		    System.out.println("Pattern not found!");
		}else{
		    System.out.println("Pattern found at index "+pos);
		}
		
	}
	public static int kmp(String string,String pattern){
	    construct_LPS(pattern);
	    int i =0,j=0;
	    while(i<string.length()){
	        if(string.charAt(i) == pattern.charAt(j)){
	            
	            j++;
	            i++;
	            if(j == pattern.length()){
	                return i-j;
	            }
	            
	        }else if(j>0){
	            j = LPS[j-1];
	        }else{
	            i++;
	        }
	    }
	    return -1;
	}
	public static void construct_LPS(String pattern){
	    LPS = new int[pattern.length()];
	    int i =0;
	    for(int j =1;j<pattern.length();j++){
	        if(pattern.charAt(i) == pattern.charAt(j)){
	            i++;
	            LPS[j] = i;
	        }else if(pattern.charAt(i) != pattern.charAt(j) && i>0){
	            i = LPS[i-1];
	        }else{
	            continue;
	        }
	    }
	    
	} 
}
