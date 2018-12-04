package Server.controller;


import java.lang.reflect.Method;
//
//import Model.Request;
//import Model.Response;

import Server.model.Request;
import Server.model.Response;

public class Despachante {
	
	private ControlJson ctrlJson;
	private Class objeto;
	private Method method;

	public Despachante() {
		this.ctrlJson = new ControlJson();
	}
	
	public String invoke(String msg) throws Exception{
		
		Request rqst = (Request) ctrlJson.fromJson(msg, Request.class);
		
		String [] classAndMethod = rqst.getMethod().split("[\\W]");
		
		String classRequest = classAndMethod[0];
		String methodRequest = classAndMethod[1];
		
		objeto = Class.forName("Server.controller.Esqueleto" + classRequest);
		method = objeto.getMethod(methodRequest, String.class);
	
		Response rsp = (Response) method.invoke(objeto.newInstance(), rqst.getData());
		
		return ctrlJson.parseJson(rsp);
	}
	
}
