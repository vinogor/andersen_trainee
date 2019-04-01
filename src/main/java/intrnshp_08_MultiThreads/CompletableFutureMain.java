package intrnshp_08_MultiThreads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        String s = completableFuture.get();
//        completableFuture.complete("Future's Result");


//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
//        String s1 = future.get();
//        System.out.println(s1);

        // Запуск отдельного параллельного потока, асинхронно, БЕЗ получения результата
        System.out.println("== 1 Запуск отдельного параллельного потока, асинхронно, БЕЗ получения результата ==");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Привет из отдельного потока! Его имя " + Thread.currentThread().getName());
        });

        // основной поток блокируется до получения результата от future
        // но результат void, поэтому просто ждём окончания работы
        // Если не сделать .get() то на экран ничего не выйдет т.к. main завершиться раньше
        // Thread.sleep(10000);
        future.get();
        System.out.println();

// =============================

        // Запуск отдельного параллельного потока, асинхронно, C получением результата

        System.out.println("== 2 Запуск отдельного параллельного потока, асинхронно, C получением результата ==");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Результат асинхронных вычислений";
        });
        String result = future2.get();
        System.out.println(result);
        System.out.println();

// =============================

        // Запускаем поток, вычисляем и не блокируя передаём результат дальше
        // причём это несколько задач в рамках ОДНОГО не основного потока

        // то куда передаётся результат операций - называется callback функцией
        // если она должна передать результат дальше, то юзаем .thenApply()
        // можно делать целые цепочки

        System.out.println("== 3 Запускаем поток, вычисляем и не прерывая передаём результат дальше ==");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("future 3 | Сейчас работает поток " + Thread.currentThread().getName());
            return "Результат вычислений";
        });

        // после того как выполнится future3, передаём результат в future4

        CompletableFuture<String> future4 = future3.thenApply(formerResult -> {
            System.out.println("future 4 | Сейчас работает поток " + Thread.currentThread().getName());
            return "[Вот это мы прибавили к] " + formerResult;
        });
        System.out.println(Thread.currentThread().getName() + " всё работает");

        // вот тут уже блокируем и ждём результата
        System.out.println(Thread.currentThread().getName() + " " + future4.get());
        System.out.println();
// =============================


        // если callback функция не должна отдавать результат, то юзаем
        // thenRun() и thenAccept()
        // thenAccept() - получает результат предыдущей задачи
        // thenRun() - НЕ получает результат предыдущей задачи

        System.out.println("== 4 Запускаем поток, вычисляем и не прерывая передаём результат дальше \n" +
                " а там уже ничего не возвращаем, последнее выполняется в main потоке ==");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("первая задача, поток " + Thread.currentThread().getName());
            return "[результат первой задачи]";
//        }).thenAccept(product -> {
        }).thenAccept(product -> {
            System.out.println("вторая задача, поток " + Thread.currentThread().getName());
            System.out.println("[результат второй задачи] это длина букв результата первой задачи " + product.length());
        }).thenRun(() -> {
            System.out.println("третья задача, поток " + Thread.currentThread().getName());
            System.out.println("возвращать нечего ");
        });
        System.out.println();

// =============================

        // thenCombine() для двух независимых друг от друга CompletableFutures

        System.out.println("== 5 Запускаем  ==");

        System.out.println("Вычисялем вес...");
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("    вычисяем вес, поток " + Thread.currentThread().getName());
            return 65.0;
        });
        System.out.println("Вычисляем рост...");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("    вычисяем рост, поток " + Thread.currentThread().getName());
            return 169.5;
        });

        System.out.println("Вычисляем  Индекс Массы Тела");
        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    System.out.println("    вычисяем ИМТ, поток " + Thread.currentThread().getName());
                    Double heightInMeter = heightInCm / 100;
                    return weightInKg/(heightInMeter * heightInMeter);
                });
        System.out.println("Ваш индекс массы тела - " + combinedFuture.get());

        System.out.println();

    }
}
