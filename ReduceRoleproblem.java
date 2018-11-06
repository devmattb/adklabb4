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

  public ReduceRoleproblem(){

  }

  public static void main(String[] args) {

    n = args[0];
    s = args[1];
    k = args[2];

    for (int i = 2; i < args.length; i++) {
            System.out.println(args[i]);
    }
  }

}
