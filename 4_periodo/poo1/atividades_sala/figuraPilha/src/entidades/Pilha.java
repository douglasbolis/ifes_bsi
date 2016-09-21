package entidades;

public class Pilha {
    private int topo, tam;
    private Object elem;
    private Object []vet;

    public Pilha(int tamMax) {
        vet = new Object[tamMax];
        tam = tamMax;
        topo = -1;
    }

    public int getTamMax() {
        return tam;
    }

    public boolean empilhe(Object elem) {
        if (cheia()) return false;
        topo += 1;
        vet[topo] = elem;
        return true;
    }

    public Object desempilhe() {
        if ( topo < 0 ) return -1;
        elem = vet[topo];
        topo -= 1;
        return elem;
    }

    public Object topo() {
        return vet[topo];
    }

    public void limpaPilha() {
        topo = -1;
    }

    public boolean cheia() {
        return (topo >= tam - 1);
    }

    public boolean vazia() {
        return topo < 0;
    }
}
