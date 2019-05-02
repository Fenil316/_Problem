package Recursion;

public class RecursiveSearch {

	public static void main(String[] args) {
		int A[] = {10,20,-2,-5,6,8,9,11,18};
		int returned = findNumber(A, 8, 0);
		System.out.println("Number returned: " + returned);
	}

	/*
	 * 1) This is a game of scope. The scope changes for every recursive function call. Thus, all the values
	 *    to be retained/manipulated for calculation has to be passed as parameter.
	 * 2) Once the job of i is done in the second if condition, the variable 'i' can be reused to hold the value. how?
	 *    It is thrown back at the previously called function when it is returning. This is the only communication between
	 *    the present and the past call. This is how you pass the values between one call and its previous call.
	 *    The present call will continue with past call that was invoked previously (from the place it was left off) and 
	 *    where the value thrown by the present call will be caught and will be re-thrown to the previous calling function.
	 * 3) Finally we will reach to the first call and throw the value back to the main fucntion.
	 * 
	 * Note: important is to note the ever changing scope of variables everytime we go into a call hierarchy. Also do
	 * all the manipulations after the values are returned because that is how you will accumulate/add the values backwards
	 * to form the solution.
	 * 
	 * Refer: https://www.youtube.com/watch?v=ttTH_WX-Cbo
	 * */
	private static int findNumber(int[] a, int num, int i) {
		if(i > a.length) return -1;
		if(a[i] == num) {
			System.out.println("Found the number: " + num);
			return i;
		} else {
			System.out.println("Calling method again since found: " + a[i] + " and looking for " + num);
			i = findNumber(a, num, i+1);
			System.out.println("Call back to the previous call where value explored was: " + a[i] + " and value held: " + i);
			return i;
		}
	}
}
