package Infix;

import Stacks.IStack;

public class InfixToPostFix {

    private IStack<String> stack;

    public InfixToPostFix(IStack<String> stack) {
        this.stack = stack;
    }

    public String convert(String expression) {

        StringBuilder output = new StringBuilder();
        String number = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                number += ch;
            } 
            else {

                if (!number.isEmpty()) {
                    output.append(number).append(" ");
                    number = "";
                }

                if (ch == '(') {
                    stack.push(String.valueOf(ch));
                } 
                else if (ch == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        output.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } 
                else if (isOperator(ch)) {

                    while (!stack.isEmpty() &&
                        precedence(String.valueOf(ch)) <= precedence(stack.peek())) {
                        output.append(stack.pop()).append(" ");
                    }

                    stack.push(String.valueOf(ch));
                }
            }
        }

        if (!number.isEmpty()) {
            output.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }
}
