class Graph{

    int v;
    Vertex[] vertex;
    int[][] weight;

    Graph(int v){
        this.v = v;
        vertex = new Vertex[v];

        for(int i = 0; i < v; i++)
            vertex[i] = new Vertex(i);

        weight = new int[v][v];
    }

    //aggiunta arco
    void addEdge(int u, int v){
        vertex[u].adj.add(vertex[v]);
    }

    //aggiunata arco con peso
    void addEge(int u, int v, int w){
        vertex[u].adj.add(vertex[v]);
        weight[u][v] = w;
    }

    Graph reverse(){
        Graph t = new Graph(v);

        for(Vertex u: vertex){
            for(Vertex v: u.adj){
                t.addEdge(v.data,u.data);
            }
        }

        return t;
    }
}