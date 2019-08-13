class Manacher{

	public static void main(String[] args)
	{
			String str = "ababac";
			transform_string(str);
			
			
	}
  
	public static void transform_string(String str){
			String result = "$#";
			for(int i =0;i<str.length();i++){
				result +=str.charAt(i);
				result+="#";
			}
			result+="@";
			System.out.println(result);
			manacher(result);
		}
    
  public static void manacher_algorithm(String result){
      int center = 0;
          int mirror = 0;
          int right_boundary = 0;
          int cache[] = new int[result.length()];
          for(int i =1;i<result.length()-1;i++){
            mirror = 2*center - i;
            if(i<right_boundary){
              cache[i] = Math.min(right_boundary-i,cache[mirror]);
            }
            while(result.charAt(i+(1+cache[i])) == result.charAt(i-(1+cache[i]))){
              cache[i]++;
            }
            if(i+cache[i]>right_boundary){
              center = i;
              right_boundary = i+cache[i];
            }
          }
          int max_length = Integer.MIN_VALUE;
          for(int i=0;i<cache.length;i++){
            if(cache[i]>max_length){
              max_length = cache[i];
              center = i;
            }
          }
          System.out.println(str.substring((center-1-max_length)/2,max_length));
  }
	    
}
