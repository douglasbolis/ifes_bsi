package entidades;

import fronteira.*;

public class Figura {
    private int x, y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void imp() {
        Saida.println( "Centro(" + this.x + ", " + this.y + ")" );
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}