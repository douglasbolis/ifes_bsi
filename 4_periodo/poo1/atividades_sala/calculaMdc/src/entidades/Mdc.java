package entidades;

public class Mdc {
    private Double q, r;

    Double calculaMdcR(Double a, Double b) {
        if (b == 0) {
            return a;
        } else {
            return calculaMdcR(b, a % b);
        }
    }

    Double calculaMdcI(Double a, Double b) {
        while(b != 0) {
            q = a / b;
            r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}