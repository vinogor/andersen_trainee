package intrnshp_08_MultiThreads;

public class Main2 {

    public static void main(String[] args) {

        try {
            startSomeThreads(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startSomeThreads(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new ThreadImplRunnable());
            thread.start();
//            при join запуск нового потока будет только после завершения предыдущего
            thread.join(600);

        }
    }
}
