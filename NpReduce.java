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
    }

    public NpReduce() {
        io = new Kattio(System.in, System.out);

        numNodes = io.getInt();
        numEdges = io.getInt();
        numColors = io.getInt();

        initGraph();

        graph.printAsMovie(io, numColors);

        io.close();

    }

    public static void main(String[] args) {
        new NpReduce();
    }
}
