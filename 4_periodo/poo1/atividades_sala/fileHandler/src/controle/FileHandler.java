package controle;

import java.util.*;

import entidades.*;
import fronteira.*;

public class FileHandler {
    private int numPessoas;
    private Agenda agenda;

    public FileHandler(int numPessoas) {
        this.agenda = new Agenda("", numPessoas);
        this.numPessoas = numPessoas;
    }

    public void startHandling() {
        Saida.println("Agenda telefônica");
        
        Pessoa pessoa = new Pessoa("João", "joao@mail.com", "911223344", new Date());

        agenda.addPessoa(pessoa);
        agenda.addPessoa(pessoa);
        agenda.addPessoa(pessoa);
        agenda.addPessoa(pessoa);
        agenda.showPessoas();
    }
}
