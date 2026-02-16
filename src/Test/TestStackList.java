package Test;

import Stacks.StackList;
import Listas.IList;
import Listas.ListaEncadenadaSimple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStackList {

    @Test
    void testPushAndPop() {
        IList<Integer> list = new ListaEncadenadaSimple<>();
        StackList<Integer> stack = new StackList<>(list);

        stack.push(100);
        stack.push(200);

        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());
    }

    @Test
    void testPeek() {
        IList<String> list = new ListaEncadenadaSimple<>();
        StackList<String> stack = new StackList<>(list);

        stack.push("Hola");

        assertEquals("Hola", stack.peek());
    }

    @Test
    void testPopEmptyStack() {
        IList<Integer> list = new ListaEncadenadaSimple<>();
        StackList<Integer> stack = new StackList<>(list);

        assertThrows(RuntimeException.class, stack::pop);
    }
}
