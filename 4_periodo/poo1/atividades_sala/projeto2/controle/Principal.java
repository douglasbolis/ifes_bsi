package controle;

import entidade.*;

public class Principal {
    public static void main(String[] args) {
        Grupo grupo = new Grupo();

        grupo.criaMembro("João", 40);

        System.out.print(grupo.membros[0].getNome());
        System.out.print(grupo.membros[0].getIdade());
        System.out.print(grupo.nMembros);
    }
}