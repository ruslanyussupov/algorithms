import java.util.Scanner;

public class UF {

	private final int[] nodes;
	private final int[] treeSizes;
	
	public UF(int n) {
		nodes = new int[n];
		treeSizes = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = i;
			treeSizes[i] = 1;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("Size: " + n);
		UF uf = new UF(n);
		while (scan.hasNext()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			System.out.println("p = " + p);
			System.out.println("q = " + q);
			if (!uf.isConnected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
		scan.close();

	}

	private int root(int n) {
		int root = n;
		while (root != nodes[root]) {
			root = nodes[root];
		}
		nodes[n] = root;
		return root;
	}

	private boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	private void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		if (p == q) {
			return;
		}
		if (treeSizes[pRoot] < treeSizes[qRoot]) {
			nodes[pRoot] = nodes[qRoot];
			treeSizes[qRoot] += treeSizes[pRoot];
		} else {
			nodes[qRoot] = nodes[pRoot];
			treeSizes[pRoot] += treeSizes[qRoot];
		}
	}

}