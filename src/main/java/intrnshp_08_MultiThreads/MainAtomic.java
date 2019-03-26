package intrnshp_08_MultiThreads;

// атомик переменные


import java.util.concurrent.atomic.AtomicInteger;

public class MainAtomic {

    static int i;
    static AtomicInteger iAtomic= new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 10_000; j++) {
            new MyThread().start();
        }
        Thread.sleep(1_000);
        System.out.println("  int i = " + i);
        System.out.println("iAtomic = " + iAtomic);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            i++;
            iAtomic.incrementAndGet();
        }
    }
}
