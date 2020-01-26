//Time Complexity: O(N)
//Space Complexity: O(1)

/* boyre moore algorithm is used to find the majority element of an array in o(n) time.if an element occurs more than n/2 times n=>length of the array
then its frequency is more than that of any other element so we first find the candidate for majority element and then check if its true.
i.e if the candidate appears more than n/2 times where n is the length of the array
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int num =arr[0];
		int count =1;
		for(int i=1;i<arr.length;i++){
		    if(arr[i] == num){
		        count++;
		    }else{
		        count--;
		        if(count == 0){
		            num = arr[i];
		            count =1;
		        }
		    }
		}
		for(int i=0;i<arr.length;i++){
		    if(num == arr[i])count++;
		}
		if(count>arr.length/2){
		    System.out.println("Majority Element "+num);
		}else{
		    System.out.println("No Majority Element Found !");
		}
		
		
	}
	
}
