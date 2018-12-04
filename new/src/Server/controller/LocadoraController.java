package Server.controller;


import java.util.ArrayList;
import java.util.List;
//
//import Model.Filme;

import Server.model.Filme;

public class LocadoraController {
	
	private static LocadoraController ctrlLocadora;
	private List<Filme> listFilmes;
	
	private LocadoraController() {
		listFilmes = new ArrayList<>();
	}
	
	public static synchronized LocadoraController getInstance() {
		if(ctrlLocadora == null)
			ctrlLocadora = new LocadoraController();
		
		return ctrlLocadora;
	}

	public boolean cadastrarFilme(Filme filme) {
		if(!listFilmes.contains(filme)) {
			this.listFilmes.add(filme);
			return true;
		}
		
		return false;
	}
	
	public boolean rmvFilme(int filmeID) {
		for (Filme f : listFilmes) {
			if(filmeID == f.getIdFilme()) {
				this.listFilmes.remove(f);
				return true;
			}
		}
		return false; 
	}
	
	
	public Filme pesquisaFilme(int filmeID) {
		for (Filme f : listFilmes) {
			if(filmeID == f.getIdFilme()) {
				return f;
			}
		}
		return null;
	}	
	
	public List<Filme> listar() {
		System.out.println(this.listFilmes.size());
		return this.listFilmes;
	}
}
