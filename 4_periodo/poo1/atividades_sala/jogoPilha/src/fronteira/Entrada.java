package fronteira;

import java.util.Scanner;

public class Entrada {    
    public static int leInt(String msg) {
        Scanner reader = new Scanner(System.in);

        Saida.print(msg);
        return reader.nextInt();
    }
}