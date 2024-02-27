public class App {
    public static void main(String[] args) throws Exception {

        int numPhilosophers = 5;
        for (int i = 0; i < numPhilosophers; i++) {
            new Thread(new Philosopher(i), "Philosopher " + i).start();
        }
    }
}
