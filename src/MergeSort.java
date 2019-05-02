
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {5,1,3,7,2,4,9,-1};
		MergeSort m = new MergeSort();
		int [] sortedArr = m.mergeSort(arr);
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.println(sortedArr[i]);
		}
	}

	public int[] mergeSort(int[] arr) {
		int[] sortedArray = new int[arr.length];
		int length = arr.length;
		int mid = length /2;
		if(mid < 1) {
			return sortedArray;
		}
		int left[] = new int[mid];
		int right[] = new int[length - mid];
		for(int i = 0; i<= mid-1; i++) {
			left[i] = arr[i];
		}
		
		for(int i = mid; i<arr.length; i++) {
			right[i-mid] = arr[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		
		sortedArray = merge(left, right, arr);
		return sortedArray;
	}

	private int[] merge(int[] left, int[] right, int[] arr) {
		int i=0;
		int j=0;
		int k=0;
		
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			} else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		
		while (i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		
		while (j < right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
		
		return arr;
	}
}
