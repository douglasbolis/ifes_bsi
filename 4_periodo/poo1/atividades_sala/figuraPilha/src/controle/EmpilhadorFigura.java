package controle;

import entidades.*;
import fronteira.*;

public class EmpilhadorFigura {
    private Pilha p;
    private Figura f, fAux;
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

                    if (p.vazia()) {
                        p.empilhe(f);
                    } else {
                        fAux = (Figura) p.topo();
                        if (fAux instanceof Circulo) {
                            if (fAux.raio > f.raio) {
                                p.empilhe(f);
                            } else {
                                
                            }
                        } else if (fAux instanceof Quadrado) {

                        } else if (fAux instanceof Triangulo) {
                            
                        }
                    }
                    break;
                case "quadrado":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    f = new Quadrado(x, y, ladoRaio);

                    if (p.vazia()) {
                        p.empilhe(f);
                    } else {
                        fAux = (Figura) p.topo();
                    }
                    break;
                case "triangulo":
                    ladoRaio = Entrada.leInt("\nInforme o lado do triangulo: ");
                    f = new Triangulo(x, y, ladoRaio);

                    if (p.vazia()) {
                        p.empilhe(f);
                    } else {
                        fAux = (Figura) p.topo();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void mostrarFiguras() {
        new PlotFiguras2D(p);
        // Saida.println("\nImpressão em ordem de desempilhamento");

        // while(!p.vazia()) {
        //     f = (Figura) p.desempilhe();
        //     f.imp();
        // }
    }
}