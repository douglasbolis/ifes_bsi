package controle;

import entidades.*;
import fronteira.*;

import java.math.*;

public class EmpilhadorFigura {
    private Pilha p;
    private Figura fAnt;
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
                    Circulo nCirc = new Circulo(x, y, ladoRaio);

                    if (!p.vazia()) {
                        fAnt = (Figura) p.topo();
                        if (fAnt instanceof Circulo) {
                            Circulo c = (Circulo) fAnt;
                            while(c.getRaio() <= nCirc.getRaio()) {
                                Saida.print("O raio do novo circulo precisa ser menor que " + c.getRaio());
                                ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                                nCirc.setRaio(ladoRaio);
                            }
                        } else if (fAnt instanceof Quadrado) {
                            Quadrado q = (Quadrado) fAnt;
                            while(q.getLado() <= (nCirc.getRaio() * 2)) {
                                Saida.print("O raio do novo circulo precisa ser menor que " + (q.getLado() / 2));
                                ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                                nCirc.setRaio(ladoRaio);
                            }
                        } else if (fAnt instanceof Triangulo) {
                            Triangulo t = (Triangulo) fAnt;
                            while((t.getAltura() / 3) <= nCirc.getRaio()) {
                                Saida.print("O raio do novo circulo precisa ser menor que " + Math.round(t.getAltura() / 3));
                                ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                                nCirc.setRaio(ladoRaio);
                            }
                        }
                    }
                    p.empilhe(nCirc);
                    break;
                case "quadrado":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    Quadrado nQuad = new Quadrado(x, y, ladoRaio);
                    p.empilhe(nQuad);
                    break;
                case "triangulo":
                    ladoRaio = Entrada.leInt("\nInforme o lado do triangulo: ");
                    Triangulo nTrian = new Triangulo(x, y, ladoRaio);

                    if (!p.vazia()) {
                        fAnt = (Figura) p.topo();
                        if (fAnt instanceof Circulo) {
                            Circulo c = (Circulo) fAnt;
                            while(c.getRaio() <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + Math.round((3 * (c.getRaio() / 2)) / (Math.sqrt(3) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do triangulo: ");
                                nTrian.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Quadrado) {
                            Quadrado q = (Quadrado) fAnt;
                            while((q.getLado() / 2) <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + Math.round((3 * (q.getLado() / 4)) / (Math.sqrt(3) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do triangulo: ");
                                nTrian.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Triangulo) {
                            Triangulo t = (Triangulo) fAnt;
                            while((t.getAltura() / 3) <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + Math.round(((t.getAltura() / 2)) / (Math.sqrt(3) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do triangulo: ");
                                nTrian.setLado(ladoRaio);
                            }
                        }
                    }
                    p.empilhe(nTrian);
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