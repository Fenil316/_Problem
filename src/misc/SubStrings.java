package misc;

public class SubStrings {
	public static void main(String[] args) {
		String str = "abc";
		int numberOfSubStrings = 0;
		int strLength = str.length();
		for(int size = 0; size< strLength; size++) {
			int i = 0;
			int j = 1 + size;
			while(j <= strLength) {
				System.out.println(str.substring(i, j));
				i++;
				j++;
				numberOfSubStrings++;
			}
		}
		
		System.out.println("Number of Substrings: " + numberOfSubStrings);
		
		// Or
		
		System.out.println("Number of Substrings using formula: " + countNonEmptySubStrings(strLength));
	}
	
	// If you include empty substring, add 1 to the formula:
	public static int countNonEmptySubStrings(int length) {
		return length * ((length + 1)/2);
	}
}
