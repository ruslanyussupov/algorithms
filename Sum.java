public class Sum {
	
	public static void main(String[] args) {
		int[] arr0 = new int[] {1,2,3,4,5};
		int[] arr1 = new int[] {1};
		int[] arr2 = new int[] {};
		System.out.println(sum(arr0, arr0.length-1)); // 15
		System.out.println(sum(arr1, arr1.length-1)); // 1
		System.out.println(sum(arr2, arr2.length-1)); // 0
	}

	private static int sum(int[] arr, int index) {

		if (arr.length == 0) {
			return 0;
		}

		if (index == 0) {
			return arr[0];
		}

		return arr[index] + sum(arr, index - 1);

	}

}