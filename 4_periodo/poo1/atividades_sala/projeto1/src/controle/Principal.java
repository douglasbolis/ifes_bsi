package controle;
import fronteira.*; 
import entidade.*;
public class Principal{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Terminal t = new Terminal();
		Casa casa = new Casa();
		casa.proprietario= new Pessoa();
		String input;
		input = t.leStringdoTeclado();
		
		casa.proprietario.setNome(input);
		System.out.print(casa.proprietario.getNome());
        
	}
}