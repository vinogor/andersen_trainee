package intrnshp_04_Stack_impl_List;

/**
 * Interface for stack generalized collection
 *
 * @param <T> - type of objects to be stored in the stack
 * @author - Andreev Aleksandr, al.andreev@andersenlab.com
 */
public interface StackInterface<T> {

    /**
     * Put item on the top of stack
     *
     * @param obj - object for insert
     * @throws ArrayIndexOutOfBoundsException - when try to put item in already full stack
     * @throws IllegalArgumentException - when try to put null object
     */
    void push(T obj);

    /**
     * Delete item from the top of stack
     *
     * @throws ArrayIndexOutOfBoundsException - then try to delete from empty stack
     */
    void del();

    /**
     * Make stack clear - delete all items.
     *
     * @throws ArrayIndexOutOfBoundsException - when try to clear already empty stack.
     */
    void clear();

    /**
     * Get item from the top of stack.
     *
     * @return - object from the top of stack.
     * @throws ArrayIndexOutOfBoundsException - when try to get item from empty stack.
     */
    T peek();

    /**
     * Is entered object contained in a stack?
     *
     * @param obj - object to search
     * @return - true if contained, false if NOT contained
     * @throws ArrayIndexOutOfBoundsException - then try to search in empty stack
     * @throws IllegalArgumentException - then try to search null object
     */
    boolean contain(T obj);

    /**
     * Display the contents of the entire stack on the screen (including empty cells)
     */
    void print();

    int amountOfItems();
}