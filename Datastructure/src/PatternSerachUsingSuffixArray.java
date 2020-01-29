
import java.util.*;
import java.lang.*;
import java.io.*;

class PatternSearchInSuffixArray
{
   public static int mod = (int)1e9+7;
   static int n =0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		String s = "banana";
		String pattern = "ana";
		suffix suffix_array[] = new suffix[s.length()];
		for(int i=0;i<s.length();i++){
		    suffix_array[i] = new suffix(i,s.substring(i,s.length()));
		}
		Comparator<suffix>cmp = new Comparator<suffix>(){
		    public int compare(suffix a,suffix b){
		        return a.str.compareTo(b.str);
		    }
		    
		};
		Arrays.sort(suffix_array,cmp);
		int result = binary_search(s,pattern,suffix_array);
		System.out.println(result);
		
	}
	public static int binary_search(String s,String pattern,suffix suffix_array[]){
	    int l =0;
	    int r = s.length()-1;
	    while(l<=r){
	        int mid = (l+r)/2;
	        int res = suffix_array[mid].str.compareTo(pattern);
	        if(res == 0){
	            return mid;
	        }else if(res>0){
	            r = mid-1;
	        }else{
	            l = mid+1;
	        }
	    }
	    return -1;
	}
}

class suffix{
    int index;
    String str;
    public suffix(int index,String str){
        this.index = index;
        this.str = str;
    }
}
