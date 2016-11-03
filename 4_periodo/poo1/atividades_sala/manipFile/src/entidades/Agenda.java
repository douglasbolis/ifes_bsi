package entidades;

public class Agenda {
    private String nome;
    private Pessoa[] p;
    private int topo;

    public Agenda(String nome, int numPessoas) {
        this.nome = nome;
        this.topo = -1;
        this.p = new Pessoa[numPessoas];
    }

    public String getNome() {
        return this.nome;
    }

    public void addPessoa(Pessoa ps) {
        this.topo += 1;
        this.p[this.topo] = ps;
    }

    public Boolean rmPessoa() {
        if (vazia()) {
            this.topo -= 1;
            return true;
        } else {
            return false;
        } 
    }

    public Boolean vazia() {
        return this.topo == -1;
    }
}
