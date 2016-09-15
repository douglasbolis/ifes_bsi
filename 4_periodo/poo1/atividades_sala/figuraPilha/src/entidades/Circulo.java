package entidades;

import java.math.*;

public class Circulo extends Figura {
    private raio;

    public Circulo(int x, int y, int raio) {
        super(x, y);
        this.raio = raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getRaio() {
        return this.raio;
    }

    public void imp() {
        Saida.println("raio = " + this.raio);
        super.imp();
    }

    public float getArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }
}