public class LpsArray{

	public static void main(String[] args) {
		String pattern =  "aba";
		String text = "abcabdabad";
		Construct_Lps_Array(pattern);
	}
	public static void Construct_Lps_Array(String pattern) {
		int kmp[] = new int[pattern.length()];
		kmp[0] = 0;
		int i =0;
		int j =1;
		while(j<pattern.length()) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				kmp[j] = i+1;
				i++;
				j++;
			}else {
				if(i != 0) {
					i = kmp[i-1];
				}else {
					kmp[j] = 0;
					j++;
				}
			}
		}
		for(int n:kmp) {
			System.out.println(n);
		}
		
	}
}
