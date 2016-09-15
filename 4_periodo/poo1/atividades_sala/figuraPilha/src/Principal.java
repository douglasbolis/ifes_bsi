import controle.*;

public class Principal {
    public static void main(String[] args) {
        EmpilhadorFigura pFig = new EmpilhadorFigura(2);

        pFig.horaDeEmpilhar();
        pFig.mostrarFiguras();
    }
}