import java.util.LinkedList;

class Kosaraju {

	Graph graph;

	Kosaraju(Graph graph) {
		this.graph = graph;
	}

	LinkedList<Vertex> topologicalSort() {
		LinkedList<Vertex> topsort = new LinkedList<>();

		for (int i = 0; i < graph.v; i++) {
			if (graph.vertex[i].color == 0)
				dfsVisit(graph.vertex[i], topsort);
		}
		return topsort;
	}

	void dfsVisit(Vertex u, LinkedList<Vertex> a) {
		u.color = 1;
		for (Vertex v : u.adj) {
			if (v.color == 0)
				dfsVisit(v, a);
		}
		u.color = 2;
		a.addFirst(u);
	}

	LinkedList<LinkedList<Vertex>> kosaraju() {
		LinkedList<LinkedList<Vertex>> scc = new LinkedList<LinkedList<Vertex>>();
		LinkedList<Vertex> order = topologicalSort();

		Graph t = graph.reverse();
		for (Vertex v : order) {
			int u = v.data;
			LinkedList<Vertex> new_scc = new LinkedList<>();

			if (t.vertex[u].color == 0)
				KosarajuVisit(t, u, new_scc);

			if (new_scc.size() > 0)
				scc.add(new_scc);
		}

		return scc;
	}

	void KosarajuVisit(Graph t, int u, LinkedList<Vertex> new_scc) {
		t.vertex[u].color = 1;
		new_scc.add(t.vertex[u]);
		for (Vertex v : t.vertex[u].adj) {
			if (v.color == 0)
				KosarajuVisit(t, v.data, new_scc);
		}
		t.vertex[u].color = 2;
	}
}