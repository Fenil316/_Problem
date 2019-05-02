import java.util.ArrayList;
import java.util.List;


public class PrintSubsets {

	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6};
		int index = 0;
		List<String> subsets = new ArrayList<String>();
		subsets.add("null");
		while(index < array.length) {
			int element = array[index];
			List<String> addedElements = new ArrayList<String>();
			for(String eachElement: subsets) {
				String addElement;
				if(eachElement.equalsIgnoreCase("null")) 
					addElement = "" + element;
				else 
					addElement = eachElement + "," + element;
				addedElements.add(addElement);
			}
			subsets.addAll(addedElements);
			index++;
		}
		System.out.println(subsets);
		System.out.println("Recursive::::::::::::::");
		PrintSubsets p = new PrintSubsets();
		p.printSubsets(array);
	}

	/*public void printSubsetsRecursively(Integer[] arr) {
		Integer[] subset = new Integer[arr.length];
		helper(arr, subset, 0);
	}

	private void helper(Integer[] arr, Integer[] subset, int i) {
		if(i == arr.length) {
			for(int j=0;j<subset.length;j++) {
				System.out.print(subset[j] + " ");
			}
			System.out.println();
			
		} else {
			subset[i] = null;
			helper(arr, subset, i+1);
			subset[i] = arr[i];
			helper(arr, subset, i+1);
		}
	}
*/
	
	public void printSubsets(Integer[] arr) {
		Integer[] subset = new Integer[arr.length];
		helper(arr, subset, 0);
	}
	
	private void helper(Integer[] arr, Integer[] subset, int i) {
		if(i == arr.length) {
			for(int j = 0; j<subset.length; j++) {
				if(subset[j] != null)
				System.out.print(subset[j] + " ");
			}
			System.out.println("{}");
		} else {
			subset[i] = null;
			helper(arr, subset, i+1);
			subset[i] = arr[i];
			helper(arr, subset, i+1);
		}
	}
}
