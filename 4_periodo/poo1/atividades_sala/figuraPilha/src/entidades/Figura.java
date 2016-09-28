package entidades;

import fronteira.*;

import java.awt.*;
import java.awt.event.*;

public class Figura {
    private int x, y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void imp() {
        Saida.println( "\nCentro(" + this.x + ", " + this.y + ")" );
    }

    public void desenhe(Graphics2D g2d) { }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}