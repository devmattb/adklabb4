public class NpReduce {

    Kattio io;

    Graph graph;

    int numNodes;
    int numEdges;
    int numColors;

    void initGraph() {

        graph = new Graph(numNodes);

        //read all edges
        while(io.hasMoreTokens()) {
            int u = io.getInt();
            int v = io.getInt();

            graph.addEdge(u,v);
        }

        //specialfall 0 kanter
        if(numEdges == 0) {
          graph.addEdge(1, 2);
        }
    }

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

    public NpReduce() {
        io = new Kattio(System.in, System.out);

        numNodes = io.getInt();
        numEdges = io.getInt();
        numColors = io.getInt();

        if(numEdges == 0) {
            printMinimalYes();
        }

        initGraph();

        graph.printEasy(io, numColors, numEdges);

        io.close();

    }

    public static void main(String[] args) {
        new NpReduce();
    }
}
