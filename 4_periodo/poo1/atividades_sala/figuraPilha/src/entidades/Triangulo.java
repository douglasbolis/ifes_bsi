package entidades;

import fronteira.*;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class Triangulo extends Figura {
    private int lado;

    public Triangulo(int x, int y, int lado) {
        super(x, y);
        this.lado = lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return this.lado;
    }

    public Double getAltura() {
        return Math.sqrt(Math.pow(this.lado, 2) - Math.pow((this.lado / 2), 2));
    }

    public void imp() {
        Saida.print("\nTriangulo");
        super.imp();
        Saida.println("lado = " + this.lado);
    }

    public void desenhe(Graphics2D g2d) {
        Double a = 1.0, b = 2.0, div = 3.0;

        int[] lstPointX = new int[] {
            getX(), // x1
            (getX() + (getLado() / 2)), // x2
            (getX() - (getLado() / 2)) // x3
        },
        lstPointY = new int[] {
            (getY() - (int)Math.round(b / div * getAltura())), // y1
            (getY() + (int)Math.round(a / div * getAltura())), // y2
            (getY() + (int)Math.round(a / div * getAltura())) // y3
        };

        g2d.drawPolygon(lstPointX, lstPointY, 3);
    }

    public Double getArea() {
        return (this.lado * getAltura()) / 2;
    }

    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }
}