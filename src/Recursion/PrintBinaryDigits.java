package Recursion;

public class PrintBinaryDigits {
	public static void main(String[] args) {
		printBinartDigitsOfLength(3);
	}

	private static void printBinartDigitsOfLength(int i) {
		String prefix="";
		helper(i, prefix);
	}

	private static void helper(int i, String prefix) {
		System.out.println("helper(" + i + ", " + prefix + ")");
		if(i == 0) {
			System.out.println(prefix);
		} else {
			helper(i - 1, prefix + "0");
			helper(i - 1, prefix + "1");
		}
	}
}
