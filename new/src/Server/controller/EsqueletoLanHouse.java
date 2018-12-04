package Server.controller;

import Server.model.Filme;
import Server.model.Response;
import Server.model.Usuario;

public class EsqueletoLanHouse {
	
	private ControlJson ctrlJson;
	private LanHouseController ctrlLanHouse;
	private Response response;
	
	public EsqueletoLanHouse() {
		
		this.ctrlJson = new ControlJson();
		this.ctrlLanHouse = LanHouseController.getInstance();	
	}
	
	public Response cadastrar(String UsuarioJson) {
		Usuario u = (Usuario) ctrlJson.fromJson(UsuarioJson, Usuario.class);
		
		if(ctrlLanHouse.cadastrarUsuario(u)) {
			response = new Response("Usuario cadastrado! :D");
		} else {
			response = new Response("Erro | cadastro cancelado :x");
		}
		
		return response;
	}
	
	public Response remover(String usuarioJson) {
		Usuario u = (Usuario) ctrlJson.fromJson(usuarioJson, Usuario.class);
		
		if (ctrlLanHouse.rmvFilme(u.getIdUsuario())) {
			response = new Response("Usuario removido! :D");
		
		} else {
			response = new Response("Erro | remoçao cancelada :x");
		}
		
		return response;
	}
	
	public Response pesquisar(String usuarioJson) {
		Usuario u = (Usuario) ctrlJson.fromJson(usuarioJson, Usuario.class);
		
		try {
			 String usuario = this.ctrlJson.parseJson(ctrlLanHouse.pesquisaFilme(u.getIdUsuario()));
		     return new Response("Usuario encontrado: ", usuario);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}
	 
	
	public Response listar(String usuarioJson) {
		String u = ctrlJson.parseJson(ctrlLanHouse.listar());
		return new Response("lista de usuarios: ", u);
	}
	
}
