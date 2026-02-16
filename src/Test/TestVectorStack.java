package Test;

import Stacks.VectorStack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVectorStack {

    @Test
    void testPushAndPop() {
        VectorStack<Integer> stack = new VectorStack<>();

        stack.push(5);
        stack.push(15);

        assertEquals(15, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void testPeek() {
        VectorStack<String> stack = new VectorStack<>();

        stack.push("X");
        stack.push("Y");

        assertEquals("Y", stack.peek());
    }

    @Test
    void testPopEmptyStack() {
        VectorStack<Integer> stack = new VectorStack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }
}
