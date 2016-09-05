package entidades;

public class Dados {
    private Par[] pares;
    private int nPares, tamMax;

    public Dados(int n) {
        this.pares = new Par[n];
        this.tamMax = n;
        this.nPares = 0;
    }

    public Par getPar(int n) {
        return this.pares[n];
    }

    public int getTamMax() {
        return this.tamMax;
    }

    public int getNPares() {
        return this.nPares;
    }

    public void addPar(Double a, Double b) { 
        this.pares[this.nPares] = new Par(a, b);
        this.nPares += 1;
    }
}