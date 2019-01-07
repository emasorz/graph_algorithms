import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		if(args.length == 0) {
			System.out.println("Nessun percorso file in input");
			System.exit(0);
		}
		
		Scanner in = new Scanner(new FileReader(args[0]));
		
		int dim = in.nextInt();
		
		Graph graph = new Graph(dim);
		
		while(in.hasNextInt()) {
			int u = in.nextInt();
			int v = in.nextInt();
			
			graph.addEdge(u, v);
		}
		
		in.close();
		
		
		Kosaraju resolver = new Kosaraju(graph);
		LinkedList<LinkedList<Vertex>> scc = resolver.kosaraju();
		for(LinkedList<Vertex> a : scc) {
			for(Vertex v: a) {
				System.out.print(v.data + " ");
			}
			System.out.println(" ");
		}
	}
}
