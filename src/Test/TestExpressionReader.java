package Test;

import Reader.ExpressionReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestExpressionReader {

    @Test
    void testReadExpression() {
        ExpressionReader reader = new ExpressionReader();

        String expression = reader.readExpression();

        assertNotNull(expression);
    }
}
