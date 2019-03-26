package intrnshp_08_MultiThreads;

// wait, notify, notifyAll
// нужно быть synchronized на одно и том же объекте чтобы заработало
//

public class MainWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Thread_A thread_a = new Thread_A();
        thread_a.start();

        synchronized (thread_a) {
            thread_a.wait(); // типо ждёт сигнала от thread_a ??
            // отправляет ТЕКУЩИЙ поток (main) в сон, пока другой поток не вызовет его
            // через notify / notifyAll
            // Текущий поток (main) должен владеть монитором ??этого объекта?? (thread_a)
        }
        System.out.println(thread_a.total);
    }

    static class Thread_A extends Thread {
        int total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify(); // "уведомить"
                // просыпается поток (рандомный если их несколько),
                // ожидающий на мониторе этого объекта
                //
            }
        }
    }
}
