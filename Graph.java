import java.util.HashSet;
import java.util.Iterator;

public class Graph {

    int numNodes;
    int numEdges;

    HashSet<Integer>[] edges;

    public Graph(int v) {

      this.numNodes = v;
      this.numEdges = 0;
      // Init edges
      edges = new HashSet[numNodes];
      for (int i = 1; i < numNodes; i++) {
        edges[i] = new HashSet<Integer>();
      }
    }

    // Adds an edge to node "from", to node "to".
    void addEdge(int from, int to) {
      if (!edges[from].contains(to)){
        edges[from].add(to);
        numEdges++;
      }
    }

    // Prints all edges in the graph.
    void printEdges(Kattio io, int color) {

      io.println(numNodes);
      io.println(numEdges);
      io.println(color);

      for (int i = 1; i < numNodes; i++) {
        Iterator<Integer> it = edges[i].iterator();

        while(it.hasNext()) {
            io.println(i + " " + it.next());
        }
      }
      io.flush();
    }

}
