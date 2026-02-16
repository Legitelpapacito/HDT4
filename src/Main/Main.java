package Main;

import Stacks.StackArrayList;
import Stacks.IStack;
import Infix.InfixToPostFix;
import Postfix.PostFixEvaluador;

public class Main {
    
    public static void main(String[] args) {
        // Ejemplo: convertir y evaluar expresión
        IStack<String> stack = new StackArrayList<>();
        InfixToPostFix converter = new InfixToPostFix(stack);
        String infix = "3+5*2";
        String postfix = converter.convert(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
        
        IStack<Integer> evalStack = new StackArrayList<>();
        PostFixEvaluador evaluador = new PostFixEvaluador(evalStack);
        int result = evaluador.evaluate(postfix);
        System.out.println("Resultado: " + result);
    }
}
