package entidades;

import java.math.*;
import fronteira.*;

public class Circulo extends Figura {
    private int raio;

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
        Saida.print("\nCirculo");
        super.imp();
        Saida.println("raio = " + this.raio);
    }

    public Double getArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }
}