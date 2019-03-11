package intrnshp_02_Queue_FIFO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueFifoTest {

    private QueueFifo<String> queueFifo;

    /** Create an instance of the class under test and initialize the array for the queue */
    @Before
    public void testStarted() {
        queueFifo = new QueueFifo();
        queueFifo.init(3);
    }

    /** Put one item and check amount of elements in queue */
    @Test
    public void addTest1() {
        queueFifo.add("dummy");
        assertEquals(1, queueFifo.getAvailableItems());
    }

    /** Put two items and check amount of elements in queue */
    @Test
    public void addTest2() {
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        assertEquals(2, queueFifo.getAvailableItems());
    }

    /** Put three items and try to put fourth. Expect ArrayIndexOutOfBoundsException */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addTest3() {
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.add("dummy");
    }

    /** Try to put null. Expect IllegalArgumentException */
    @Test(expected = IllegalArgumentException.class)
    public void addTest4() {
        queueFifo.add(null);
    }

    /** Put three items and delete one. Check amount of elements in queue */
    @Test
    public void delTest1() {
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.del();
        assertEquals(2, queueFifo.getAvailableItems());
    }

    /** Try to delete item in empty queue. Expect IndexOutOfBoundsException */
    @Test(expected = IndexOutOfBoundsException.class)
    public void delTest2() {
        queueFifo.del();
    }

    /** Put three items and clear all. Check amount of elements in queue */
    @Test
    public void clearTest1() {
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.add("dummy");
        queueFifo.clear();
        assertEquals(0, queueFifo.getAvailableItems());
    }

    /** Try to clear all items in empty queue. Expect IndexOutOfBoundsException */
    @Test(expected = IndexOutOfBoundsException.class)
    public void clearTest2() {
        queueFifo.del();
    }
}