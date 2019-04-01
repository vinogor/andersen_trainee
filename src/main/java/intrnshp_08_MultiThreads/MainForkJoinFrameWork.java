package intrnshp_08_MultiThreads;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MainForkJoinFrameWork {

    static long numOfOperations = 1_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();
//    static int numOfThreads = 8;

    public static void main(String[] args) {

        System.out.println("Делаем " + numOfOperations + " операций");
        System.out.println("В налиции " + numOfThreads + " ядер");

// по простому 760 - 820 мс
        System.out.println("Запустим всё в 1 потоке");
        Date date1 = new Date();
        long j = 0;
        for (int i = 0; i < numOfOperations; i++) {
            j += i;
        }
        System.out.println("Результат: " + j);
        Date date2 = new Date();
        System.out.println(numOfOperations + " операций выполнено за " + (date2.getTime() - date1.getTime()) + " мс");


        // пул потоков позволяющий разделять 1 задачу на несоколько частей по потокам
        System.out.println("Запустим всё на 8 потоках");
        Date date3 = new Date();
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        Long invoke = pool.invoke(new MyFork(0, numOfOperations));
        System.out.println("Результат: " + invoke);
        Date date4 = new Date();
        System.out.println(numOfOperations + " операций выполнено за " + (date4.getTime() - date3.getTime()) + " мс");

    }

    static class MyFork extends RecursiveTask<Long> {

        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // если операция разбита на достаточное кол-во частей, тогда
            if ((to - from) <= (numOfOperations / numOfThreads)) {
                // код основной работы
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
                // иначе разбиваем на части по меньше
            } else {
                long mid = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, mid);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(mid, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
