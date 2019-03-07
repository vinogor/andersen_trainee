package intrnshp_02_Queue_FIFO;

public class QueueFifo<T> {

    private int capacity;
    private int availableItems = 0;
    private T[] queueFifo;

    public QueueFifo(int capacity) {
        this.capacity = capacity;
        queueFifo = (T[]) new Object[capacity];
    }

    public void add(T s) throws IllegalArgumentException {
        checkNull(s);
        if (isFull()) {
            throw new RuntimeException("ERROR: queue already full");
        } else if (isEmpty()) {
            queueFifo[0] = s;
            availableItems++;
        } else {
            System.arraycopy(queueFifo, 0, queueFifo, 1, availableItems);
            queueFifo[0] = s;
            availableItems++;
        }
    }

    public void del() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: queue already full");
        }
        availableItems--;
        queueFifo[availableItems] = null;
    }

    public T get() {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: queue is empty");
        }
        return queueFifo[availableItems - 1];
    }

    public void fromBeginToEnd() {
        T buff = get();
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

    private void checkNull(T s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("item is NULL");
        }
    }

    private boolean isFull() {
        return availableItems == capacity;
    }

    private boolean isEmpty() {
        return availableItems == 0;
    }
}
