package Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExpressionReader {

    public String readExpression() {
        String expression = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            expression = br.readLine();
            br.close();
        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }

        return expression;
    }
}
