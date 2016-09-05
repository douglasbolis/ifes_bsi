package entidades;

public class EquacaoPri {
    Double a, b, raiz;

    public EquacaoPri(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    // TOdo capturar valores

    Double calculaRaiz() {
        this.raiz = (-this.b) / this.a;
    }
}