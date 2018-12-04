package Server.controller;
import java.util.List;

import Server.Interface.CrudServer;
import Server.model.Filme;
import Server.model.Response;

//import Model.Filme;
//import Model.Response;

//aqui eu vou alterar o nome pra locadoraCrud e implementar uma interface generica que sirva tanto pra locadora quanto pra lanhouse.
public class LocadoraCrud implements CrudServer {
	
	private ControlJson ctrlJson;
	private LocadoraController ctrlLocadora;
	private Response response;
	
	public void EsqueletoLocadora() {
		
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
			 String filmeSerializado = this.ctrlJson.parseJson(ctrlLocadora.pesquisaFilme(f.getIdFilme()));
		     return new Response("Filme encontrado: ", filmeSerializado);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}

	@Override
	public boolean cadastrar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pesquisar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
}
