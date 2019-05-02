package misc;

public class LongestConsecutiveRepeatingChar {
	public static void main(String[] args) {
		String str = "aaabcbcbcbcxxxx";
		System.out.println(longestConsecutiveChar(str));
	}

	private static char longestConsecutiveChar(String str) {
		char result = ' ';
		int count = 1;
		int max = 0;
		for(int i = 1; i < str.length(); i ++) {
			if(str.charAt(i - 1) == str.charAt(i)) {
				count ++;
			} else {
				if(count > max) {
					max = count;
					result = str.charAt(i - 1);
				}
				count = 1;
			}
			
			if(i == str.length()-1) {
				if(count > max) {
					result = str.charAt(i);
				}
			}
		}
		return result;
	}

}
