package entidades;

import java.math.*;
import fronteira.*;

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
        return Math.sqrt(Math.pow(this.lado, 2) - Math.pow(this.lado / 2, 2));
    }

    public void imp() {
        Saida.print("\nTriangulo");
        super.imp();
        Saida.println("lado = " + this.lado);
    }

    public Double getArea() {
        return (this.lado * getAltura()) / 2;
    }
}