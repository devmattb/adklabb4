public class NpReduce {

    Kattio io;

    int numNodes;
    int numEdges;
    int numColors;

    void printMinimalYes() {
    io.println("3");
    io.println("2");
    io.println("3");
    io.println("1 1");
    io.println("1 2");
    io.println("1 3");
    io.println("2 1 3");
    io.println("2 2 3");
     io.flush();
    io.close();
    System.exit(0);
 }


    void print() {


        // Add two "diva roles" to the film.
        int roles = numNodes + 2;
        // Add edges (scenes) between all roles and each diva.
        // Don't add an edge (scene) between the divas.
        // This sums up to an additional 2*|V| edges.
        int scenes = numEdges + 2*(numNodes);
        // Since we added two "diva roles", we need to add two "diva actors" aswell.
        int actors = numColors + 2;


        io.println(roles);
        io.println(scenes);
        io.println(actors);

        io.println("1 1"); //diva 1
        io.println("1 2"); //diva 2

        StringBuilder sb = new StringBuilder();
        sb.append(actors - 2);

        //ri = {1,2,...,k}
        for (int j = 3;j <= actors; j++ ) {
            sb.append(" " + j);
        }

        String currActors = sb.toString();

        for(int i = 3; i <= roles; i++) {
            io.println(currActors);
        }

      //Anse att vi har en scen med diva 1 resp. 2 med alla andra roller
        for(int j = 3; j <= roles; j++) {
            io.println("2 1 " + j);
            io.println("2 2 " + j);
        }

        int u,v;

        for(int i = 0; i < numEdges; i++) {
            u = io.getInt() + 2; //Have to increase index by 2
            v = io.getInt() + 2; //Since we added the 2 divas

            io.println("2 "+ u + " " + v);

        }

        io.close();
    }
    public NpReduce() {
        io = new Kattio(System.in, System.out);

        this.numNodes = io.getInt();
        this.numEdges = io.getInt();
        this.numColors = io.getInt();

        if(numColors >= numNodes) {
          printMinimalYes();
        }

        print();
    }

    public static void main(String[] args) {
        new NpReduce();
    }
}
