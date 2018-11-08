import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.LinkedList;

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

    void dfs(int start) {

      boolean[] visited = new boolean[numNodes + 1];
      int[] path = new int[numNodes + 1];

      Stack<Integer> queue = new Stack<Integer>();
      //start with first role and add to scene
      queue.push(start);

      while(queue.size() != 0) {
        int u = queue.pop();

        if(!visited[u]) {
          visited[u] = true;
          Iterator<Integer> it = edges[u].iterator();
          while(it.hasNext()) {
            int v = it.next();
            queue.push(v);
            path[v] = u;
          }
        }
      }
    }

    void bfs(int start) {

        boolean[] visited = new boolean[numNodes + 1];
        int[] path = new int[numNodes + 1];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(start);
        visited[start] = true;

        while(queue.size() != 0) {
            int u = queue.pop();
            Iterator<Integer> it = edges[u].iterator();
            while(it.hasNext()) {
                int v = it.next();
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    path[u] = v;
                }
            }

        }
    }

    // Prints all edges in the graph.
    void printAsMovie(Kattio io, int color) {

      io.println(numNodes);
      io.println(numEdges); //TODO: antal scener
      io.println(color);

      //printa roller
      for(int i = 0; i < numNodes; i++) {
          io.println("2 1 2");
      }

      //printa scener
      for (int i = 1; i < numNodes; i++) {
        Iterator<Integer> it = edges[i].iterator();

        while(it.hasNext()) {
            io.println("2 " + i + " " + it.next());
        }
      }
      io.flush();
    }

}
