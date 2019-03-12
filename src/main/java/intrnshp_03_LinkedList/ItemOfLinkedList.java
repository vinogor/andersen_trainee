package intrnshp_03_LinkedList;

public class ItemOfLinkedList<T> {

    ItemOfLinkedList<T> prevItem;
    ItemOfLinkedList<T> nextItem;
    T obj;

    public ItemOfLinkedList(ItemOfLinkedList<T> prevItem, ItemOfLinkedList<T> nextItem, T obj) {
        this.prevItem = prevItem;
        this.nextItem = nextItem;
        this.obj = obj;
    }
}