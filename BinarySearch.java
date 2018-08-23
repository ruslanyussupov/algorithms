public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
		41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

		System.out.println("Prime search: " + search(arr, 89));
	}

	public static int search(int[] arr, int val) {

		int min = 0;
		int max = arr.length - 1;

		while(min <= max) {

			int mid = min + ((max - min)/2);

			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] > val) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}

		}

		return -1;

	}

}