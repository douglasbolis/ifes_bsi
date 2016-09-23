package controle;

import entidades.*;
import fronteira.*;

public class EmpilhadorFigura {
    private Pilha p;
    private Figura f, fAnt;
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

                    // if (!p.vazia()) {
                    //     fAnt = (Figura) p.topo();
                    //     if (fAnt instanceof Circulo) {
                    //         while(fAnt.getRaio() <= f.getRaio()) {
                    //             Saida.print("O raio do novo circulo precisa ser menor que " + fAnt.getRaio());
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                    //             f.setRaio(ladoRaio);
                    //         }
                    //     } else if (fAnt instanceof Quadrado) {
                    //         while(fAnt.getLado() <= (f.getRaio() * 2)) {
                    //             Saida.print("O raio do novo circulo precisa ser menor que " + (fAnt.getLado() / 2));
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                    //             f.setRaio(ladoRaio);
                    //         }
                    //     } else if (fAnt instanceof Triangulo) {
                    //         while((fAnt.getAltura() / 3) <= f.getRaio())) {
                    //             Saida.print("O raio do novo circulo precisa ser menor que " + (fAnt.getAltura() / 3));
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                    //             f.setRaio(ladoRaio);
                    //         }
                    //     }
                    // }
                    p.empilhe(f);
                    break;
                case "quadrado":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    f = new Quadrado(x, y, ladoRaio);

                    // if (!p.vazia()) {
                    //     fAnt = (Figura) p.topo();
                    //     if (fAnt instanceof Circulo) {
                    //         while(fAnt.getRaio() <= f.getRaio()) {
                    //             Saida.print("O raio do novo circulo precisa ser menor que " + fAnt.getRaio());
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                    //             f.setRaio(ladoRaio);
                    //         }
                    //     } else if (fAnt instanceof Quadrado) { // OK
                    //         while(fAnt.getLado() <= f.getLado()) {
                    //             Saida.print("O lado do novo quadrado precisa ser menor que " + f.getLado());
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o lado do quadrado: ");
                    //             f.setLado(ladoRaio);
                    //         }
                    //     } else if (fAnt instanceof Triangulo) {
                    //         while((fAnt.getAltura() / 3) <= f.getRaio())) {
                    //             Saida.print("O raio do novo circulo precisa ser menor que " + (fAnt.getAltura() / 3));
                    //             ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                    //             f.setRaio(ladoRaio);
                    //         }
                    //     }
                    // }
                    p.empilhe(f);
                    break;
                case "triangulo":
                    ladoRaio = Entrada.leInt("\nInforme o lado do triangulo: ");
                    f = new Triangulo(x, y, ladoRaio);
                    p.empilhe(f);

                    // if (p.vazia()) {
                    // } else {
                    //     fAnt = (Figura) p.topo();
                    // }
                    break;
                default:
                    break;
            }
        }
    }

    public void mostrarFiguras() {
        new PlotFiguras2D(p);
    }
}