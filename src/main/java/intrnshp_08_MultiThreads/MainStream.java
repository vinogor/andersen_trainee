package intrnshp_08_MultiThreads;

import java.util.stream.IntStream;

public class MainStream {

    public static void main(String[] args) throws InterruptedException {
        parallel();


        Thread t = new Thread(
                () -> {
            parallel();
        }, "MyThread");

        t.start();
        t.join();

    }

    static void parallel() {
        int result = IntStream.range(0, 3)
                .parallel()  // распараллелили
                .peek(it -> System.out.printf("Thread [%s] peek: %d\n",
                        Thread.currentThread().getName(), it))
                .sum();
        System.out.println("sum: " + result);
    }



}
