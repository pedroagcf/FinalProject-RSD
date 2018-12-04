package Client.Controller;

import com.google.gson.Gson;

import client.Interface.Codificador;

public class CodificadorJson implements Codificador {

	@Override
	public String codificar(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	@Override
	public Object descodificar(String json, Class c) {
		Gson gson = new Gson();
		return gson.fromJson(json, c);
	}	
}
