package intrnshp_04_Stack_impl_List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackInterfaceTest {

    private StackInterface<String> stack;
    private static final String DUMMY = "DUMMY";
    private static final String DUMMY_1 = "DUMMY_1";
    private static final String DUMMY_2 = "DUMMY_2";
    private static final String DUMMY_3 = "DUMMY_3";

    /**
     * Create an instance of the class under test.
     */
    @Before
    public void testStarted() {
        stack = new Stack<>(3);
    }

    /**
     * Put one item and check amount of elements in stack.
     */
    @Test
    public void pushTest01() {
        stack.push(DUMMY);
        assertEquals(1, stack.amountOfItems());
    }

    /**
     * Try to put null. Expect IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void pushTest02() {
        stack.push(null);
        assertEquals(1, stack.amountOfItems());
    }

    /**
     * Put three items and delete one. Check amount of elements in stack and value of top.
     */
    @Test
    public void delTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        stack.del();
        assertEquals(2, stack.amountOfItems());
        assertEquals(DUMMY_2, stack.peek());
    }

    /**
     * Try to delete item in empty stack. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void delTest02() {
        stack.del();
    }

    /**
     * Put three items and clear all. Check amount of elements in queue.
     */
    @Test
    public void clearTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        stack.clear();
        assertEquals(0, stack.amountOfItems());
    }

    /**
     * Try to clear all items in empty stack. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void clearTest02() {
        stack.clear();
    }

    /**
     * Put two items, get item from top, compare with last item put.
     */
    @Test
    public void peekTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        assertEquals(DUMMY_2, stack.peek());
    }

    /**
     * Attempt to get top item from empty stack. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void peekTest02() {
        stack.peek();
    }

    /**
     * Put three items. Look for existing entry.
     */
    @Test
    public void containTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertTrue(stack.contain(DUMMY_2));
    }

    /**
     * Put three items. Look for NOT existing entry.
     */
    @Test
    public void containTest02() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertFalse(stack.contain(DUMMY));
    }

    /**
     * Put three items. Compare expected and real amount of items.
     */
    @Test
    public void amountOfItemsTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertEquals(3, stack.amountOfItems());
    }
}