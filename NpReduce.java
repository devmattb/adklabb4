public class NpReduce {

    Kattio io;

    int numNodes;
    int numEdges;
    int numColors;

    void print() {

        int roles = numNodes + 2;
        int scenes = numEdges + 2*numNodes;
        int actors = numColors + 2;

        io.println(roles);
        io.println(scenes);
        io.println(actors);

        io.println("1 1"); //diva 1
        io.println("1 2"); //diva 2

        StringBuilder sb = new StringBuilder();
        sb.append(actors);
        //ri = {1,2,...,k,k+1}
        for (int j = 3;j <= actors; j++ ) {
            sb.append(" " + j);
        }

        for(int i = 3; i <= roles; i++) {

            io.println(sb.toString());
        }

        //Anse att vi har en scen med diva 1 resp. 2 med alla andra roller
        for(int i = 1; i <= 2; i++) {
            for(int j = 3; j <= roles; j++) {
                io.println("2 " + i + " " + j);
            }
        }

        for(int i = 0; i < numEdges; i++) {
            int u = io.getInt() + 2;
            int v = io.getInt() + 2;

            io.println("2 "+ u + " " + v);
        }
        
        io.close();
    }
    public NpReduce() {
        io = new Kattio(System.in, System.out);

        numNodes = io.getInt();
        numEdges = io.getInt();
        numColors = io.getInt();

        print();
    }

    public static void main(String[] args) {
        new NpReduce();
    }
}
