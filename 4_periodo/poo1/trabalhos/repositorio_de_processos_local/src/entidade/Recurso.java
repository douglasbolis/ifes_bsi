package entidade;

public class Recurso {
	private int id;
	private TipoRecurso tipo;
	private String nome;
	private String descricao;
	
	public Recurso(int id, TipoRecurso tipo, String nome, String descricao) {
		this.setId(id);
		this.setTipo(tipo);
		this.setNome(nome);
		this.setDescricao(descricao);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the tipo
	 */
	public TipoRecurso getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoRecurso tipo) {
		this.tipo = tipo;
	}
}
