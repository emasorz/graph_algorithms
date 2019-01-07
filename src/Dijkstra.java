class Dijkstra {
	Graph graph;

	Dijkstra(Graph graph) {
		this.graph = graph;
	}

	void relax(int u, int v, int w) {
		if (graph.vertex[v].distance > graph.vertex[u].distance + w) {
			graph.vertex[v].distance = graph.vertex[u].distance + w;
			graph.vertex[v].parent = graph.vertex[u];
		}
	}
	
	 void inizialize(){
	        for(Vertex v : graph.vertex){
	            v.distance = Integer.MAX_VALUE;
	            v.parent = null;
	            v.extracted = false;
	        }
	    }

	void dijkstra(int start) {
		inizialize();
		graph.vertex[start].distance = 0;

		int u = extractMin();

		while (u != -1) {
			for (Vertex v : graph.vertex[u].adj) {
				relax(u, v.data, graph.weight[u][v.data]);
			}
			u = extractMin();
		}

	}

	int extractMin() {
		int index = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < graph.v; i++) {
			if (!graph.vertex[i].extracted && graph.vertex[i].distance < min) {
				index = i;
				min = graph.vertex[i].distance;
			}
		}

		if (index != -1) {
			graph.vertex[index].extracted = true;
		}

		return index;
	}
}