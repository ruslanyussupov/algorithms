import java.util.Scanner;

public class GCD {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println(find(a, b));
		scan.close();
	}

	private static int find(int a, int b) {

		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		if (a > b) {
			return find(b, a % b);
		} else {
			return find(a, b % a);
		}

	}

}