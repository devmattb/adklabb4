import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Graph {

    int numNodes;
    int numEdges;

    HashSet<Integer>[] edges;

    public Graph(int v) {

      this.numNodes = v;
      this.numEdges = 0;
      // Init edges
      edges = new HashSet[numNodes + 1];
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
    void printAsMovie(Kattio io, int color) {

      io.println(numNodes);
      io.println(numEdges);
      io.println(color);

      Random rand = new Random();

      for(int i = 0; i < numNodes; i++) {
          io.println("1 " + (rand.nextInt(numNodes) + 1));
      }

      for (int i = 1; i < numNodes; i++) {
        Iterator<Integer> it = edges[i].iterator();

        while(it.hasNext()) {
            io.println("2 " + i + " " + it.next());
        }
      }
      io.flush();
    }

}
