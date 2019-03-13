package intrnshp_03_LinkedList;

public class LinkedList<T> {

    private ItemOfLinkedList<T> first;
    private ItemOfLinkedList<T> last;
    private int size = 0;

    // добавить в конец
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

    // Добавление объекта в по индексу
    public void add(int index, T obj) throws IndexOutOfBoundsException {
        if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException("ERROR: index is not correct");
        }
        if (index == size) {
            add(obj);
        } else {
            // делаем вставку
            ItemOfLinkedList<T> shiftedRightItem = findItemByIndexUnsafe(index);
            ItemOfLinkedList<T> newItem = new ItemOfLinkedList<>(shiftedRightItem.prevItem, shiftedRightItem, obj);
            if (index == 0) { // если надо вставить в самое начало
                first = newItem;
            } else {
                shiftedRightItem.prevItem.nextItem = newItem;
            }
            shiftedRightItem.prevItem = newItem;
            size++;
        }
    }

    // найти элемент по индексу (без проверки на существование index)
    private ItemOfLinkedList<T> findItemByIndexUnsafe(int index) {
        ItemOfLinkedList<T> desiredItem;
        if (index < size / 2) {
            desiredItem = first;
            for (int i = 0; i < index; i++) {
                desiredItem = desiredItem.nextItem;
            }
        } else {
            desiredItem = last;
            for (int i = 0; i < size - index - 1; i++) {
                desiredItem = desiredItem.prevItem;
            }
        }
        return desiredItem;
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
    public void del(int index) {
        if ((index > size - 1) || (index < 0)) {
            throw new IndexOutOfBoundsException("ERROR: index is not correct");
        }
        if (index == size - 1) {
            last.prevItem.nextItem = null;
            last = last.prevItem;
        } else {
            ItemOfLinkedList<T> deletedItem = findItemByIndexUnsafe(index);
            if (index == 0) { // если надо удалить из самого начала
                first = deletedItem.nextItem;
                deletedItem.nextItem.prevItem = null;
            } else {
                deletedItem.prevItem.nextItem = deletedItem.nextItem;
                deletedItem.nextItem.prevItem = deletedItem.prevItem;
            }
        }
        size--;
    }

    // Удаление элемента по значению объекта
    public void del(T obj) throws IndexOutOfBoundsException {
        ItemOfLinkedList<T> deletedItem = findItemByObj(obj);
        if (deletedItem == null) {
            throw new IndexOutOfBoundsException("ERROR: no such object found");
        }
        if (deletedItem.nextItem == null) {
            deletedItem.prevItem.nextItem = null;
            last = deletedItem.prevItem;
        } else if(deletedItem.prevItem == null) {
            deletedItem.nextItem.prevItem = null;
            first = deletedItem.nextItem;
        } else {
            deletedItem.prevItem.nextItem = deletedItem.nextItem;
            deletedItem.nextItem.prevItem = deletedItem.prevItem;
        }
    }

    private ItemOfLinkedList<T> findItemByObj(T obj) {
        ItemOfLinkedList<T> item = first;
        do {
            if ((item.obj == null) && (obj == null)) {
                return item;
            }
            if ((item.obj != null) && (item.obj.equals(obj))) {
                return item;
            }
            item = item.nextItem;
        } while (item != null);
        return null;
    }

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
                System.out.print(itemForPrint.obj + " | ");
                itemForPrint = itemForPrint.nextItem;
            } while (itemForPrint != null);
        }
        System.out.println();
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

    private static class ItemOfLinkedList<T> {
        ItemOfLinkedList<T> prevItem;
        ItemOfLinkedList<T> nextItem;
        T obj;

        public ItemOfLinkedList(ItemOfLinkedList<T> prevItem, ItemOfLinkedList<T> nextItem, T obj) {
            this.prevItem = prevItem;
            this.nextItem = nextItem;
            this.obj = obj;
        }
    }
}