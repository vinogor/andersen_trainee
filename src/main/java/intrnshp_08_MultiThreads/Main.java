package intrnshp_08_MultiThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {

        // 1й способ -
        // имплементим Раннабл к классу, там определяем метод run()
        // и его объект отправляем в конструктор Thread
        // запускаем поток методом start()

        System.out.println("=== ПЕРВЫЙ СПОСОБ ч1 ===");
        Thread t1 = new Thread(new ThreadImplRunnable());
        t1.start(); // поток 1 запустился
        Thread.sleep(2000); // задержка чтоб успел доделаться способ
        System.out.println();

        // можно через анонимный класс не создавая лишних сущностей (редко юзают)
        System.out.println("=== ПЕРВЫЙ СПОСОБ ч2 ===");
        Thread t1_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Этот поток создали через реализацию Runnable в анонимном классе");
            }
        });
        t1_2.start();
        Thread.sleep(2000); // задержка чтоб успел доделаться способ
        System.out.println();


        // 2й способ - экстенлиться от Thread и переопределить run()
        // создать объект класса и запустить методом start()
        //
        System.out.println("=== ВТОРОЙ СПОСОБ ===");
        Thread t2 = new ThreadExtendsThread();
        t2.start();
        Thread.sleep(2000); // задержка чтоб успел доделаться способ
        System.out.println();


        // 3й способ - через реализацию Callable
        // это как Runnable только ещё может возвращать результат
        // и можно юзать дженерики

        System.out.println("=== ТРЕТИЙ СПОСОБ ===");
        Callable<Integer> callable = new ThreadImplCallable();
        Integer call = callable.call();
        System.out.println("метод call() возвратил: " + call);
        Thread.sleep(2000); // задержка чтоб успел доделаться способ
        System.out.println();

        // ПУЛ ПОТОКОВ:

        System.out.println("=== РАБОТА С ПУЛОМ ПОТОКОВ ===");

        // создание пула с не более 5 работающих одновремнно потоков, но закач может быть сколь угодно
        // если поток освободится  - он возьмёт следующую задачу
        ExecutorService es = Executors.newFixedThreadPool(5);

        // просто запуск задачи, так можно только с Runnable
        es.execute(new ThreadImplRunnable());
        Thread.sleep(2000);
        System.out.println();

        // запуск задачи, при этом возвращается объект типа Future
        Future subRun = es.submit(new ThreadImplRunnable());
        Future<Integer> subCall = es.submit(new ThreadImplCallable());

        // благодаря чему теперь можно узнавать состояние задачи - завершилась ли, получить результат и т.п.
        subRun.get(); // будет стоять пока не завершится задача, ничего не возвращает

        Integer num = subCall.get(); // по завершению возвращает результат
        System.out.println("Callable method return: " + num);


//      заверщить работу пула
        es.shutdown();

    }
}
