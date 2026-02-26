package Stacks;

import java.util.Scanner;
import Listas.*;

public class StackFactory {

    public static <E> IStack<E> createStack() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {

            case 1:
                return new StackArrayList<>();

            case 2:
                return new VectorStack<>();

            case 3:
                return createListStack(scanner);

            default:
                System.out.println("Opción inválida. Usando ArrayList por defecto.");
                return new StackArrayList<>();
        }
    }

    private static <E> IStack<E> createListStack(Scanner scanner) {

        System.out.println("Seleccione implementación de Lista:");
        System.out.println("1. Simplemente encadenada");
        System.out.println("2. Doblemente encadenada");

        int listOption = scanner.nextInt();
        scanner.nextLine(); 

        IList<E> list;

        if (listOption == 1) {
            list = new ListaEncadenadaSimple<>();
        } else {
            list = new ListaEncadenadaDoble<>();
        }

        return new StackList<>(list);
    }
}