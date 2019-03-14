package intrnshp_04_Stack_impl_List;

/**
 * LIFO stack, generalized collection.
 *
 * @param <T> - type of objects to be stored in the stack.
 * @author - Andreev Aleksandr, al.andreev@andersenlab.com
 */
public class Stack<T> implements StackInterface<T> {

    private int capacity;
    private int index = -1;
    private T[] arrForStack;

    /**
     * Set maximum stack size.
     *
     * @param capacity -  maximum amount of items in stack.
     */
    public Stack(int capacity) {
        this.capacity = capacity;
        arrForStack = (T[]) new Object[capacity];
    }

    /**
     * Put item on the top of stack.
     *
     * @param obj - object for insert.
     * @throws ArrayIndexOutOfBoundsException - when try to put item in already full stack.
     * @throws IllegalArgumentException - when try to put null object.
     */
    @Override
    public void push(T obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is full");
        } else if(isNull(obj)) {
            throw new IllegalArgumentException("ERROR: item is NULL");
        }
        index++;
        arrForStack[index] = obj;
    }

    /**
     * Delete item from the top of stack.
     *
     * @throws ArrayIndexOutOfBoundsException - then try to delete from empty stack.
     */
    @Override
    public void del() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        }
        arrForStack[index] = null;
        index--;
    }

    /**
     * Make stack clear - delete all items.
     *
     * @throws ArrayIndexOutOfBoundsException - when try to clear already empty stack.
     */
    @Override
    public void clear() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is already empty");
        }
        for (int i = 0; i < index + 1; i++) {
            arrForStack[i] = null;
        }
        index = -1;
    }

    /**
     * Get item from the top of stack.
     *
     * @return - object from the top of stack.
     * @throws ArrayIndexOutOfBoundsException - when try to get item from empty stack.
     */
    @Override
    public T peek() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        }
        return arrForStack[index];
    }

    /**
     * Check the presence of the entered object in the stack.
     *
     * @param obj - object to search.
     * @return - true if contained, false if NOT contained.
     * @throws ArrayIndexOutOfBoundsException - then try to search in empty stack.
     * @throws IllegalArgumentException - then try to search null object.
     */
    @Override
    public boolean contain(T obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        } else if(isNull(obj)) {
            throw new IllegalArgumentException("ERROR: input item is NULL");
        }
        for (int i = 0; i < index + 1; i++) {
            if (obj.equals(arrForStack[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display the contents of the entire stack on the screen (including empty cells).
     */
    @Override
    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(arrForStack[i] + " | ");
        }
        System.out.println();
    }

    @Override
    public int amountOfItems() {
        return index + 1;
    }

    private boolean isFull() {
        return (index == capacity - 1);
    }

    private boolean isEmpty() {
        return index == -1;
    }

    private boolean isNull(T obj) {
        return obj == null;
    }
}