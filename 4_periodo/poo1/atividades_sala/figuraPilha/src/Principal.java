import controle.*;
import fronteira.*;

public class Principal {
    public static void main(String[] args) {
        EmpilhadorFigura pFig;
        int nFig;

        Saida.println(" === JOGO - Imprime figuras ===");
        nFig = Entrada.leInt("Informe o número de figuras a serem inseridos na pilha: ");

        pFig = new EmpilhadorFigura(nFig);

        pFig.horaDeEmpilhar();
        pFig.mostrarFiguras();
    }
}