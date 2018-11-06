import java.util.HashSet;
import java.util.Iterator;

public class Graph {

    int v; // num nodes
    int e; // num edges

    HashSet<Integer>[] edges;

    public Graph(int v) {
      this.v = v;
      this.e = 0;
      // Init edges
      edges = new HashSet[v];
      for (int i = 0; i < v; i++) {
        edges[i] = new HashSet<Integer>();
      }
    }

    // Adds an edge to node "from", to node "to".
    void addEdge(int from, int to) {
      if (!edges[from].contains(to)){
        edges[from].add(to);
        e++;
      }
    }

    // Prints all edges in the graph.
    void printEdges(Kattio io, int color) {

      io.println(v);
      io.println(e);
      io.println(color);

      for (int i = 0; i < v; i++) {
        Iterator<Integer> it = edges[i].iterator();

        while(it.hasNext()) {
            io.println(i + " " + it.next());
        }
      }
      io.flush();
    }

}
