package intrnshp_08_MultiThreads;

// волшебное слово volatile
// применяется когда 2 потока юзают переменную из 3го потока
//    - без volatile - переменная копируется и потоки с ней работают не записывая обратно
//    - с volatile - любое изменение записывается

public class MainVolatile {

    static volatile int i; // вот тут происходит сильная магия с volatile

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();

    }

    static class MyThreadWrite extends Thread{
        @Override
        public void run() {
            System.out.println("Запустился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
            while (i < 5) {
                System.out.println("    поток " + Thread.currentThread().getName() + " increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Завершился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
        }
    }
    static class MyThreadRead extends Thread{
        @Override
        public void run() {
            System.out.println("Запустился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
            int localvar = i;
            while (localvar < 5) {
                // второй поток может изменить i и тогда:
                if (localvar != i) {
                    System.out.println("    поток " + Thread.currentThread().getName() + " new value of i is: " + i);
                    localvar = i;
                }

            }
            System.out.println("Завершился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
        }
    }
}
