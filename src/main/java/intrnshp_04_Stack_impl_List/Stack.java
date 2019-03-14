package intrnshp_04_Stack_impl_List;

// LIFO - last in - first out
public class Stack<T> implements StackInterface<T> {

    private int capacity;
    private int index = -1;
    private T[] arrForStack;

    public Stack(int capacity) {
        this.capacity = capacity;
        arrForStack = (T[]) new Object[capacity];
    }

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

    @Override
    public void del() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        }
        arrForStack[index] = null;
        index--;
    }

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

    @Override
    public T peek() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        }
        return arrForStack[index];
    }

    @Override
    public boolean contain(T obj) throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: stack is empty");
        }
        for (int i = 0; i < index + 1; i++) {
            if (obj.equals(arrForStack[i])) {
                return true;
            }
        }
        return false;
    }

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