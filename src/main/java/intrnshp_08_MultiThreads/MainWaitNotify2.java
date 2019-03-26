package intrnshp_08_MultiThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainWaitNotify2 {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        new Operator().start();
        new Machine().start();
    }

    static class Operator extends Thread {
        @Override
        public void run() {
            System.out.println("Запустился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
            Scanner sc = new Scanner(System.in);
            while (true) {
                synchronized (strings) {
                    System.out.println("Поток " + Thread.currentThread().getName() + " просит ввести что-нибудь: ");
                    String e = sc.nextLine();
                    strings.add(e);
                    System.out.println("Поток " + Thread.currentThread().getName() + " пробуждает поток ждущий на мониторе");
                    strings.notify();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine extends Thread {
        @Override
        public void run() {
            System.out.println("Запустился поток Name = " + Thread.currentThread().getName() + "; id = " + Thread.currentThread().getId());
            while (strings.isEmpty()) {
                synchronized (strings) {
                    try {
                        System.out.println("Поток " + Thread.currentThread().getName() + " переходит в состояние ожидания вызова");
                        strings.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Поток " + Thread.currentThread().getName() + " выводит " +  strings.remove(0));
                }
            }
        }
    }
}
