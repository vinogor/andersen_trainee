package intrnshp_08_MultiThreads;

public class MainLambdaThread {

    // https://javarush.ru/groups/posts/264-populjarno-o-ljambda-vihrazhenijakh-v-java-s-primerami-i-zadachami-chastjh-1-

    public static void main(String[] args) {

        // запустим поток по обчному
        Thread thread = new Thread(new MyLambdaThread());
        thread.start();

        // а теперь созадим и запустим поток через Лямбду
        //  ( параметры ) ->
        //      {
        //          тело метода
        //      }
        Thread thread2 = new Thread(() -> {
            System.out.println("Этот поток запущен через ЛЯМБДУ!");
        });
        thread2.start();

        // или даже вот так вот
        Runnable runnable = () -> System.out.println("Hello world!");
        Thread t = new Thread(runnable);
        t.start();



    }

    static class MyLambdaThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Привет!");
        }
    }
}
