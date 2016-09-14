package controle;

import entidades.*;
import fronteira.*;

public class Jogo {
    private int tamPilha, ctrl;
    private Boolean achou;
    private Pilha p;
    private Jogador j1;
    private Jogador j2;

    public Jogo(int tamPilha) {
        p = new Pilha(tamPilha);
        j1 = new Jogador();
        j2 = new Jogador();
        ctrl = 0;
        achou = false;
    }

    public void jogar() {
        // Jogador 1 digitando os ${tamPilha} numeros
        Saida.print("Vez do jogador 1\n");
        Saida.print("Digite " + p.getTamMax() + " números\n");

        for (int x = 0; x < p.getTamMax(); x++) {
            p.empilhe(Entrada.leInt((x + 1) + "º: "));
        }
        
        // Jogador 2 tentando adivinhar um dos números informados pelo Jogador 1
        Saida.print("\nVez do jogador 2\n");
        j2.setNumEscolhido(Entrada.leInt("Digite um número que esteja na pilha: "));
        
        calculaPontuacao(p, j2, ctrl, achou);

        // Zerando controles
        ctrl = 0;
        achou = false;
        
        Saida.print("\nPontuação Jogador 2: " + j2.getPontuacao() + "\n");
    }

    private void calculaPontuacao(Pilha p, Jogador j, int ctrl, Boolean achou) {
        while(!p.vazia() && !achou) {
            if(j.getNumEscolhido() == p.topo()) {
                j.setPontuacao(p.getTamMax() - ctrl);
                achou = true;
            } else {
                ctrl += 1;
                p.desempilhe();
            }
        }

        if (p.vazia()) j.setPontuacao(0);
    }
}