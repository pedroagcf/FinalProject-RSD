package Client.Controller;

import java.util.List;

import Client.Model.ProxyLanHouse;
import Client.Model.Request;
import Client.Model.Response;
import Client.facade.FaixadaCliente;
import Server.model.Usuario;
import client.Interface.crudService;

public class ControlProxyLanHouse implements crudService<Usuario> {

	private FaixadaCliente fxdaCli;
	
	public ControlProxyLanHouse() {
		fxdaCli = new FaixadaCliente();
	}

	@Override
	public String cadastrar(int idUser, String nome, String senha) {
		
		ProxyLanHouse prxLan = new ProxyLanHouse(idUser, nome, senha);
		
		String data = fxdaCli.getCodificadorJSON().codificar(prxLan);
		Request request = new Request("LanHouse.cadastrar", data);
		String pacote = fxdaCli.getCodificadorJSON().codificar(request);
		
		fxdaCli.getTCPCtrlClient().enviarDado(pacote);
		Response response = (Response) fxdaCli.getCodificadorJSON().descodificar(fxdaCli.getTCPCtrlClient().receberDado(), Response.class);
		
		return response.getMsg();
	}

	@Override
	public String remover(int idUser) {
		
		ProxyLanHouse pxLoc = new ProxyLanHouse(idUser);
		
		String data = fxdaCli.getCodificadorJSON().codificar(pxLoc);	
		Request request = new Request("LanHouse.remover", data);
		String pacote = fxdaCli.getCodificadorJSON().codificar(request);
		
		fxdaCli.getTCPCtrlClient().enviarDado(pacote);
		Response response = (Response) fxdaCli.getCodificadorJSON().descodificar(fxdaCli.getTCPCtrlClient().receberDado(), Response.class);

		return response.getMsg();
		
	}

	@Override
	public String pesquisar(int idUser) {
	
		ProxyLanHouse locdraProxy = new ProxyLanHouse(idUser);
		
		String data = fxdaCli.getCodificadorJSON().codificar(locdraProxy);			
		Request request = new Request("Locadora.pesquisar", data);
		String pacote = fxdaCli.getCodificadorJSON().codificar(request);
		
		fxdaCli.getTCPCtrlClient().enviarDado(pacote);
		Response response = (Response) fxdaCli.getCodificadorJSON().descodificar(fxdaCli.getTCPCtrlClient().receberDado(), Response.class);
				
//		ctrlClientTCP.sendRequest(ControlJson.createJson(request));
//		Response response = (Response) ControlJson.fromJson(ctrlClientTCP.getReponse(), Response.class);
//		
		return response.getData();
	
	} 
	
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}


}
