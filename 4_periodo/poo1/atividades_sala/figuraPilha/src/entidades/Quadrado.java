package entidades;

import java.math.*;
import fronteira.*;

public class Quadrado extends Figura {
    private int lado;

    public Quadrado(int lado, int x, int y) {
        super(x, y);
        this.lado = lado;
    }

    public void imp() {
        Saida.println("Xinicial: " + (super.getX() - (this.lado / 2)));
        Saida.println("Yinicial: " + (super.getY() - (this.lado / 2)));
        Saida.println("XFinal: " + (super.getX() + (this.lado / 2)));
        Saida.println("YFinal: " + (super.getY() + (this.lado / 2)));
        super.imp();
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

    public Double getArea() {
        return Math.pow(this.lado, 2);
    }
}