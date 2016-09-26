package entidades;

import java.math.*;
import fronteira.*;

public class Quadrado extends Figura {
    private int lado;

    public Quadrado(int x, int y, int lado) {
        super(x, y);
        this.lado = lado;
    }

    public void imp() {
        Saida.print("\nQuadrado");
        super.imp();
        Saida.println("lado = " + this.lado);
    }

    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }

    public int getLado() {
        return this.lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Double getArea() {
        return Math.pow(this.lado, 2);
    }
}