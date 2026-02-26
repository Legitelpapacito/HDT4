package Main;

import java.util.Scanner;
import Reader.ExpressionReader;
import Infix.InfixToPostFix;
import Postfix.PostFixEvaluador;
import Stacks.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpressionReader reader = new ExpressionReader();

        System.out.println("Ingrese una expresión infix:");
        String userInput = scanner.nextLine();

        reader.writeExpression(userInput);
        String infix = reader.readExpression();

        System.out.println("Expresión leída desde archivo: " + infix);

        // 🔹 SOLO SE PREGUNTA UNA VEZ
        IStack<String> stackString = StackFactory.createStack();
        IStack<Integer> stackInteger = StackFactory.createStack();

        // Convertir a postfix
        InfixToPostFix converter = new InfixToPostFix(stackString);
        String postfix = converter.convert(infix);

        System.out.println("Expresión Postfix: " + postfix);

        // Evaluar postfix
        PostFixEvaluador evaluator = new PostFixEvaluador(stackInteger);
        int result = evaluator.evaluate(postfix);

        System.out.println("Resultado final: " + result);

        scanner.close();
    }
}