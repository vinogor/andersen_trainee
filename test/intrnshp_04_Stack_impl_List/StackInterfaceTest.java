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

    @Before
    public void testStarted() {
        stack = new Stack<>(3);
    }

    // просто добавили и чекнули кол-во
    @Test
    public void pushTest01() {
        stack.push(DUMMY);
        assertEquals(1, stack.amountOfItems());
    }

    // попытка добавить нул
    @Test(expected = IllegalArgumentException.class)
    public void pushTest02() {
        stack.push(null);
        assertEquals(1, stack.amountOfItems());
    }

    // положили 3шт, 1 удалили, чекнули кол-во и значение вершины
    @Test
    public void delTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        stack.del();
        assertEquals(2, stack.amountOfItems());
        assertEquals(DUMMY_2, stack.peek());
    }

    // попытка удалить из пустого
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void delTest02() {
        stack.del();
    }

    // положили 3шт, очистили, чекнули кол-во
    @Test
    public void clearTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        stack.clear();
        assertEquals(0, stack.amountOfItems());
    }

    // попытка очистить пустой стэк
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void clearTest02() {
        stack.clear();
    }

    // положили 2шт, получили вершину и сравнили с тем что клали
    @Test
    public void peekTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        assertEquals(DUMMY_2, stack.peek());
    }

    // попытка получить вершину у пустого стэка
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void peekTest02() {
        stack.peek();
    }

    // положили 3шт, ищем вхождение, ожидаем ТРУ
    @Test
    public void containTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertTrue(stack.contain(DUMMY_2));
    }

    // положили 3шт, ищем несуществующее вхождение, ожидаем ФОЛС
    @Test
    public void containTest02() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertFalse(stack.contain(DUMMY));
    }

    // положили 3шт, сравниваем кол-во элементов
    @Test
    public void amountOfItemsTest01() {
        stack.push(DUMMY_1);
        stack.push(DUMMY_2);
        stack.push(DUMMY_3);
        assertEquals(3, stack.amountOfItems());
    }
}