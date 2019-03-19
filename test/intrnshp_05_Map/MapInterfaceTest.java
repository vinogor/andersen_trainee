package intrnshp_05_Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapInterfaceTest {

    private MapInterface<String, String> map;

    private static final String DUMMY_KEY_1 = "DUMMY_KEY_1";
    private static final String DUMMY_KEY_2 = "DUMMY_KEY_2";
    private static final String DUMMY_KEY_3 = "DUMMY_KEY_3";

    private static final String DUMMY_VALUE_1 = "DUMMY_VALUE_1";
    private static final String DUMMY_VALUE_2 = "DUMMY_VALUE_2";
    private static final String DUMMY_VALUE_3 = "DUMMY_VALUE_3";

    /**
     * Create an instance of the class under test.
     */
    @Before
    public void setUp() {
        map = new Map<>(3);
    }

    /**
     * Put one pair and check amount of elements in map.
     */
    @Test
    public void putTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertEquals(1, map.size());
    }

    /**
     * Put two pairs with the same key and check amount of elements in map.
     */
    @Test
    public void putTest02() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertEquals(1, map.size());
    }

    /**
     * Put one pair and check pair with key entered.
     */
    @Test
    public void containsKeyTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertTrue(map.containsKey(DUMMY_KEY_1));
    }

    /**
     * Put one pair and check pair with non-existent key entered.
     */
    @Test()
    public void containsKeyTest02() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertFalse(map.containsKey(DUMMY_KEY_2));
    }

    /**
     * Put one pair and check pair with value entered.
     */
    @Test
    public void containsValueTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertTrue(map.containsValue(DUMMY_VALUE_1));
    }

    /**
     * Put one pair and check pair with non-existent value entered.
     */
    @Test()
    public void containsValueTest02() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertFalse(map.containsValue(DUMMY_VALUE_2));
    }

    /**
     * Put one pair and get value by key.
     */
    @Test
    public void getValueTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        assertEquals(DUMMY_VALUE_1, map.getValue(DUMMY_KEY_1));
    }

    /**
     * Put one pair and try to get value by non-existent key. Expect IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getValueTest02() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        map.getValue(DUMMY_KEY_2);
    }

    /**
     * Try to get value of pair from empty map. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getValueTest03() {
        map.getValue(DUMMY_KEY_1);
    }

    /**
     * Put one pair and remove this pair key.
     */
    @Test
    public void removeTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        map.remove(DUMMY_KEY_1);
        assertEquals(0, map.size());
    }

    /**
     * Put one pair and try to remove pair by non-existent key. Expect IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void removeTest02() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        map.remove(DUMMY_KEY_2);
    }

    /**
     * Put one pair and try to remove pair from empty map. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeTest03() {
        map.remove(DUMMY_KEY_1);
    }

    /**
     * Put three pairs, clear all and check amount of elements in the map.
     */
    @Test
    public void clearTest01() {
        map.put(DUMMY_KEY_1, DUMMY_VALUE_1);
        map.put(DUMMY_KEY_2, DUMMY_VALUE_2);
        map.put(DUMMY_KEY_3, DUMMY_VALUE_3);
        map.clear();
        assertEquals(0, map.size());
    }

    /**
     * Try to clear already empty map. Expect ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void clearTest02() {
        map.clear();
    }
}