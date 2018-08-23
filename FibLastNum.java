import java.util.Scanner;

public class FibLastNum {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		System.out.println(getLastFibNum(n));

	}

	private static int getLastFibNum(int n) {

		int f0 = 0;
		int f1 = 1;

		if (n == 0) {
			return f0;
		} else if(n == 1) {
			return f1;
		}

		for (int i = 2; i <= n; i++) {
			int tmp = f1;
			f1 = (f0 + f1) % 10;
			f0 = tmp;
		}

		return f1;

	}

}