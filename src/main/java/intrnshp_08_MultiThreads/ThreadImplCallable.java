package intrnshp_08_MultiThreads;

import java.util.concurrent.Callable;

public class ThreadImplCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Привет из Callable потока!");
        return 100;
    }
}
