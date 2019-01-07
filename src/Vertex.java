import java.util.LinkedList;

class Vertex{
    int data;
    int color;
    int distance;
    Vertex parent;
    LinkedList<Vertex> adj;
    boolean extracted;

    Vertex(int data){
        this.data = data;
        color = 0;
        distance = -1;
        parent = null;
        adj = new LinkedList<>();
        extracted = false;
    }
}
