package intrnshp_02_Queue_FIFO;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueFifoTest {

    QueueFifo<String> queueFifo = new QueueFifo(3);

    @Test
    public void addTest1() {
        queueFifo.add("111");
        assertEquals(1, queueFifo.getAvailableItems());
    }

    @Test
    public void addTest2() {
        queueFifo.add("111");
        queueFifo.add("222");
        assertEquals(2, queueFifo.getAvailableItems());
    }

    @Test(expected = RuntimeException.class)
    public void addTest3() {
        queueFifo.add("111");
        queueFifo.add("222");
        queueFifo.add("333");
        queueFifo.add("444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTest4() {
        queueFifo.add(null);
    }

    @Test
    public void delTest1() {
        queueFifo.add("111");
        queueFifo.add("222");
        queueFifo.add("333");
        queueFifo.del();
        assertEquals(2, queueFifo.getAvailableItems());
    }

    @Test
    public void delTest2() {
        queueFifo.add("111");
        queueFifo.add("222");
        queueFifo.add("333");
        queueFifo.del();
        queueFifo.del();
        queueFifo.del();
        assertEquals(0, queueFifo.getAvailableItems());
    }

    @Test(expected = RuntimeException.class)
    public void delTest3() {
        queueFifo.del();
    }
}