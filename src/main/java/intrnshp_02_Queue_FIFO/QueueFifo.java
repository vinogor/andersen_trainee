package intrnshp_02_Queue_FIFO;

/**
 * Класс - очередь FIFO, обобщённая колекция
 * @autor - Андреев Александр
 * @email - al.andreev@andersenlab.com
 * @param <T> - тип объектов, которые будут храниться в очереди
 */

public class QueueFifo<T> {

    private int capacity;
    private int availableItems = 0;
    private T[] queueFifo;

    /**
     * Конструктор - получение максимального размера очереди и создание массива для её хранения
     * @param capacity - максимальный размер создаваемой очереди
     */
    public QueueFifo(int capacity) {
        this.capacity = capacity;
        queueFifo = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления элемента в конец очереди
     * @param obj - добавляемый элемент
     * @throws IllegalArgumentException - при попытке добавить элемент в полностью заполненную очередь
     */
    public void add(T obj) throws IllegalArgumentException {
        checkNull(obj);
        if (isFull()) {
            throw new RuntimeException("ERROR: queue already full");
        } else if (isEmpty()) {
            queueFifo[0] = obj;
            availableItems++;
        } else {
            System.arraycopy(queueFifo, 0, queueFifo, 1, availableItems);
            queueFifo[0] = obj;
            availableItems++;
        }
    }

    /**
     * Метод - удаление элемента из начала очереди
     * @throws RuntimeException - при попытке удалить объект из пустой очереди
     */
    public void del()throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: queue already full");
        }
        availableItems--;
        queueFifo[availableItems] = null;
    }

    /**
     * Метод - получение первого элемента в очереди
     * @return - возвращает первый элемент в очереди
     * @throws RuntimeException - при попытке получить элемент из пустой очереди
     */
    public T get() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("ERROR: queue is empty");
        }
        return queueFifo[availableItems - 1];
    }

    /** Метод - переместить элемент из начала в конец очереди */
    public void fromBeginToEnd() {
        T buff = get();
        del();
        add(buff);
    }

    /** Метод - возвращает максимально возможный размер очереди */
    public int getCapacity() {
        return capacity;
    }

    /** Метод - возвращает количество элементов в очереди */
    public int getAvailableItems() {
        return availableItems;
    }

    /** Метод - выводит содержимое всего массива на экран (в т.ч. пустые ячейки) */
    public void print() {
        System.out.print("| ");
        for (int i = 0; i < capacity; i++) {
            System.out.print(queueFifo[i] + " | ");
        }
        System.out.println();
    }

    /** Метод - проверяем на null элемент, который хотим поместить в очередь */
    private void checkNull(T s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("item is NULL");
        }
    }

    /** Метод - проверяем, не заполнена ли полностью очередь? */
    private boolean isFull() {
        return availableItems == capacity;
    }

    /** Метод - проверяем, не пуста ли очередь? */
    private boolean isEmpty() {
        return availableItems == 0;
    }
}