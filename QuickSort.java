import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,5,8,1,2,9,4,7,6};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		//quickSort(arr, 0, arr.length - 1);
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int low, int high) {

		if (arr == null || arr.length == 0 || arr.length == 1) {
			return;
		}

		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		int pivot = arr[mid];
		int l = low;
		int h = high;

		while(l <= h) {

			while (arr[l] < pivot) {
				l++;
			}

			while (arr[h] > pivot) {
				h--;
			}

			if (l <= h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
				h--;
			}

		}

		if (low < h) {
			sort(arr, low, h);
		}

		if (high > l) {
			sort(arr, l, high);
		}

	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

}