package main.java.intrnshp_02_Queue_FIFO;

public class QueueFifo {

    private int capacity;
    private int availableItems = 0;
    private String[] queueFifo;

    public QueueFifo(int capacity) {
        this.capacity = capacity;
        queueFifo = new String[capacity];
    }

    public void add(String s) {
        if (isFull()) {
            System.out.println("ERROR: queue overflowed");
        } else {
            System.arraycopy(queueFifo, 0, queueFifo, 1, availableItems);
            queueFifo[0] = s;
            availableItems++;
        }
    }

    public void del() {
        if (isEmpty()) {
            System.out.println("ERROR: queue is empty");
        }
        availableItems--;
        queueFifo[availableItems] = null;
    }

    public String get(){
        if (isEmpty()) {
            System.out.println("ERROR: queue is empty");
            return null;
        }
        return queueFifo[availableItems-1];
    }

    public void fromBeginToEnd() {
        String buff = get();
        del();
        add(buff);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void print() {
        System.out.print("| ");
        for (int i = 0; i < capacity; i++) {
            System.out.print(queueFifo[i] + " | ");
        }
        System.out.println();
    }

    private boolean isFull() {
        return availableItems == capacity;
    }

    private boolean isEmpty() {
        return availableItems == 0;
    }
}
