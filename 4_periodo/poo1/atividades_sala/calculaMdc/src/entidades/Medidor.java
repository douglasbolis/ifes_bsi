package entidades;

public class Medidor {
    public static void main(String[] args) {
        Double a, b;
        Mdc mdc = new Mdc();
        Dados dados = new Dados(5);
        Par par;
        
        dados.addPar(59.0, 26.0);
        par = dados.getPar(0);

        a = par.getValueA();
        b = par.getValueB();

        System.out.printf("Mdc recursivo: " + mdc.calculaMdcR(a, b) + "\n");
        System.out.printf("Mdc iterativo: " + mdc.calculaMdcI(a, b) + "\n");
    }
    
}