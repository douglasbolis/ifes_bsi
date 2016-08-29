package entidades;

import fronteira.*;

public class EquacaoSeg {
    Double a, b, c;
    Double delta, xUm, xDois;

    // TOdo capturar valores

    public EquacaoSeg(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

/*
    void setA(Double a) {
        this.a = a;
    }

    void setB(Double b) {
        this.b = b;
    }

    void setC(Double c) {
        this.c = c;
    }
*/
    void calculaDelta() {
        this.delta = Math.pow(this.b, 2) - (4 * this.a * this.c);
    }

    void calculaRaiz() {
        this.xUm = (-this.b + Math.sqrt(this.delta)) / (2 * this.a);
        this.xDois = (-this.b - Math.sqrt(this.delta)) / (2 * this.a);
    }

    Double getXUm() {
        return this.xUm;
    }

    Double getXDois() {
        return this.xDois;
    }
}