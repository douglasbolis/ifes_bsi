package entidades;

import fronteira.*;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

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

    public void desenhe(Graphics2D g2d) {
        g2d.drawOval(getX() - getRaio() ,  getY() - getRaio() ,  2*getRaio() ,  2*getRaio());
    }

    public Double getArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }
}