package intrnshp_09_SynchVsCuncurCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

// сравниваем скорость работы
// Collections.synchronizedList и CopyOnWriteArrayList

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // создаём коллекции
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

        // наполняем
        fillList(list1, 100);
        fillList(list2, 100);

        // запускаем замер скорости чтения
        System.out.println("List synchronized");
        checkList(list1);

        System.out.println();
        System.out.println("CopyOnWriteArrayList");
        checkList(list2);
    }

    private static void fillList(List<Integer> list, int i) {
        for (int j = 0; j < i; j++) {
            list.add(j);
        }
    }


    // двумя потоками ОДНОВРЕМЕННО начинаем делать get c одного и того же List но с разных ячеек
    private static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(
                new ListRunner(1, 50, list, latch));
        Future<Long> f2 = ex.submit(
                new ListRunner(51, 100, list, latch));
        latch.countDown(); // чтоб одновременно потоки стартанули

        System.out.println("Thread1: " + f1.get()/1000);
        System.out.println("Thread2: " + f2.get()/1000);
    }

    // замеряем время
    static class ListRunner implements Callable<Long> {

        int start;
        int end;
        List<Integer> list;
        CountDownLatch latch;

        public ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
            this.start = start;
            this.end = end;
            this.list = list;
            this.latch = latch;
        }

        public Long call() throws Exception {
            latch.await();

            long startTime = System.nanoTime();
            for (int i = start; i < end; i++) {
                list.get(i);
            }
            return System.nanoTime() - startTime;
        }
    }
}
