/**
*
*   Reduces a role problem based of the input instructions on Canvas,
*   to a graph where:
*
*   1) Nodes represent different roles.
*
*   2) Edges are set between roles that are in the same scene.
*
*   3) Colors represent actors when coloring the graph, which generates a solution.
*      However, we are only to reduce the problem, not solve it.
*
**/
public class ReduceRoleproblem {

  int n; // number of roles
  int s; // number of scenes
  int k; // number of actors
  Graph graph;
  Kattio io;

  public ReduceRoleproblem(){

        io = new Kattio(System.in, System.out);

        n = io.getInt();
        s = io.getInt();
        k = io.getInt();

        graph = new Graph(n);

        // Nodes.
        for (int i = 0; i < n; i++) {
          // skip these
          int count = io.getInt();
          for (int j = 0; j < count; j++) {io.getInt();}
        }

        // Edges
        for (int i = 0; i < s; i++) {
           int count = io.getInt();
           int[] arr = new int[count];

           // Store all the roles in this scene.
           for (int j = 0; j < count; j++) {
             arr[j] = io.getInt();
           }

           // Create edges between all of the roles in the same scene.
           for (int j = 0; j < count; j++) {
             for (int k = j+1; k < count; k++) {
               graph.addEdge(arr[j], arr[k]);
             }
           }
        }

        graph.printEdges(io, k);
  }

  public static void main(String[] args) {
    new ReduceRoleproblem();
  }

}
