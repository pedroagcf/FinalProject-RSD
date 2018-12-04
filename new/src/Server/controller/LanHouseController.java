package Server.controller;


import java.util.ArrayList;
import java.util.List;
//
//import Model.Filme;

import Server.model.Filme;
import Server.model.Usuario;

public class LanHouseController {
	
	private static LanHouseController ctrlLanHouse;
	private List<Usuario> listUsuario;
	
	private LanHouseController() {
		listUsuario = new ArrayList<>();
	}
	
	public static synchronized LanHouseController getInstance() {
		if(ctrlLanHouse == null)
			ctrlLanHouse = new LanHouseController();
		
		return ctrlLanHouse;
	}

	public boolean cadastrarUsuario(Usuario user) {
		if(!listUsuario.contains(user)) {
			this.listUsuario.add(user);
			return true;
		}
		
		return false;
	}
	
	public boolean rmvFilme(int userID) {
		for (Usuario u : listUsuario) {
			if(userID == u.getIdUsuario()) {
				this.listUsuario.remove(u);
				return true;
			}
		}
		return false; 
	}
	
	
	public Usuario pesquisaFilme(int userID) {
		for (Usuario u : listUsuario) {
			if(userID == u.getIdUsuario()) {
				return u;
			}
		}
		return null;
	}	
	
	public List<Usuario> listar() {
		System.out.println(this.listUsuario.size());
		return this.listUsuario;
	}
}
