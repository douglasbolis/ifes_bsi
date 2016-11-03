package controle;

import entidades.*;

public class FileHandler {
    private int final numPessoas = 10;
    private Agenda agenda;

    public FileHandler() {
        this.agenda = new Agenda(numPessoas);
    }

    public void startHandling() {

    }
}