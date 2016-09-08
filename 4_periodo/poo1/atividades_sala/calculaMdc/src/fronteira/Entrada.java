package fronteira;

import java.util.Scanner;

public class Entrada {    
    public static Double leCoeficiente(String msg) {
        Scanner reader = new Scanner(System.in);

        Saida.print(msg);
        return reader.nextDouble();
    }
}