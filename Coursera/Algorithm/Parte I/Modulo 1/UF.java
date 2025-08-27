public class UF {

	int[] parent;
	int[] size;
	int count;

	public UF(int N) {
		parent = new int[N];
		size = new int[N];
		count = N;

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		System.out.println("UF iniciado com " + N + " elementos. Cada elemento é seu próprio componente.");
	}	

	public void union(int p, int q) {
		 System.out.println("Union chamado para: " + p + " e " + q);
		int rootP = find(p);
		int rootQ = find(q);

		if (rootP == rootQ) {
			System.out.println(" - Já estão conectados. Nenhuma ação necessária.");
			return;
		}

		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
			 System.out.println(" - " + rootP + " se conecta a " + rootQ + ". Tamanho atualizado: " + size[rootQ]);
		} else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
			 System.out.println(" - " + rootQ + " se conecta a " + rootP + ". Tamanho atualizado: " + size[rootP]);
		}
		count--;
		 System.out.println(" - Número de componentes agora: " + count);
	}

	public String connected(int p, int q) {
		System.out.println("Connected chamado para: " + p + " e " + q);
		if (!(find(p) == find(q))) { return "false"; }
		return "true";
	}

	public int find(int p) {
		System.out.println("Find chamado para: " + p);
		while (p != parent[p]) {
			System.out.println(" - " + p + " aponta para " + parent[p] + ", aplicando path compression...");
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		System.out.println(" - Raiz de " + p + " encontrada: " + p);
		return p;	
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Exemple of usage: java UF 5 union 0 1 union 1 2 connected 0 2 count");
			return;
		}

		int N = Integer.parseInt(args[0]);
		UF uf = new UF(N);

		for (int i = 1; i < args.length; ) {
			String operation = args[i];

			switch (operation.toLowerCase()) {
				case "union":
					int p = Integer.parseInt(args[i + 1]);
					int q = Integer.parseInt(args[i + 2]);
					uf.union(p,q);
					System.out.printf("Union: %d, %d\n", p, q);
					i += 3;
					break;
				case "connected":
					p = Integer.parseInt(args[i + 1]);
					q = Integer.parseInt(args[i + 2]);
					System.out.printf("Connected(%d, %d) ? %s\n", p, q, uf.connected(p,q));
					i += 3;
					break;
				case "count":
					System.out.printf("Number of components: %d\n", uf.count());
					i += 1;
					break;
				default:
					System.out.printf("Unknown operation: %s\n", operation);
					i += 1;
					break;
			}
		}
	}
}
