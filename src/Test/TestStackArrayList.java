package Test;

import Stacks.StackArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStackArrayList {

    @Test
    void testPushAndPop() {
        StackArrayList<Integer> stack = new StackArrayList<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        StackArrayList<String> stack = new StackArrayList<>();

        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
    }

    @Test
    void testIsEmpty() {
        StackArrayList<Integer> stack = new StackArrayList<>();

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());
    }

    @Test
    void testPopEmptyStack() {
        StackArrayList<Integer> stack = new StackArrayList<>();

        assertThrows(RuntimeException.class, stack::pop);
    }
}
