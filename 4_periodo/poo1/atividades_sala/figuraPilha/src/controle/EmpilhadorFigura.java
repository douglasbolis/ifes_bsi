package controle;

import entidades.*;
import fronteira.*;

public class EmpilhadorFigura {
    private Pilha p;
    private Figura f;
    private int x, y, ladoRaio;
    private String opcao;
    private String []figuras = {"circulo", "quadrado", "triangulo"};

    public EmpilhadorFigura(int qtdElemPilha) {
        p = new Pilha(qtdElemPilha);
        // valida while
        opcao = figura[0];
    }

    public void horaDeEmpilhar() {
        Saida.println("Informe os dados do centro das figuras");
        x = Entrada.leInt("X: ");
        y = Entrada.leInt("Y: ");

        while (figuras.contains(opcao)) {
            opcao = Entrada.leString("\nInforme uma figura a ser empilhada: ");
            Saida.println(opcao);
            switch (opcao) {
                case "quadrado":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    f = new Quadrado(ladoRaio, x, y);
                    p.empilhe(f);
                    break;
                case "circulo":
                    ladoRaio = Entrada.leInt("\nInforme o raio do circulo: ");
                    f = new Quadrado(ladoRaio, x, y);
                    p.empilhe(f);
                    break;
                default:
                    break;
            }
        }
    }

    public void mostrarFiguras() {
        Saida.print("\nImpressão em ordem de desempilhamento");

        while(!p.vazia()) {
            f = (Figura) p.desempilhe();
            f.imp();
        }
    }
}