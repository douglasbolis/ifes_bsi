package entidade;

public class Grupo {
    private Pessoa[] membros;
    private int nMembros;

    public Grupo() {
        membros = new Pessoa[100];
        nMembros = 0;
    }

    public int criaMembro(String nome, int idade) {
        membros[nMembros] = new Pessoa(nome, idade);
        nMembros += 1;
        
        return 0;
    }
    
    public static void main(String[] args) {
        Grupo g1 = new Grupo();

        g1.criaMembro("João", 40);

        System.out.println(g1.membros[0].getNome());
        System.out.println(g1.membros[0].getIdade());
        System.out.println(g1.nMembros);
    }
}