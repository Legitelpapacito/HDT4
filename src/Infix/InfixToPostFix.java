package Infix;

import Stacks.IStack;

public class InfixToPostFix {
    
    private IStack<String> stack;
    
    public InfixToPostFix(IStack<String> stack) {
        this.stack = stack;
    }
    
    public String convert(String infix) {
        StringBuilder result = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c).append(" ");
            } else if (c == '(') {
                stack.push("(");
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if ("+-*/".indexOf(c) >= 0) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(String.valueOf(c));
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }
}
