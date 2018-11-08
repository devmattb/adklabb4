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
    int findChromaticNumber() {

        int chromatic = 0;

        for(int i = 1; i <= numNodes; i++) {
            Iterator<Integer> it = edges[i].iterator();
            int valens = 0;
            while(it.hasNext()) {
                it.next();
                valens++;
            }
            chromatic = Math.max(chromatic, valens);
        }

        return chromatic;
    }

    void printAlwaysYes(Kattio io, int numEdges, int color) {

        io.println(numNodes);
        io.println(numEdges);
        io.println(color + 1);

        //printa roller
        for(int i = 1; i <= numNodes; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(numNodes);
            for(int j = 1; j <= numNodes; j++) {
                sb.append(" " + j);
            }
            io.println(sb.toString());
        }

        for(int i = 1; i<= numNodes; i++) {
            Iterator<Integer> it = edges[i].iterator();
            while(it.hasNext()) {
                int v = it.next();
                io.println("2 " + i + " " + v);
            }
        }
        io.flush();

    }

    void printAlwaysNo(Kattio io,int numEdges, int color) {

        io.println(numNodes);
        io.println(numEdges);
        io.println(color + 1);

        for(int i = 1; i <= numNodes; i++) {
            io.println("2 1 2");
        }

        for(int i = 1; i<= numNodes; i++) {
            Iterator<Integer> it = edges[i].iterator();
            while(it.hasNext()) {
                int v = it.next();
                io.println("2 " + i + " " + v);
            }
        }
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
