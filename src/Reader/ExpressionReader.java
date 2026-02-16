package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExpressionReader {

    private final String FILE_NAME = "datos.txt";

    // Escribe la expresión en el archivo
    public void writeExpression(String expression) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));
            writer.println(expression);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo");
        }
    }

    // Lee la expresión desde el archivo
    public String readExpression() {
        String expression = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            expression = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }

        return expression;
    }
}
