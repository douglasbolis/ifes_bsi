import controle.*;

public class Principal {
    public static void main(String[] args) {
        FileHandler fh = new FileHandler(10);
        
        fh.startHandling();
    }
}
