// Time Complexity: O(text_length-pattern_length+1)
// Space Complexity: O(1);


public class rabinkarp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rabin obj = new rabin();
		String text = "abaabcdef";
		String pattern = "abc";
		System.out.println(obj.rabin_karp(text, pattern));
		

	}

}
class rabin{
	public int rabin_karp(String str,String pattern){
		if(str == null || pattern == null || str.length()<pattern.length()){
			return -1;
		}
		int str_length = str.length();
		int pattern_length = pattern.length();
		int pattern_hash = hash(pattern,pattern_length);
		int text_hash = hash(str,pattern_length);
		for(int i =0;i<=str_length-pattern_length;i++){
			if(pattern_hash == text_hash && string_match(str.substring(i,i+pattern_length),pattern)){
				return i;
			}
			if(i<str_length-pattern_length){
				text_hash = recalculate_hash(str,text_hash,i,i+pattern_length,pattern_length);
			}
		}
		return -1;
	}
	public boolean string_match(String a ,String b){
		for(int i =0;i<a.length();i++){
			if(a.charAt(i) != b.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public int hash(String str,int size){
		int hash = 0;
		for(int i=0;i<size;i++){
			hash = hash+ (str.charAt(i)*(int)Math.pow(101, i));
		}
		return hash;
	}
	public int recalculate_hash(String str,int old_hash,int old_index,int new_index,int pattern_length){
		int hash = 0;
		hash = old_hash - str.charAt(old_index);
		hash = hash/101;
		hash = hash+(str.charAt(new_index)*(int)Math.pow(101,pattern_length-1));
		return hash;
	}
	
}
