package misc;

import java.util.ArrayList;
import java.util.List;

public class CommonSubstrings {

	public static void main(String[] args) {
		CommonSubstrings str = new CommonSubstrings();
		String s1 = "251220825122082";
		String s2 = "bbb";
		str.findCommonSubstrings(s1, s2);
	}
	
	public String[] findCommonSubstrings(String s1, String s2) {
		List<String> resultList = new ArrayList<String>();
		int arr[];
		String repeatedS1 = s1.replaceAll("(.+?)\\1+", "$1");
		String repeatedS2 = s2.replaceAll("(.+?)\\1+", "$1");
		if (repeatedS1.equalsIgnoreCase(repeatedS2)) {
			int[] s1Factors = findFactors(s1.length()/repeatedS1.length());
			int[] s2Factors = findFactors(s2.length()/repeatedS1.length());
			if(s1Factors.length > s2Factors.length) {
				arr = findCommonFactors(s2Factors, s1Factors);
			} else {
				arr = findCommonFactors(s1Factors, s2Factors);
			}
			resultList.add(repeatedS1);
			System.out.println(repeatedS1);
			for(int i = 1; i < arr.length ; i++) {
				resultList.add(concatString(repeatedS1, i));
				System.out.println(resultList.get(i));
			}
		} else {
			System.out.println("Nothing!");
		}
			
		return resultList.toArray(new String[0]);
	}
	
	private String concatString(String string, int i) {
		String concated = string;
		for(int j = 0; j < i; j++) {
			concated = concated + concated;
		}
		return concated;
	}

	private int[] findCommonFactors(int[] s2Factors, int[] s1Factors) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while(true) {
			if(s2Factors[i] == s1Factors[j]) {
				list.add(s2Factors[i]);
				i++;
				j++;
			} else {
				if(s2Factors[i] > s1Factors[j]) {
					j++;
				} else {
					i++;
				}
			}
			if(i == s2Factors.length || j == s1Factors.length) {
				break;
			}
		}
		return list.stream().mapToInt(x -> (int)x).toArray();
	}

	public int[] findFactors(int number) {
		List<Integer> list = new ArrayList<Integer>();
		int counter = 0;
		for(int i=1; i<=number/2; i++) {
			if(number % i == 0) {
				list.add(i);
				counter++;
			}
		}
		list.add(number);
		int[] arr = list.stream().mapToInt(x -> (int)x).toArray();
		return arr;
	}
}
