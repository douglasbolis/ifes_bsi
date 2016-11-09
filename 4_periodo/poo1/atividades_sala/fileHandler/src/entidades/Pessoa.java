package entidades;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String email;
    private String telefone;
    private Date dataNasc;

    public Pessoa(String nome, String email, String telefone, Date dataNasc) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public Date getDataNasc() {
        return this.dataNasc;
    }

}
