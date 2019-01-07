import java.util.LinkedList;

class BreathFirstSearch{
    Graph graph;

    BreathFirstSearch(Graph graph){
        this.graph = graph;
    }

    void bfs(int start){

        graph.vertex[start].distance = 0;
        graph.vertex[start].parent = null;

        LinkedList<Vertex> queue = new LinkedList<>();

        queue.add(graph.vertex[start]);

        while(!queue.isEmpty()){
            Vertex u = queue.removeFirst();
            u.color = 1;
            for(Vertex v: u.adj){
                if(v.color == 0){
                    v.color = 1;
                    v.parent = u;
                    v.distance = u.distance + 1;
                    queue.add(v);
                }
            }
            u.color = 2;
        }


    }
}