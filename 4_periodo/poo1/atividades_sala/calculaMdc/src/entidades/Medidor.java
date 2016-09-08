package entidades;

import fronteira.*;

public class Medidor {
    public static void main(String[] args) {
        Par par;
        Double a, b, resultadoMdcR, resultadoMdcI;
        long tempoInicial, tempoFinal, tempoR, tempoI;

        Mdc mdc = new Mdc();
        Dados dados = new Dados(2);

        for (int x = 0; x < dados.getTamMax(); x++) {
            a = Entrada.leCoeficiente("Digite o valor de A: ");
            b = Entrada.leCoeficiente("Digite o valor de B: ");

            dados.addPar(a, b);
            
            par = dados.getPar(x);
            a = par.getValueA();
            b = par.getValueB();

            // Calculando mdc recursivo e armazenando o tempo de processamento
            tempoInicial = System.currentTimeMillis();
            resultadoMdcR = mdc.calculaMdcR(a, b);
            tempoFinal = System.currentTimeMillis();

            tempoR = (tempoFinal - tempoInicial) / 1000;

            // Calculando mdc iterativo e armazenando o tempo de processamento
            tempoInicial = System.currentTimeMillis();
            resultadoMdcI = mdc.calculaMdcI(a, b);
            tempoFinal = System.currentTimeMillis();

            tempoI = (tempoFinal - tempoInicial) / 1000;
            
            // Imprimindo resultados
            Saida.print("\n · Mdc recursivo de " + a + " e " + b + ": " + resultadoMdcR);
            Saida.print("\n · Tempo de recursivo: " + tempoR + " seg");
            Saida.print("\n · Mdc iterativo de " + a + " e " + b + ": " + resultadoMdcI);
            Saida.print("\n · Tempo de iterativo: " + tempoI + " seg\n\n");
        }
        // System.out.printf("Mdc iterativo: " + mdc.calculaMdcI(a, b) + "\n");
    }
    
}