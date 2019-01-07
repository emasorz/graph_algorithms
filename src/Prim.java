class Prim {
	Graph graph;
	int cost;

	Prim(Graph graph) {
		this.graph = graph;
		cost = 0;
	}

	void inizialize() {
		for (Vertex v : graph.vertex) {
			v.distance = Integer.MAX_VALUE;
			v.parent = null;
			v.extracted = false;
		}
	}

	void prim(int start) {
		graph.vertex[start].distance = 0;
		int u = extractMin();

		while (u != -1) {
			cost += graph.vertex[u].distance;

			for (Vertex v : graph.vertex[u].adj) {
				if (!v.extracted && graph.weight[u][v.data] < v.distance) {
					v.distance = graph.weight[u][v.data];
					v.parent = graph.vertex[u];
				}
			}

			u = extractMin();
		}
	}

	int extractMin(){
        int index = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < graph.v; i++){
            if(!graph.vertex[i].extracted && graph.vertex[i].distance < min){
                index = i;
                min = graph.vertex[i].distance;
            }
        }

        if(index != -1){
            graph.vertex[index].extracted = true;
        }

        return index;
    }
}