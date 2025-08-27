public class QuickUnionUF {
	private int[] id;

	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {  // chase parent pointers until reach root (depth of i array access)
		while(i != id[i]) {
			i = id[i];
		}

		return i;
	}

	public boolean connected(int p, int q) { // check if p and q have same root (depth of p and q array accesses)
		return root(p) == root(q);
	}

	public void union(int p, int q) { // change root of p to point to root of q (depth of p and q array accesses)
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}

// Big O Notation of quick-union ->
// 	- initialize = N
// 	- union = N (includes cost of finding roots)
//	- find = N (worst case)
// Quick-union was defected, because the trees can get tall and find is too expensive (could be N array accesses)
