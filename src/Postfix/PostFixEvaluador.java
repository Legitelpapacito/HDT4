package Postfix;

import Stacks.IStack;

public class PostFixEvaluador {
    
    private IStack<Integer> stack;
    
    public PostFixEvaluador(IStack<Integer> stack) {
        this.stack = stack;
    }
    
    public int evaluate(String postfix) {
        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}
