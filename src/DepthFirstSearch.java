
public class DepthFirstSearch {

	Graph graph;

	DepthFirstSearch(Graph graph){
	        this.graph = graph;
	    }

	void dfs() {
		for (Vertex v : graph.vertex)
			if (v.color == 0)
				dfsVisit(v);
	}

	void dfsVisit(Vertex u){
	        u.color = 1;
	        for(Vertex v : u.adj){
	            if(v.color == 0){
	                v.parent = u;
	                v.distance = u.distance + 1;
	                dfsVisit(v);
	            }
	        }
	        u.color = 2;
	    }
}
