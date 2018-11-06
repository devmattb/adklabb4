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
  Kattio io = new Kattio();

  public ReduceRoleproblem(){

  }

  public static void main(String[] args) {

    io = new Kattio(System.in, System.out);


    n = io.getInt();
    s = io.getInt();
    k = io.getInt();

    for (int i = 0; i < n; i++) {
       io.getInt()
    }

    for (int i = 0; i < s; i++) {
       io.getInt()
    }
  }

}
