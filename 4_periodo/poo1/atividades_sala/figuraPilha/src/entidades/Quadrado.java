package entidades;

import java.math.*;

public class Figura {
    // x e y iniciais
    private int xi, yi, lado;

    public Figura(int xi, int yi, int lado, int x, int y) {
        super(x, y);
        this.xi = xi;
        this.yi = yi;
        this.lado = lado;
    }

    public void imp() {
        Saida.println("Xinicial: " + this.xi);
        Saida.println("Yinicial: " + this.yi);
        Saida.println("XFinal: " + (this.xi + this.lado));
        Saida.println("YFinal: " + (this.yi + this.lado));
        super.imp();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getLado() {
        return this.lado;
    }

    public int getArea() {
        return Math.pow(this.lado, 2);
    }
}