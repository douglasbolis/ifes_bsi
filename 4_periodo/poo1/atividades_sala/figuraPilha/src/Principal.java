import controle.*;
import fronteira.*;

public class Principal {
    public static void main(String[] args) {
        EmpilhadorFigura pFig;
        int nFig;

        Saida.println(" === JOGO - Imprime figuras ===");

        pFig = new EmpilhadorFigura();

        pFig.menuFigura();
    }
}