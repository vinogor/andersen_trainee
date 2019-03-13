package intrnshp_03_LinkedList;

/**
 * Linked list, generalized collection. Null can be stored.
 * first - link to first item of the list.
 * last - link to last item of the list.
 * size - quantity of items of the list.
 *
 * @param <T> - type of objects to be stored in the linked list
 * @author - Andreev Aleksandr, al.andreev@andersenlab.com
 */
public class LinkedList<T> {

    private ItemOfLinkedList<T> first;
    private ItemOfLinkedList<T> last;
    private int size = 0;

    /**
     * Add item in the end of linked list.
     *
     * @param obj - add item.
     */
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

    /**
     * Add item by index. If index = (quantity elements of linked list + 1), item will add in the end if linked list.
     *
     * @param index - number of future position of adding item.
     * @param obj   - object of adding item.
     * @throws IndexOutOfBoundsException - when index not correct (less than 0 or bigger then quantity
     *                                   elements of linked list + 1.
     */
    public void add(int index, T obj) throws IndexOutOfBoundsException {
        if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException("ERROR: index is not correct");
        }
        if (index == size) {
            add(obj);
        } else {
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

    /**
     * Find item by index. Index is not checked for correctness. Item is searched by half of list.
     *
     * @param index - number of searching item.
     * @return - required item of linked list.
     */
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

    /**
     * Delete last item in linked list.
     *
     * @throws IndexOutOfBoundsException - when try to delete item in empty linked list.
     */
    public void del() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is already empty");
        }
        if (size == 1) {
            first = last = null;
            size = 0;
        } else {
            last.prevItem.nextItem = null;
            last = last.prevItem;
            size--;
        }
    }

    /**
     * Delete item by index.
     *
     * @param index - number of deleting item.
     * @throws IndexOutOfBoundsException - when item with input index is not exist
     */
    public void del(int index) throws IndexOutOfBoundsException {
        if ((index > size - 1) || (index < 0)) {
            throw new IndexOutOfBoundsException("ERROR: index is not correct");
        }

        if (size == 1) {
            first = last = null;
        } else if (index == size - 1) {
            last.prevItem.nextItem = null;
            last = last.prevItem;
        } else {
            ItemOfLinkedList<T> deletedItem = findItemByIndexUnsafe(index);
            if (index == 0) {
                first = deletedItem.nextItem;
                deletedItem.nextItem.prevItem = null;
            } else {
                deletedItem.prevItem.nextItem = deletedItem.nextItem;
                deletedItem.nextItem.prevItem = deletedItem.prevItem;
            }
        }
        size--;
    }

    /**
     * Delete the first one element of list which has found the entered object.
     * Search of deleting item goes from the first element to the last.
     *
     * @param obj - object looking for among the elements of list.
     * @throws IndexOutOfBoundsException - when list is empty or no such object found.
     */
    public void del(T obj) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is already empty");
        }
        ItemOfLinkedList<T> deletedItem = findItemByObj(obj);
        if (deletedItem == null) {
            throw new IndexOutOfBoundsException("ERROR: no such object found");
        }

        if (size == 1) {
            first = last = null;
        } else if (deletedItem.nextItem == null) {
            deletedItem.prevItem.nextItem = null;
            last = deletedItem.prevItem;
        } else if (deletedItem.prevItem == null) {
            deletedItem.nextItem.prevItem = null;
            first = deletedItem.nextItem;
        } else {
            deletedItem.prevItem.nextItem = deletedItem.nextItem;
            deletedItem.nextItem.prevItem = deletedItem.prevItem;
        }
        size--;
    }

    /**
     * Find item that has the entered object.
     * Search goes from the first element of list to the last.
     *
     * @param obj - object of searching item.
     * @return - required item of linked list. Return null if nothing is found.
     */
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

    /**
     * Delete all items in the list.
     *
     * @throws IndexOutOfBoundsException - when try to clear empty list.
     */
    public void clear() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is already empty");
        }
        last = first = null;
        size = 0;
    }

    /**
     * Display the contents of the entire linked list on the screen (including null cells)
     */
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

    /**
     * Get object of last item of list.
     *
     * @return - required object
     * @throws IndexOutOfBoundsException - when try to get item from empty list.
     */
    public T get() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("ERROR: LinkedList is empty");
        }
        return last.obj;
    }

    /**
     * Get object of item with entered index.
     *
     * @param index - number of item whose object will be returned.
     * @return - object of item with entered index.
     * @throws IndexOutOfBoundsException - when entered index is not exist
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if ((index > size - 1) || (index < 0)) {
            throw new IndexOutOfBoundsException("ERROR: index is not correct");
        }
        return findItemByIndexUnsafe(index).obj;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Structure of item of linked list.
     * prevItem - link to the previous item.
     * nextItem - link to the next item.
     *
     * @param <T> - type of objects to be stored
     */
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