package Postfix;

import Stacks.IStack;

public class PostFixEvaluador {

    private IStack<Integer> stack;

    public PostFixEvaluador(IStack<Integer> stack) {
        this.stack = stack;
    }

    public int evaluate(String expression) {

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {

                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }
}
