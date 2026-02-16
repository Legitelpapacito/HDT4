package Main;

import java.util.Scanner;

import Reader.ExpressionReader;
import Infix.InfixToPostFix;
import Postfix.PostFixEvaluador;
import Stacks.*;
import Listas.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpressionReader reader = new ExpressionReader();

        // Usuario escribe la expresión
        System.out.println("Ingrese una expresión infix:");
        String userInput = scanner.nextLine();

        // Guardar en archivo
        reader.writeExpression(userInput);

        // Leer desde archivo
        String infix = reader.readExpression();
        System.out.println("Expresión leída desde archivo: " + infix);

        // Selección de implementación
        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = scanner.nextInt();

        IStack<String> stackString = null;
        IStack<Integer> stackInteger = null;

        switch (option) {

            case 1:
                stackString = new StackArrayList<>();
                stackInteger = new StackArrayList<>();
                break;

            case 2:
                stackString = new VectorStack<>();
                stackInteger = new VectorStack<>();
                break;

            case 3:
                System.out.println("Seleccione implementación de Lista:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");

                int listOption = scanner.nextInt();

                IList<String> listString;
                IList<Integer> listInteger;

                if (listOption == 1) {
                    listString = new ListaEncadenadaSimple<>();
                    listInteger = new ListaEncadenadaSimple<>();
                } else {
                    listString = new ListaEncadenadaDoble<>();
                    listInteger = new ListaEncadenadaDoble<>();
                }

                stackString = new StackList<>(listString);
                stackInteger = new StackList<>(listInteger);
                break;

            default:
                System.out.println("Opción inválida");
                scanner.close();
                return;
        }

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
