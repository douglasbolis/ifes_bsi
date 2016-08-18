package entidade;

public class Grupo {
    private Pessoa[] membros;
    private int nMembros;
    private int limite;

    public Grupo(int limite) {
        this.limite = limite;
        this.membros = new Pessoa[this.limite];
        this.nMembros = 0;
    }

    public int criaMembro(String nome, int idade) {
        if (this.nMembros < this.limite) {
            this.membros[nMembros] = new Pessoa(nome, idade);
            this.nMembros += 1;
            
            return 0;
        }

        return 1;
    }
    
    public static void main(String[] args) {
        Grupo g1 = new Grupo(5);

        g1.criaMembro("João", 40);

        System.out.println(g1.membros[0].getNome());
        System.out.println(g1.membros[0].getIdade());
        System.out.println(g1.nMembros);
    }
}