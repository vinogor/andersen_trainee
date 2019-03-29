package intrnshp_08_MultiThreads;

public class ThreadImplRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Class ThreadImplRunnable, method run() started...  ID = " + Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Class ThreadImplRunnable, method run() finished... ID = " + Thread.currentThread().getId());
    }
}
