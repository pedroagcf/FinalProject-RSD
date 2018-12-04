package Server.model;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
	
	private String nomeLocadora = "Locadora do Bairro";
	private List<Filme> listaFilmes;
	
	public Locadora() {
		this.listaFilmes = new ArrayList<>();
		
	}

	public String getNomeLocadora() {
		return nomeLocadora;
	}

	public void setNomeLocadora(String nomeLocadora) {
		this.nomeLocadora = nomeLocadora;
	}

	public List<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(List<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}
}
