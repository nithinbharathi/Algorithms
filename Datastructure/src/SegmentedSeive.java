//Time Complexity: O(nlog(log(n)))
// Space Complexity: O(root n)



public class SeiveOfEratosthenes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
          segment_seive(2,10);
	}
	public static void segment_seive(int low,int high){
		int seive[] = new int[high-low+1];   //seive to mark all the multiples of a prime number between the given range
    
    
		if(low>high){                 // Boundary  Condition check
			System.out.println("enter a valid range");
			return;
		}		
    
    
		for(int i =2;i<=Math.sqrt(high);i++){       // Goes till root of high because if a number n is not 
                                                // divided by any other number d till 
                                                // the square root of the number n then it is prime
                                                
			
      int start = Math.max(i * i,(low+i-1)/i*i); // finding the first multiple of the prime number i in given range
                                                  
      for(int j = start;j<=high;j+=i){      // and making jumps of i to reach the next multiple of i;        
				seive[j-low] = 1;
			}
		}
    
		for(int i =Math.max(2, low);i<=high;i++){   // traversing the seive to print the unmarked numbers(primes)
			if(seive[i-low] == 0){
				System.out.print(i+" ");
			}
		}
	}

}
