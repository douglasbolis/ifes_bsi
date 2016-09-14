package entidades;

public class Pilha {
    private static final int Max = 100;
    private int topo, tam, elem;
    private int []vet;

    public Pilha(int tamMax) {
        vet = new int[tamMax];
        tam = tamMax;
        topo = -1;
    }

    public int getTamMax() {
        return vet.length;
    }

    public boolean empilhe(int elem) {
        if ( topo >= tam - 1) return false;
        topo += 1;
        vet[topo] = elem;
        return true;
    }

    public int desempilhe() {
        if ( topo < 0 ) return -1;
        elem = vet[topo];
        topo -= 1;
        return elem;
    }

    public int topo() {
        return vet[topo];
    }

    public void limpaPilha() {
        topo = -1;
    }

    public boolean vazia() {
        return topo < 0;
    }
}
