package Recursion;

public class CodingBatRecursion1 {

	public static void main(String[] args) {
		int result = count8(88818);
		//System.out.println(result);
		//System.out.println(countX("ixxxix"));
		//System.out.println(countHi("xhhihi"));
		//System.out.println(changeXY("xxhixx"));
		//System.out.println(changePi("xppiiix"));
		//System.out.println(noX("xaxb"));

		// Find occurences of 11:
		//int [] arr = {11,11};
		//System.out.println(array11(arr, 0));

		// Find the number after is 10 times:
		//int [] arr = {2,20};
		//System.out.println(array220(arr,0));

		// Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
		//System.out.println(allStar("Hello"));

		// Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
		//System.out.println(pairStar("hello"));

		//Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
		//System.out.println(endX("xhixxhixxxhix"));

		//We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string.
		//System.out.println(countPairs("AXAXA"));

		// Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
		//System.out.println(countAbc("abcxaxabccabaxx"));

		//Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
		//System.out.println(count11("111")); // try "11x11 or abc11x11x11"

		// Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".
		// System.out.println(stringClean("yyzzzzaaaa   xxxx"));

		// Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.
		// System.out.println(countHi2("xxhhihi")); // Also try: "xxhi", "hixxhi", "xhihihix"

		// Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
		// System.out.println(parenBit("xyz(abc)123"));

		// Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
		// System.out.println(strDist("catcowcat", "cat")); // strDist("catcowcat", "cat") → 9, strDist("cccatcowcatxx", "cat") → 9, strDist("hiHellohihihi", "hi") → 13, strDist("abccatcowcatcatxyz", "cat") → 12
		
		// Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
		System.out.println(strCopies("iiijjj", "ii", 2)); // strCopies("catcowcat", "cat", 2) → true, strCopies("ijiiiiij", "iiii", 3) → false
	}

	public static boolean strCopies(String str, String sub, int n) {
		if(sub.length() > str.length() && n > 0) return false;
		if(n == 0) return true;
		if(str.startsWith(sub)) {
			n--;
		}
		if(!str.startsWith(sub)) {

		}
		return strCopies(str.substring(1), sub, n);
	}



	public static int strDist(String str, String sub) {
		if(str.length() < sub.length()) return 0;
		if(str.startsWith(sub)) {
			if(str.endsWith(sub)) {
				return str.length();
			} else {
				return strDist(str.substring(0, str.length() - 1), sub);
			}
		}
		return strDist(str.substring(1), sub);
	}


	/*public static String parenBit(String str) {
		if(str.length() == 0 || str.length() == 1) return "";
		if(str.startsWith(")")) return ")";
		if(str.startsWith("("))  {
			String temp = "(";
			if(str.substring(1)
		}  
		return parenBit(str.substring(1));

	}*/

	public static String parenBit(String str) {
		if (!str.substring(0, 1).equals("("))
			return parenBit(str.substring(1));
		return (str.substring(0, str.indexOf(")") + 1));
	}

	public static int countHi2(String str) {
		if(str.length() == 0 || str.length() == 1) return 0;
		if(str.charAt(0) == 'x' && str.charAt(1) == 'h')
			return countHi2(str.substring(2));
		if(str.charAt(0) == 'h' && str.charAt(1) == 'i')
			return 1 + countHi2(str.substring(1));

		return countHi2(str.substring(1));
	}


	public static String stringClean(String str) {
		if(str.length() == 0 || str.length() == 1) return str;
		if(str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));

		return str.charAt(0) + stringClean(str.substring(1));
	}


	public static int count11(String str) {
		if(str.length() == 0 || str.length() == 1) return 0;
		if(str.charAt(0) == '1' && str.charAt(1) == '1')
			return 1 + count11(str.substring(2));

		return count11(str.substring(1));
	}


	public static int countAbc(String str) {
		if(str.length() == 0 || str.length() == 1 || str.length() == 2) return 0;
		if(str.startsWith("abc") || str.startsWith("aba")) 
			return 1 + countAbc(str.substring(1));
		return countAbc(str.substring(1));
	}


	public static int countPairs(String str) {
		if(str.length() == 0 || str.length() == 1 || str.length() == 2) return 0;
		if(str.charAt(0) == str.charAt(2)) return 1 + countPairs(str.substring(1));
		return countPairs(str.substring(1));
	}


	public static String endX(String str) {
		if(str.length() == 0 || str.length() == 1) return str;
		if(str.charAt(0) == 'x') {
			str = endX(str.substring(1)) + 'x';
			return str;
		}
		return str.charAt(0) + endX(str.substring(1));
	}


	public static String pairStar(String str) {
		if(str.length() == 0 || str.length() == 1) return str;
		if(str.charAt(0) == str.charAt(1))
			return str.charAt(0) + "*" + pairStar(str.substring(1));
		return str.substring(0,1) + pairStar(str.substring(1));
	}


	public static String allStar(String str) {
		if(str.length() == 0 || str.length() == 1) return str;
		return str.substring(0,1) + "*" + allStar(str.substring(1));
	}


	public static boolean array220(int[] nums, int index) {
		if(index + 1 > nums.length - 1 || nums.length == 1) return false;
		if(nums[index + 1] == nums[index]*10 ) return true;
		index++;
		return array220(nums, index);
	}


	public static int array11(int[] nums, int index) {
		if(index > nums.length - 1) return 0;
		if(nums[index] == 11) {
			index ++;
			return 1 + array11(nums, index);
		} else {
			index ++;
			return 0 + array11(nums, index);
		}
	}


	public static String noX(String str) {
		if(str.length() < 1 || (str.length() == 1 && !str.equals("x"))) return str;
		if(str.equals("x")) return "";
		return noX(str.substring(0,1)) + noX(str.substring(1));
	}

	public static String changePi(String str) {
		if(str.length() < 2) return str;
		if(str.startsWith("pi")) {
			return "3.14" + changePi(str.substring(2));
		}
		if(str.length() == 2 && !str.equals("pi")) return str;

		return changePi(str.substring(0,1)) + 
				changePi(str.substring(1));
	}

	private static String changeXY(String str) {
		if(str.length() == 0 || (str.length() ==1 && !str.equals("x"))) return str;
		if(str.equals("x")) return "y";

		return changeXY(str.substring(0,1)) + 
				changeXY(str.substring(1));
	}

	private static int countHi(String string) {
		if(string.length() < 2) return 0;
		if(string.length() == 2 && string.equals("hi")) return 1;
		if(string.length() == 2 && !string.equals("hi")) return 0;


		return countHi(string.substring(0, 2)) + 
				countHi(string.substring(1));
	}

	private static int countX(String string) {
		if(string.length() == 1 && !string.equals("x")) return 0;
		if(string.equals("x")) return 1;
		else 
			return countX(string.substring(1)) + 
					countX(string.substring(0,1));
	}

	public static int count8(int n) {
		if(n / 10 == 0) {
			if(n == 8) return 1;
			else return 0;
		} else {
			if(n % 10 == 8 && n / 10 == 8)
				return (count8(n%10) + 2*count8(n/10));
			else 
				return count8(n%10) + count8(n/10);
		}
	}
}


