package intrnshp_03_LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedListTest {

    private LinkedList<String> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList<>();
    }

    // просто добавить 1 строку
    @Test
    public void add1() {
        linkedList.add("dummy");
        assertEquals(1, linkedList.size());
        assertEquals("dummy", linkedList.get());
    }

    // добавить null вместо строки
    @Test
    public void add2() {
        linkedList.add(null);
        assertEquals(1, linkedList.size());
        assertNull(linkedList.get());
    }

    // добавить по индексу - в начало
    @Test
    public void add3() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.add(0, "dummy");

        assertEquals(4, linkedList.size());
        assertEquals("dummy", linkedList.get(0));
        assertEquals("dummy_0", linkedList.get(1));
        assertEquals("dummy_1", linkedList.get(2));
        assertEquals("dummy_2", linkedList.get(3));
    }

    // добавить по индексу - в конец
    @Test
    public void add4() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.add(3, "dummy");

        assertEquals(4, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy_1", linkedList.get(1));
        assertEquals("dummy_2", linkedList.get(2));
        assertEquals("dummy", linkedList.get(3));
    }

    //  добавить по индексу - в середину
    @Test
    public void add5() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.add(1, "dummy");

        assertEquals(4, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy", linkedList.get(1));
        assertEquals("dummy_1", linkedList.get(2));
        assertEquals("dummy_2", linkedList.get(3));
    }

    // добавить по индексу - отрициательному
    @Test(expected = IndexOutOfBoundsException.class)
    public void add6() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.add(-1, "dummy");
    }

    // добавить по индексу - превышающему размер более чем на 1
    @Test(expected = IndexOutOfBoundsException.class)
    public void add7() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.add(4, "dummy");
    }

    // удаление последнего - единственного
    @Test
    public void del1() {
        linkedList.add("dummy");
        linkedList.del();
        assertEquals(0, linkedList.size());
    }

    // удаление последнего - НЕ единственного
    @Test
    public void del2() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.del();
        assertEquals(1, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
    }

    // удаление последнего - из пустого списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void del3() {
        linkedList.del();
    }

    // удаление по индексу - идинственного
    @Test
    public void del4() {
        linkedList.add("dummy");
        linkedList.del(0);
        assertEquals(0, linkedList.size());
    }

    // удаление по индексу - первого не едиственного
    @Test
    public void del5() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del(0);
        assertEquals(2, linkedList.size());
        assertEquals("dummy_1", linkedList.get(0));
        assertEquals("dummy_2", linkedList.get(1));
    }

    // удаление по индексу - последнего не едиственного
    @Test
    public void del6() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del(2);
        assertEquals(2, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy_1", linkedList.get(1));
    }

    // удаление по индексу - из середины, не едиственного
    @Test
    public void del7() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del(1);
        assertEquals(2, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy_2", linkedList.get(1));
    }

    // удаление по индексу - из пустого списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void del8() {
        linkedList.del(0);
    }

    // удаление по индексу - индекс отрицательный, список НЕ пустой
    @Test(expected = IndexOutOfBoundsException.class)
    public void del9() {
        linkedList.add("dummy");
        linkedList.del(-1);
    }

    // удаление по индексу - индекс превышает длину, список не пустой
    @Test(expected = IndexOutOfBoundsException.class)
    public void del10() {
        linkedList.add("dummy");
        linkedList.del(1);
    }

    // удаление по объекту - идинственному
    @Test
    public void del11() {
        linkedList.add("dummy");
        linkedList.del("dummy");
        assertEquals(0, linkedList.size());
    }

    // удаление по объекту - первого не едиственного
    @Test
    public void del12() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del("dummy_0");
        assertEquals(2, linkedList.size());
        assertEquals("dummy_1", linkedList.get(0));
        assertEquals("dummy_2", linkedList.get(1));
    }

    // удаление по объекту - последнего не едиственного
    @Test
    public void del13() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del("dummy_2");
        assertEquals(2, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy_1", linkedList.get(1));
    }

    // удаление по объекту - из середины, не едиственного
    @Test
    public void del14() {
        linkedList.add("dummy_0");
        linkedList.add("dummy_1");
        linkedList.add("dummy_2");
        linkedList.del("dummy_1");
        assertEquals(2, linkedList.size());
        assertEquals("dummy_0", linkedList.get(0));
        assertEquals("dummy_2", linkedList.get(1));
    }

    // удаление по объекту - из пустого списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void del15() {
        linkedList.del("dummy");
    }

    // удаление по объекту - объект не существует, список НЕ пустой
    @Test(expected = IndexOutOfBoundsException.class)
    public void del16() {
        linkedList.add("dummy");
        linkedList.del("not_dummy");
    }

    // удаление по объекту = null, список не пустой
    @Test
    public void del17() {
        linkedList.add(null);
        linkedList.del(null);
        assertEquals(0, linkedList.size());
    }

    // очистка не пустого списка
    @Test
    public void clear1() {
        linkedList.add("dummy");
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }

    // очистка пустого списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void clear2() {
        linkedList.clear();
    }

    // получить последний элемент - не пустая очередь
    @Test
    public void get1() {
        linkedList.add("dummy");
        assertEquals("dummy", linkedList.get());
    }

    // получить последний элемент = null - не пустая очередь
    @Test
    public void get2() {
        linkedList.add(null);
        assertEquals(null, linkedList.get());
    }

    // получить последний элемент - пустая очередь
    @Test(expected = IndexOutOfBoundsException.class)
    public void get3() {
        linkedList.get();
    }

    // получить размер пустой очереди
    @Test
    public void size1() {
        assertEquals(0, linkedList.size());
    }

    // получить размер НЕ пустой очереди
    @Test
    public void size2() {
        linkedList.add("dummy");
        assertEquals(1, linkedList.size());
    }
}