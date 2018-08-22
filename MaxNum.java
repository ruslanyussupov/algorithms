import java.util.Arrays;

public class MaxNum {

    public static void main(String[] args) {
    	int[] arr = new int[]{30, 5, 10, 25, 16, 1, 35};
        System.out.println(max(arr)); // 35
        System.out.println(max(arr, arr.length-1)); // 35
    }


    private static int max(int[] list) {
    	if (list.length == 2) {
        	return list[0] > list[1] ? list[0] : list[1];
    	}

    	int subMax = max(Arrays.copyOfRange(list, 1, list.length));
    	return list[0] > subMax ? list[0] : subMax;
	}

	private static int max(int[] list, int index) {

		if (index == 0) {
			return list[0];
		}

		int val = max(list, index - 1);

		return list[index] > val ? list[index] : val;

	}

}