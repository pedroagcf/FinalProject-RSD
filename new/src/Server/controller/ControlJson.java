package Server.controller;


import com.google.gson.Gson;

public class ControlJson {
	
	private Gson gson;
	
	public ControlJson() {
		this.gson = new Gson();
	}

	public String parseJson(Object obj) {
		return this.gson.toJson(obj);
	}
	
	public Object fromJson(String json, Class nomeClass) {
		return gson.fromJson(json, nomeClass);
	}
	
}

