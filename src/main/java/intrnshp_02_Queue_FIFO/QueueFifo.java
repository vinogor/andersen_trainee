package intrnshp_02_Queue_FIFO;

/**
 * FIFO queue, generalized collection
 *
 * @param <T> - type of objects to be stored in the queue
 * @author - Andreev Aleksandr
 * @email - al.andreev@andersenlab.com
 */

public class QueueFifo<T> {

    private int capacity;
    private int availableItems = 0;
    private T[] arrayForQueue;

    /** Set maximum queue size and initialize it */
    public void init(int capacity) {
        this.capacity = capacity;
        arrayForQueue = (T[]) new Object[capacity];
    }

    /**
     * Add item in the end of queue.
     * @param obj - add item.
     * @throws IllegalArgumentException - when trying to add null item.
     * @throws ArrayIndexOutOfBoundsException - when trying to add an item to a fully populated queue.
     */
    public void add(T obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        checkNull(obj);
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: queue already full");
        } else if (isEmpty()) {
            arrayForQueue[0] = obj;
            availableItems++;
        } else {
            System.arraycopy(arrayForQueue, 0, arrayForQueue, 1, availableItems);
            arrayForQueue[0] = obj;
            availableItems++;
        }
    }

    /**
     * Remove item from head if queue.
     * @throws IndexOutOfBoundsException - when trying to remove item from empty queue.
     */
    public void del() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: queue is already empty");
        }
        availableItems--;
        arrayForQueue[availableItems] = null;
    }

    /**
     * Remove all items from head if queue.
     * @throws IndexOutOfBoundsException - when trying to remove items from empty queue.
     */
    public void clear() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: queue is already empty");
        }
        for (int i = 0; i < capacity; i++) {
            arrayForQueue[i] = null;
        }
        availableItems = 0;
    }

    /**
     * Get first item int the queue.
     * @return - first item int the queue.
     * @throws IndexOutOfBoundsException - when trying to get item from empty queue.
     */
    public T get() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: queue is empty");
        }
        return arrayForQueue[availableItems - 1];
    }

    /** Return the maximum possible queue size */
    public int getCapacity() {
        return capacity;
    }

    /** Return the current number of items in the queue */
    public int getAvailableItems() {
        return availableItems;
    }

    /** Display the contents of the entire array on the screen (including empty cells) */
    public void print() {
        System.out.print("| ");
        for (int i = 0; i < capacity; i++) {
            System.out.print(arrayForQueue[i] + " | ");
        }
        System.out.println();
    }

    /** Check for null element */
    private void checkNull(T s) {
        if (s == null) {
            throw new IllegalArgumentException("item is NULL");
        }
    }

    /** Check if the queue is full? */
    private boolean isFull() {
        return availableItems == capacity;
    }

    /** Check if the queue is empty? */
    private boolean isEmpty() {
        return availableItems == 0;
    }
}