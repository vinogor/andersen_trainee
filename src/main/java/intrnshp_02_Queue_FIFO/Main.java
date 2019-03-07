package main.java.intrnshp_02_Queue_FIFO;

public class Main {
    public static void main(String[] args) {
        QueueFifo queueFifo = new QueueFifo(4);
        queueFifo.add("111");
        queueFifo.print();
        queueFifo.add("222");
        queueFifo.add("333");
        queueFifo.add("444");
        queueFifo.print();

        queueFifo.add("555");
        System.out.println("Available " + queueFifo.getAvailableItems() + " items");
        System.out.println("First in queue: " + queueFifo.get());

        queueFifo.del();
        queueFifo.print();
        queueFifo.del();
        queueFifo.print();
        System.out.println("Available " + queueFifo.getAvailableItems() + " items");

        System.out.println("Capacity of queue " + queueFifo.getCapacity());
        System.out.println("First in queue: " + queueFifo.get());

        queueFifo.fromBeginToEnd();
        queueFifo.print();
        queueFifo.add("qwe");
        queueFifo.print();
        queueFifo.fromBeginToEnd();
        queueFifo.print();
    }
}
