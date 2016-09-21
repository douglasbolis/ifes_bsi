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
        opcao = figuras[0];
    }

    public void horaDeEmpilhar() {
        Saida.println("Informe os dados do centro das figuras");
        x = Entrada.leInt("X: ");
        y = Entrada.leInt("Y: ");

        while (!p.cheia() && java.util.Arrays.asList(figuras).indexOf(opcao) >= 0) {
            opcao = Entrada.leString("\nInforme uma figura a ser empilhada: ");
            switch (opcao) {
                case "circulo":
                    ladoRaio = Entrada.leInt("\nInforme o raio do circulo: ");
                    f = new Circulo(x, y, ladoRaio);
                    p.empilhe(f);
                    break;
                case "quadrado":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    f = new Quadrado(x, y, ladoRaio);
                    p.empilhe(f);
                    break;
                case "triangulo":
                    ladoRaio = Entrada.leInt("\nInforme o lado do triangulo: ");
                    f = new Triangulo(x, y, ladoRaio);
                    p.empilhe(f);
                    break;
                default:
                    break;
            }
        }
    }

    public void mostrarFiguras() {
        new Example01(p);
        // Saida.println("\nImpressão em ordem de desempilhamento");

        // while(!p.vazia()) {
        //     f = (Figura) p.desempilhe();
        //     f.imp();
        // }
    }
}