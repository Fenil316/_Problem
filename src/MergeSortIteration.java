
public class MergeSortIteration {
	public static void main(String[] args) {
		int[] arr = {9,2,8,3,10,0,2,8,1};
		mergeSort(arr);
		System.out.println(arr);
	}

	private static int[] mergeSort(int[] arr) {
		int length = arr.length;
		int mid = length / 2;
		if(mid < 1) {
			return arr;
		}
		int[] arrL = new int[mid];
		int[] arrR = new int[length - mid];
		for(int i=0; i<= mid-1; i++) {
			arrL[i] = arr[i];
		}
		for(int i=mid; i< length; i++) {
			arrR[i - mid] = arr[i];
		}
		mergeSort(arrL);
		mergeSort(arrR);
		merge(arrL, arrR, arr);
		return arrR;
	}

	private static void merge(int[] arrL, int[] arrR, int[] arr) {
		int i=0;
		int j=0;
		int k=0;
		
		while(i < arrL.length && j < arrR.length ){
			if(arrL[i] < arrR[j]) {
				arr[k] = arrL[i];
				i++;
				k++;
			}else {
				arr[k] = arrR[j];
				j++;
				k++;
			}
		}
		
		while(i< arrL.length) {
			arr[k] = arrL[i];
			i++;
			k++;
		}
		
		while(j<arrR.length) {
			arr[k] = arrR[j];
			j++;
			k++;
		}
	}
}
