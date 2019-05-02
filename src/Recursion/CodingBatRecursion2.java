package Recursion;

public class CodingBatRecursion2 {

	public static void main(String[] args) {
		int[] arr = new int[]{2,4,8};
		System.out.println(groupSum(0, arr, 10));
	}
	
	public static boolean groupSum(int next, int[] nums, int target) {
		System.out.println("groupSum(" + next + ", nums, " +  target + ")");
		  // Base case: if there are no numbers left, then there is a
		  // solution only if target is 0.
		  if (next >= nums.length) return (target == 0);		  
		  
		  // Key idea: nums[start] is chosen or it is not.
		  // Deal with nums[start], letting recursion
		  // deal with all the rest of the array.
		  
		  // Recursive call trying the case that nums[start] is chosen --
		  // subtract it from target in the call.
		  if (groupSum(next + 1, nums, target - nums[next])) 
			  return true;
		  
		  // Recursive call trying the case that nums[start] is not chosen.
		  if (groupSum(next + 1, nums, target)) 
			  return true;
		  
		  // If neither of the above worked, it's not possible.
		  return false;
		}

}
