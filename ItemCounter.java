import java.util.Arrays;


public class ItemCounter {
	
	public static void main(String[] args) {

		System.out.println(count(new int[] {1,2,3,4,5,6,7,8,9})); // 9
		System.out.println(count(new int[] {1,2})); // 2
		System.out.println(count(new int[] {1})); // 1
		System.out.println(count(new int[] {})); // 0
	}

	private static int count(int[] arr) {

		if (arr.length == 0) {
			return 0;
		}

		return 1 + count(Arrays.copyOfRange(arr, 1, arr.length));

	}

}