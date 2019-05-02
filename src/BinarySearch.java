import java.util.Arrays;


public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {9,2,8,3,10,0,2,8,1};
		int find = 8;
		MergeSort sort = new MergeSort();
		sort.mergeSort(arr);
	
		System.out.println("Found: " + binarySearch(arr, find));
		int firstFind = binarySearchFirst(arr, 8, true);
		int lastFind = binarySearchFirst(arr, 8, false);
		System.out.println("Last Find: " + lastFind);
		System.out.println("First Find: " + firstFind);
		System.out.println("Total Occurences= " + (lastFind - firstFind + 1));
		
	}

	private static boolean binarySearch(int[] arr, int find) {
		int l = 0;
		int r = arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(arr[mid] == find) 
				return true;
			if(arr[mid] > find) {
				r = mid-1;
			}
			if(arr[mid] < find) {
				l = mid+1;
			}
		}
		return false;
	}
	
	private static int binarySearchFirst(int[] arr, int find, boolean first) {
		int result = -1;
		int begin = 0;
		int mid = 0;
		int end = arr.length;
		while(begin <= end) {
			mid = end + (begin-end)/2;
			if(arr[mid] == find) {
				result = mid;
				if(first)
					end = mid - 1;
				else
					begin = mid + 1;
			}
			if(arr[mid] < find) {
				begin = mid + 1;
			}
			if(arr[mid] > find) {
				end = mid - 1;
			}
		}
		return result;
	}
	
/*private static int binarySearchLast(int[] arr, int find) {
	int result = -1;
	int begin = 0;
	int mid = 0;
	int end = arr.length;
	while(begin <= end) {
		mid = end + (begin-end)/2;
		if(arr[mid] == find) {
			result = mid;
			begin = mid + 1;
		}
		if(arr[mid] < find) {
			begin = mid + 1;
		}
		if(arr[mid] > find) {
			end = mid - 1;
		}
	}
	return result;
	}*/
	
}
