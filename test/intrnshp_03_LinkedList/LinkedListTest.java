package intrnshp_03_LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedListTest {

    private LinkedList<String> linkedList;

    private static final String DUMMY = "DUMMY";
    private static final String DUMMY_0 = "DUMMY_0";
    private static final String DUMMY_1 = "DUMMY_1";
    private static final String DUMMY_2 = "DUMMY_2";

    /**
     * Create an instance of the class under test
     */
    @Before
    public void setUp() {
        linkedList = new LinkedList<>();
    }

    /**
     * Put one item in the end of list and check amount of elements and
     * check the equality of the item sent and the received.
     */
    @Test
    public void add1() {
        linkedList.add(DUMMY);
        assertEquals(1, linkedList.size());
        assertEquals(DUMMY, linkedList.get());
    }

    /**
     * Put one item ( = null) in the end list and check amount of elements and
     * check the equality of the item sent and the received.
     */
    @Test
    public void add2() {
        linkedList.add(null);
        assertEquals(1, linkedList.size());
        assertNull(linkedList.get());
    }

    /**
     * Put three items in the end of list. Then put item by index in the BEGIN of list.
     * Check amount of elements and check the compliance of objects and indexes of elements.
     */
    @Test
    public void add3() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.add(0, DUMMY);

        assertEquals(4, linkedList.size());
        assertEquals(DUMMY, linkedList.get(0));
        assertEquals(DUMMY_0, linkedList.get(1));
        assertEquals(DUMMY_1, linkedList.get(2));
        assertEquals(DUMMY_2, linkedList.get(3));
    }

    /**
     * Put three items in the end of list. Then put item by index in the END of list.
     * Check amount of elements and check the compliance of objects and indexes of elements.
     */
    @Test
    public void add4() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.add(3, DUMMY);

        assertEquals(4, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY_1, linkedList.get(1));
        assertEquals(DUMMY_2, linkedList.get(2));
        assertEquals(DUMMY, linkedList.get(3));
    }

    /**
     * Put three items in the end of list. Then put item by index in the MIDDLE of list.
     * Check amount of elements and check the compliance of objects and indexes of elements.
     */
    @Test
    public void add5() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.add(1, DUMMY);

        assertEquals(4, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY, linkedList.get(1));
        assertEquals(DUMMY_1, linkedList.get(2));
        assertEquals(DUMMY_2, linkedList.get(3));
    }

    /**
     * Attempt to add item to negative index.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void add6() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.add(-1, DUMMY);
    }

    /**
     * Attempt to add item with index larger than the list size by more than 1.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void add7() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.add(4, DUMMY);
    }

    /**
     * Delete last single item. Check amount of elements.
     */
    @Test
    public void del1() {
        linkedList.add(DUMMY);
        linkedList.del();
        assertEquals(0, linkedList.size());
    }

    /**
     * Delete last NOT single item. Check amount of elements.
     */
    @Test
    public void del2() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.del();
        assertEquals(1, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
    }

    /**
     * Try to delete item from empty list. Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del3() {
        linkedList.del();
    }

    /**
     * Delete single item by index. Check amount of elements.
     */
    @Test
    public void del4() {
        linkedList.add(DUMMY);
        linkedList.del(0);
        assertEquals(0, linkedList.size());
    }

    /**
     * Delete FIRST item (not single) by index. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del5() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(0);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_1, linkedList.get(0));
        assertEquals(DUMMY_2, linkedList.get(1));
    }

    /**
     * Delete LAST item (not single) by index. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del6() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(2);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY_1, linkedList.get(1));
    }

    /**
     * Delete item in the MIDDLE (not single) by index. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del7() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(1);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY_2, linkedList.get(1));
    }

    /**
     * Try to delete item by index from empty list. Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del8() {
        linkedList.del(0);
    }

    /**
     * Attempt to delete item by negative index from not empty list.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del9() {
        linkedList.add(DUMMY);
        linkedList.del(-1);
    }

    /**
     * Attempt to delete item by index exceeding size of list from not empty list.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del10() {
        linkedList.add(DUMMY);
        linkedList.del(1);
    }

    /**
     * Delete single item by object. Check amount of elements.
     */
    @Test
    public void del11() {
        linkedList.add(DUMMY);
        linkedList.del(DUMMY);
        assertEquals(0, linkedList.size());
    }

    /**
     * Delete FIRST item (not single) by object. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del12() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(DUMMY_0);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_1, linkedList.get(0));
        assertEquals(DUMMY_2, linkedList.get(1));
    }

    /**
     * Delete LAST item (not single) by object. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del13() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(DUMMY_2);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY_1, linkedList.get(1));
    }

    /**
     * Delete item in the MIDDLE (not single) by object. Check amount of elements
     * and check the compliance of objects and indexes of elements.
     */
    @Test
    public void del14() {
        linkedList.add(DUMMY_0);
        linkedList.add(DUMMY_1);
        linkedList.add(DUMMY_2);
        linkedList.del(DUMMY_1);
        assertEquals(2, linkedList.size());
        assertEquals(DUMMY_0, linkedList.get(0));
        assertEquals(DUMMY_2, linkedList.get(1));
    }

    /**
     * Try to delete item by object from empty list. Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del15() {
        linkedList.del(DUMMY);
    }

    /**
     * Attempt to delete object which not exist from not empty list.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void del16() {
        linkedList.add(DUMMY);
        linkedList.del("not_DUMMY");
    }

    /**
     * Delete item by object ( = null). Check amount of elements.
     */
    @Test
    public void del17() {
        linkedList.add(null);
        linkedList.del(null);
        assertEquals(0, linkedList.size());
    }

    /**
     * Put one item in the end of list and clear list. Check amount of elements.
     */
    @Test
    public void clear1() {
        linkedList.add(DUMMY);
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }

    /**
     * Attempt to clear empty list.
     * Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void clear2() {
        linkedList.clear();
    }

    /**
     * Put item with DUMMY object in the end of list. Get object of last item in the list.
     * Check for equality of the sent and received objects.
     */
    @Test
    public void get1() {
        linkedList.add(DUMMY);
        assertEquals(DUMMY, linkedList.get());
    }

    /**
     * Put item with object ( = null) in the end of list. Get object of last item in the list.
     * Check for equality to null getting object.
     */
    @Test
    public void get2() {
        linkedList.add(null);
        assertNull(linkedList.get());
    }

    /**
     * Attempt to get item from empty list. Expect IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void get3() {
        linkedList.get();
    }

    /**
     * Get quantity of items in empty list. Check for equality to zero.
     */
    @Test
    public void size1() {
        assertEquals(0, linkedList.size());
    }

    /**
     * Get quantity of items in NOT empty list. Check for equality to real size.
     */
    @Test
    public void size2() {
        linkedList.add(DUMMY);
        assertEquals(1, linkedList.size());
    }
}