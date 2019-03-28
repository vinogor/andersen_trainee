package intrnshp_08_MultiThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainScheduledExServ {

    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.schedule(new MyThread(), 3, TimeUnit.SECONDS);

    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Поток " + Thread.currentThread().getName() + " начал работать");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток " + Thread.currentThread().getName() + " завершён");
        }
    }
}
