
import java.util.*;
import java.lang.*;
import java.io.*;

class SuffixArray
{
   public static int mod = (int)1e9+7;
   static int n =0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		String s = "banana";
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
		for(int i=0;i<s.length();i++){
		    System.out.println(suffix_array[i].index+" "+suffix_array[i].str);
		}
		
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
