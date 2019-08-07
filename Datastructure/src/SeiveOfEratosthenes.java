//Time Complexity: O(nlog(log(n))) &&  Space Complexity: O(n)

public class SeiveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int seive[] = new int[101];
          for(int i =2;i<=Math.sqrt(100);i++){
        	  if(seive[i] == 0){
        		  for(int j =i;i*j<=100;j++){
            		  seive[i*j] = 1;
            	  }
        	  }
        	  
          }
       for(int i =2;i<=100;i++){
        	if(seive[i] == 0){
        		  System.out.print(i+" ");
        	  }
          }
	     }
}
