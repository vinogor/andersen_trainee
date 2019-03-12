package intrnshp_03_LinkedList;

public class LinkedList<T> {

    private ItemOfLinkedList<T> first;
    private ItemOfLinkedList<T> last;
    private int size = 0;

    public void add(T obj) {

        if (isEmpty()) {
            ItemOfLinkedList<T> newItem = new ItemOfLinkedList<>(null, null, obj);
            first = last = newItem;
        } else {
            last.nextItem = new ItemOfLinkedList<>(last, null, obj);
            last = last.nextItem;
        }
        size++;
    }

    // Добавление объекта в середину связанного списка
    public void add(int index, T obj) {

    }

    // Удаление последнего элемента
    public void del() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is already empty");
        }
        last.prevItem.nextItem = null;
        last = last.prevItem;
        size--;
    }

    // Удаление элемента по индексу
    // Удаление элемента по значению объекта


    public void clear() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is already empty");
        }
        last = first = null;
        size = 0;
    }

    public void print() {
        ItemOfLinkedList<T> itemForPrint = first;

        if (isEmpty()) {
            System.out.println("LinkedList is empty");
        } else {
            do {
                System.out.println(itemForPrint + " | " + itemForPrint.prevItem + " | " + itemForPrint.obj + " | " + itemForPrint.nextItem);
                itemForPrint = itemForPrint.nextItem;
            } while (itemForPrint != null);
        }
    }

    // Получение объекта последнего элемента
    public T get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is empty");
        }
        return last.obj;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}