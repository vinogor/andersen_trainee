package intrnshp_04_Stack_impl_List;

public interface StackInterface<T> {
    /*
    добавить   push(O)
    удалить del
    очистить clear
    получить (не удаляя) peek
    содержит ли (contain)T
     */

    void push(T obj);
    void del();
    void clear();
    T peek();
    boolean contain(T obj);
    void print();
    int amountOfItems();
}
