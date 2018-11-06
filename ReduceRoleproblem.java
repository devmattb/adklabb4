/**
*
*   Reduces a role problem based of the input instructions on Canvas,
*   to a graph where:
*
*   1) Nodes represent different roles.
*
*   2) Edges are set between roles that are in the same scene.
*
*   3) numColorss represent actors when numColorsing the graph, which generates a solution.
*      However, we are only to reduce the problem, not solve it.
*
**/
public class ReduceRoleproblem {

  int numRoles;
  int numScenes;
  int numColors; //number of Actors
  Graph graph;
  Kattio io;

  void printSpecial() {

      io.println(1);
      io.println(0);
      io.println(numColors);
      io.flush();
      System.exit(0);
  }

  void initGraph() {

      graph = new Graph(numRoles);

      // Nodes.
      for (int i = 0; i < numRoles; i++) {
        // skip these
        int count = io.getInt();
        for (int j = 0; j < count; j++) {io.getInt();}
      }

      // Edges
      for (int i = 0; i < numScenes; i++) {
         int count = io.getInt();

         //System.err.println("count " + count);
         int[] arr = new int[count];

         // Store all the roles in this scene.
         for (int j = 0; j < count; j++) {
           arr[j] = io.getInt();
         }
         if(count > numRoles) {
             count = numRoles;
         }

         // Create edges between all of the roles in the same scene.
         for (int j = 0; j < count; j++) {
           for (int k = j+1; k < count; k++) {

             graph.addEdge(arr[j], arr[k]);
           }
         }

      }
  }

  public ReduceRoleproblem(){

        io = new Kattio(System.in, System.out);

        numRoles = io.getInt();
        numScenes = io.getInt();
        numColors = io.getInt();

        if(numRoles < 1 || numScenes < 1 || numColors < 2) {
            io.println(0);
            io.println(0);
            io.println(numColors);
            io.flush();
            System.exit(0);
        }

        if(numRoles == 1) {
            printSpecial();
        }

        initGraph();


        graph.printEdges(io, numColors);
        System.exit(0);

  }

  public static void main(String[] args) {
    new ReduceRoleproblem();
  }

}
