package misc;

public class CheckPalindrome {

	public static void main(String[] args) {
		String str = "X";
		char[] chars = new char[str.length()];
		int m = chars.length/2;
		chars = str.toCharArray();
		boolean pal = true;
		for(int i=0;i < m;i++) {
			if(Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[(chars.length - 1) - i])) {
				pal = false;
			}
		}
		if(pal) {
			//System.out.println("It's a pal");
		}
		
		//System.out.println(new StringBuffer("ABA").reverse());
		System.out.println(longestPalindrome("jwfhqefbfkqbwfbkjfbkfbkqfbkbwebananavahsfhwgefkekfe"));
	}

	private static String longestPalindrome(String string) {
		int n = string.length();
		int start = 0;
		int max_len = 0;
		boolean pal[][] = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			pal[i][i] = true;
		}
		
		for(int current_len = 2; current_len <= n; current_len++) {
			for(int i = 0; i < n - current_len + 1; i++) {
				int j = i + current_len - 1;
				if(string.charAt(i) == string.charAt(j) && pal[i+1][j-1]) {
					start = i;
					max_len = current_len;
					pal[i][j] = true;
				}
			}
		}
		
		return string.substring(start, start + max_len);
	}
	
	
	/*// This is wrong
	public static String returnLongestPalindrom(String str) {
		System.out.println("str: " + str);
		if(str.length() == 1) return str;
		if(str.equals(new StringBuffer(str).reverse().toString())) return str;
		else if(returnLongestPalindrom(str.substring(1)).equals(str.substring(1))) return str.substring(1);
		else if(returnLongestPalindrom(str.substring(0, str.length()-1)).equals(str.substring(0, str.length()-1))) return str.substring(0, str.length()-1);
		return returnLongestPalindrom(str.substring(1, str.length()-1));
	}*/
}
