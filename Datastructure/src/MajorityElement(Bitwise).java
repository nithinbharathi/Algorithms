//Time Complexity: O(NlogN)
//Space Complexity: O(1)
//Problem Statement: Given an array of integers find an element that occurs more than n/2 times where n=>lenght of the array.

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int num =0;
		for(int i=0;i<32;i++){
		    int count =0;
		    for(int j =0;j<arr.length;j++){
		        if ((arr[j] & (1 << i)) != 0)  
                    count++;
		    }
		    if(count>arr.length/2){
		        num+= (1<<i);
		    }
		}
		int count =0;
		for(int i=0;i<arr.length;i++){
		    if(num == arr[i]){
		        count++;
		    }
		}
		if(count>arr.length/2){
		    System.out.println("Majority Element: "+num);
		}else{
		    System.out.println("No Majority element Present!");
		}
        
	}
	
}
