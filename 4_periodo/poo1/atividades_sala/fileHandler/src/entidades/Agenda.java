package entidades;

import java.io.*; 
import fronteira.*;

public class Agenda {
    private final String filename = "registroPessoas.txt";
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
        String buffer = readFile();
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(this.filename));
            topo += 1;
            // Escrevendo pessoas existentes
            w.write(buffer);
            // Escrevendo nova pessoa no arquivo
            w.write("id: " + topo + "\n");
            w.write("nome: " + ps.getNome() + "\n");
            w.write("email: " + ps.getEmail() + "\n");
            w.write("telefone: " + ps.getTelefone() + "\n");
            w.write("data de nascimento: " + ps.getDataNasc() + "\n");
            w.write("\n");
            Saida.println("Pessoa adicionada!");
        } catch (IOException e) {
            System.out.println("Erro de I/O");
            e.printStackTrace();
        } finally {
            if (w != null) try {
                w.close();
            } catch (IOException ex) {
                System.out.println("Arquivo não encontrado: " + ex);
            }
        }
    }

    public String readFile() {
        String linha;
        String buffer = new String();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.filename));
            linha = reader.readLine();
            while (linha != null) {
                buffer += linha + "\n";
                linha = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro de I/O");
            e.printStackTrace();
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Arquivo não encontrado: " + ex);
            }
        }
        return buffer;
    }

    public void showPessoas() {
        Saida.print(readFile());
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
