package intrnshp_08_MultiThreads;

public class ThreadImplRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Class ThreadImplRunnable, method run() started... " + Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class ThreadImplRunnable, method run() finished... " + Thread.currentThread().getId());
    }
}
