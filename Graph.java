import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.LinkedList;

import java.lang.StringBuilder;

public class Graph {

    int numNodes;
    int numScenes;

    HashSet<Integer>[] edges;

    public Graph(int v) {

      this.numNodes = v;
      this.numScenes = 0;
      // Init edges
      edges = new HashSet[numNodes + 1];
      for (int i = 1; i <= numNodes; i++) {
        edges[i] = new HashSet<Integer>();
      }
    }

    // Adds an edge to node "from", to node "to".
    void addEdge(int from, int to) {
      if (!edges[from].contains(to)){
        edges[from].add(to);
        //edges[to].add(from);
      }
    }

    int dfs(int start, int[] path) {

      boolean[] visited = new boolean[numNodes + 1];

      Stack<Integer> queue = new Stack<Integer>();
      //start with first role and add to scene
      queue.push(start);
      int last = start;

      while(queue.size() != 0) {
        int u = queue.pop();

        if(!visited[u]) {
          visited[u] = true;
          if(!edges[u].isEmpty()) {
              Iterator<Integer> it = edges[u].iterator();
              while(it.hasNext()) {
                int v = it.next();

                if(!visited[v]) {
                    queue.push(v);
                    path[v] = u;
                    last = v;
                }

              }
          }
        }
      }
      return last;
    }

    int[] bfs(int start, int[] path) {

        boolean[] visited = new boolean[numNodes + 1];

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
                    path[v] = u;
                }
            }

        }
        return path;
    }

    String printPath(int start, int[] path) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(start);
        for(int v = start; v != 0; v = path[v]) {
            if(path[v] != 0) {
                sb.append(" " + path[v]);
                count++;
            }
        }
        sb.insert(0, count + " ");
        if(count > 1) {
            System.err.println("Count " + count);
            numScenes++;
            sb.append("\n");
            return sb.toString();
        }
        return "";
    }

    // Prints all edges in the graph.
    void printAsMovie(Kattio io, int color) {

      io.println(numNodes);
      StringBuilder sb = new StringBuilder();
      sb.append(color + "\n");
      //printa roller
      for(int i = 0; i < numNodes; i++) {
          sb.append("2 1 2\n");
      }

      //printa scener
      for (int i = 1; i <= numNodes; i++) {
          int[] path = new int[numNodes + 1];
          int last = dfs(i, path);
          sb.append(printPath(last, path));
      }
      sb.insert(0, numScenes + "\n");
      io.println(sb.toString());
      io.flush();
    }

    void printEasy(Kattio io, int color, int numEdges) {

        io.println(numNodes);
        io.println(numEdges);
        io.println((color + 1));

        for(int i = 0; i < numNodes; i++) {
            StringBuilder sb = new StringBuilder();
            int count = numNodes - i;
            sb.append(count);

            for(int j = i +1; j <= numNodes; j++) {
                sb.append(" " + j);
            }
            io.println(sb.toString());
        }

        for(int i = 1; i <= numNodes; i++) {
            Iterator<Integer> it = edges[i].iterator();
            while(it.hasNext()) {
                int v = it.next();
                io.println("2 " + i + " " + v);
            }
        }
        io.flush();
    }

}
