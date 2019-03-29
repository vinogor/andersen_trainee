package intrnshp_08_MultiThreads;

public class ThreadExtendsThread extends Thread {
    @Override
    public void run() {
//        super.run();
        System.out.println("Привет из потока класса ThreadExtendsThread !");
    }
}
