package entidade;

import java.util.ArrayList;

public class Instancia {
    private int id;
    private String descricao;
    private ArrayList<TipoRecurso> mapaAlocRecursos;

	public Instancia(int id, String descricao, ArrayList<TipoRecurso> mapaAlocRecursos) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setMapaAlocRecursos(mapaAlocRecursos);
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
	 * @return the mapaAlocRecursos
	 */
	public ArrayList<TipoRecurso> getMapaAlocRecursos() {
		return mapaAlocRecursos;
	}

	/**
	 * @param mapaAlocRecursos the mapaAlocRecursos to set
	 */
	public void setMapaAlocRecursos(ArrayList<TipoRecurso> mapaAlocRecursos) {
		this.mapaAlocRecursos = mapaAlocRecursos;
	}
}
