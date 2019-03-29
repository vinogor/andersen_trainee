package intrnshp_08_MultiThreads;

import java.util.concurrent.Callable;

public class ThreadImplCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Привет из Callable потока!");
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(500);
//        }

//        byte a = 5;
//        byte b = 5;
//        byte res = a + b;

        return 1000;
    }
}
