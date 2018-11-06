public class NewReduceShit {


    Kattio io;

    public NewReduceShit() {
        io = new Kattio(System.in, System.out);
        int numRoles = io.getInt();
        int numScenes = io.getInt();
        int numActors = io.getInt();

        for(int i = 0; i < numRoles; i++) {
            int count = io.getInt();
            for(int j = 0; j < count; j++) {
                int x = io.getInt();
            }
        }

        for(int i = 0; i < numScenes; i++) {
            int count = io.getInt();
            for(int j = 0; j < count; j++) {
                int x = io.getInt();
            }
        }
        io.println(numRoles);
        io.flush();
        io.close();
    }

    public static void main(String[] args) {
        new NewReduceShit();
    }
}
