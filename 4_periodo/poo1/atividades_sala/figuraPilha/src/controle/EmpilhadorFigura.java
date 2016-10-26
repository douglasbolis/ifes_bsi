package controle;

import entidades.*;
import fronteira.*;

import java.math.*;

public class EmpilhadorFigura {
    private Pilha p;
    private Figura fAnt;
    private int x, y, ladoRaio;
    private String opcao, opMenu;
    private String[] figuras = {"1", "2", "3"}, menu = {"1", "2", "3"};
    private int[] id = new int[] { 0, 0, 0 };

    public EmpilhadorFigura() {
        p = new Pilha();
        // valida whiles
        opcao = figuras[0];
        opMenu = menu[0];
    }

    public void menuFigura() {
        while(!p.cheia() && java.util.Arrays.asList(menu).indexOf(opMenu) >= 0) {
            Saida.println("\n1 - Empilhar figura\n2 - Desenhar figuras\n3 - Deletar figura\n0 - Sair");
            opMenu = Entrada.leString("\nInforme uma opção do menu: ");

            switch (opMenu) {
                case "1":
                    horaDeEmpilhar();
                    break;
                case "2":
                    desenharFiguras();
                    break;
                case "3":
                    break;
                default:
                    break;
            }

        }
    }

    public void horaDeEmpilhar() {
        if (p.vazia()) {
            Saida.println("Informe os dados do centro das figuras");
            x = Entrada.leInt("X: ");
            y = Entrada.leInt("Y: ");
        } else {
            x = ((Figura)p.topo()).getX();
            y = ((Figura)p.topo()).getY();
        }

        if (java.util.Arrays.asList(figuras).indexOf(opcao) >= 0) {
            Saida.println("\n1 - Circulo\n2 - Quadrado\n3 - Triangulo\n0 - Sair");
            opcao = Entrada.leString("\nInforme uma figura a ser empilhada: ");
            switch (opcao) {
                case "1":
                    ladoRaio = Entrada.leInt("\nInforme o raio do circulo: ");
                    id[0] += 1;
                    Circulo nCirc = new Circulo(x, y, ladoRaio, "circ" + id[0]);

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
                                Saida.print("O raio do novo circulo precisa ser menor que " + (int) Math.ceil(t.getAltura() / 3));
                                ladoRaio = Entrada.leInt("\nInforme novamente o raio do circulo: ");
                                nCirc.setRaio(ladoRaio);
                            }
                        }
                    }
                    p.empilhe(nCirc);
                    break;
                case "2":
                    ladoRaio = Entrada.leInt("\nInforme o lado do quadrado: ");
                    id[1] += 1;
                    Quadrado nQuad = new Quadrado(x, y, ladoRaio, "quad" + id[1]);

                    if (!p.vazia()) {
                        fAnt = (Figura) p.topo();
                        if (fAnt instanceof Circulo) {
                            Circulo c = (Circulo) fAnt;
                            while(c.getRaio() <= (Math.sqrt(2) * nQuad.getLado() / 2)) {
                                Saida.print("O lado do novo quadrado precisa ser menor que " + (int) Math.ceil(c.getRaio() * 2 * (Math.sqrt(2) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do quadrado: ");
                                nQuad.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Quadrado) {
                            Quadrado q = (Quadrado) fAnt;
                            while(q.getLado() <= (Math.sqrt(2) * nQuad.getLado())) {
                                Saida.print("O lado do novo quadrado precisa ser menor que " + (int) Math.ceil(q.getLado() * (Math.sqrt(2) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do quadrado: ");
                                nQuad.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Triangulo) {
                            Triangulo t = (Triangulo) fAnt;
                            while((t.getAltura() / 3) <= (Math.sqrt(2) * nQuad.getLado() / 2)) {
                                Saida.print("O lado do novo quadrado precisa ser menor que " + (int) Math.ceil(t.getAltura() * 2 / 3 * (Math.sqrt(2) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do quadrado: ");
                                nQuad.setLado(ladoRaio);
                            }
                        }
                    }
                    p.empilhe(nQuad);
                    break;
                case "3":
                    ladoRaio = Entrada.leInt("\nInforme o lado do triangulo: ");
                    id[2] += 1;
                    Triangulo nTrian = new Triangulo(x, y, ladoRaio, "triang" + id[2]);

                    if (!p.vazia()) {
                        fAnt = (Figura) p.topo();
                        if (fAnt instanceof Circulo) {
                            Circulo c = (Circulo) fAnt;
                            while(c.getRaio() <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + (int) Math.ceil((3 * (c.getRaio() / 2)) / (Math.sqrt(3) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do triangulo: ");
                                nTrian.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Quadrado) {
                            Quadrado q = (Quadrado) fAnt;
                            while((q.getLado() / 2) <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + (int) Math.ceil((3 * (q.getLado() / 4)) / (Math.sqrt(3) / 2)));
                                ladoRaio = Entrada.leInt("\nInforme novamente o lado do triangulo: ");
                                nTrian.setLado(ladoRaio);
                            }
                        } else if (fAnt instanceof Triangulo) {
                            Triangulo t = (Triangulo) fAnt;
                            while((t.getAltura() / 3) <= ((nTrian.getAltura() * 2) / 3)) {
                                Saida.print("O lado do novo triangulo precisa ser menor que " + (int) Math.ceil(((t.getAltura() / 2)) / (Math.sqrt(3) / 2)));
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

    public void desenharFiguras() {
        new PlotFiguras2D(p);
    }
}