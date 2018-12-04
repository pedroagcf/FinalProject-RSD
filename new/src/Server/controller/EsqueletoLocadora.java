package Server.controller;

import Server.model.Filme;
import Server.model.Response;

public class EsqueletoLocadora {
	
	private ControlJson ctrlJson;
	private LocadoraController ctrlLocadora;
	private Response response;
	
	public EsqueletoLocadora() {
		
		this.ctrlJson = new ControlJson();
		this.ctrlLocadora = LocadoraController.getInstance();	
	}
	
	public Response cadastrar(String filmeJson) {
		Filme f = (Filme) ctrlJson.fromJson(filmeJson, Filme.class);
		
		if(ctrlLocadora.cadastrarFilme(f)) {
			response = new Response("Filme cadastrado! :D");
		} else {
			response = new Response("Erro | cadastro cancelado :x");
		}
		
		return response;
	}
	
	public Response remover(String filmeJson) {
		Filme f = (Filme) ctrlJson.fromJson(filmeJson, Filme.class);
		
		if (ctrlLocadora.rmvFilme(f.getIdFilme())) {
			response = new Response("Filme removido! :D");
		
		} else {
			response = new Response("Erro | remoçao cancelada :x");
		}
		
		return response;
	}
	
	public Response pesquisar(String filmeJson) {
		Filme f = (Filme) ctrlJson.fromJson(filmeJson, Filme.class);
		
		try {
			 String filme = this.ctrlJson.parseJson(ctrlLocadora.pesquisaFilme(f.getIdFilme()));
		     return new Response("Filme encontrado: ", filme);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}
	 
	
	public Response listar(String filmeJson) {
		String f = ctrlJson.parseJson(ctrlLocadora.listar());
		return new Response("lista de filmes", f);
	}
	
}
