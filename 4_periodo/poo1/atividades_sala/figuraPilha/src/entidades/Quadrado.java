package entidades;

import java.math.*;
import fronteira.*;

public class Quadrado {
    private int lado;

    public Quadrado(int lado, int x, int y) {
        super(x, y);
        this.lado = lado;
    }

    public void imp() {
        Saida.println("Xinicial: " + (this.x - (this.lado / 2)));
        Saida.println("Yinicial: " + (this.y - (this.lado / 2)));
        Saida.println("XFinal: " + (this.x + (this.lado / 2)));
        Saida.println("YFinal: " + (this.x + (this.lado / 2)));
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