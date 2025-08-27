public class QuickFindUF {
	private int[] id;

	public QuickFindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) { // set id of object to itself (N arrays accesses)
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) { // check whether p and q are in the same component (2 arrays accesses);
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int pID = id[p];
		int qID = id[q];
		for (int i = 0; i < id.length; i++) { // change all entries with id[p] to id[q] (at most N² + 2 arrays accesses)
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
	}
}

// Big O Notation of quick-find ->
// 	initialize = N
// 	union = N
// 	find = 1
// Quick find is a cost model, for that was defected, the union is too expensive, the trees are flat, but too expensive to keep them flat
// EX. Takes N² array accesses to process sequence of N union commands on N objects
