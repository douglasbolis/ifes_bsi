package entidades;

import fronteira.*;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

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

    public void desenhe(Graphics2D g2d) {
        g2d.drawRect(getX() - getLado() / 2, getY() - getLado() / 2, getLado(), getLado());
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