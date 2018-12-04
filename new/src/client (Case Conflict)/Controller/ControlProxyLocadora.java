package Client.Controller;

import java.util.List;
import java.util.Map;

import Client.Model.ProxyLocadora;
import Client.Model.Request;
import Client.Model.Response;
import Client.facade.FaixadaCliente;
import Server.model.Filme;
import Server.model.Locadora;
import client.Interface.crudService;

public class ControlProxyLocadora implements crudService<Filme>{
//		private TCPControlClient ctrlClientTCP;
//		private Codificador codificadorJSON = new CodificadorJson();
//		
		private FaixadaCliente fxdacli;

		public ControlProxyLocadora() {
			this.fxdacli = new FaixadaCliente();	
		}

		
//		public ControlProxyLocadora(TCPControlClient ctrlClientTCP) {
//			this.ctrlClientTCP = ctrlClientTCP;
//		}


		@Override
		public String cadastrar(int id, String nome, String genero) {
			
			ProxyLocadora pxLoc = new ProxyLocadora(id, nome, genero);
			
			String data = fxdacli.getCodificadorJSON().codificar(pxLoc);
			Request req = new Request("Locadora.cadastrar", data);
			String pacote = fxdacli.getCodificadorJSON().codificar(req);
			
			fxdacli.getTCPCtrlClient().enviarDado(pacote);
			Response response = (Response) fxdacli.getCodificadorJSON().descodificar(fxdacli.getTCPCtrlClient().receberDado(), Response.class);
			
			return response.getMsg();
		}


		@Override
		public String remover(int idFilme) {
			ProxyLocadora pxLoc = new ProxyLocadora(idFilme);
			
			String data = fxdacli.getCodificadorJSON().codificar(pxLoc);			
			Request request = new Request("Locadora.remover", data);
			String pacote = fxdacli.getCodificadorJSON().codificar(request);
			
			fxdacli.getTCPCtrlClient().enviarDado(pacote);
			Response response = (Response) fxdacli.getCodificadorJSON().descodificar(fxdacli.getTCPCtrlClient().receberDado(), Response.class);

			return response.getMsg();
		}

		@Override
		public String pesquisar(int idFilme) {
			ProxyLocadora locdraProxy = new ProxyLocadora(idFilme);
			
			String data = fxdacli.getCodificadorJSON().codificar(locdraProxy);			
			Request request = new Request("Locadora.pesquisar", data);
			String pacote = fxdacli.getCodificadorJSON().codificar(request);
			
			fxdacli.getTCPCtrlClient().enviarDado(pacote);
			Response response = (Response) fxdacli.getCodificadorJSON().descodificar(fxdacli.getTCPCtrlClient().receberDado(), Response.class);
					
//			ctrlClientTCP.sendRequest(ControlJson.createJson(request));
//			Response response = (Response) ControlJson.fromJson(ctrlClientTCP.getReponse(), Response.class);
//			
			return response.getData();
		}
		
		@Override
		public List<Filme> listar() {
			
			Request request = new Request("Locadora.listar");
			String pacote = fxdacli.getCodificadorJSON().codificar(request);
			
			fxdacli.getTCPCtrlClient().enviarDado(pacote);
			Response response = (Response) fxdacli.getCodificadorJSON().descodificar(fxdacli.getTCPCtrlClient().receberDado(), Response.class);
			List<Filme> listFilme = (List<Filme>) fxdacli.getCodificadorJSON().descodificar(response.getData(), List.class);
			
			// TODO Auto-generated method stub
			return listFilme;
		}
		
//		public String cadastrar(int idFilme, String nome, String genero) {
//			
//			ProxyLocadora locdraProxy = new ProxyLocadora(idFilme, nome, genero);
//			
//			String data = codificadorJSON.codificar(locdraProxy);
//	
//			Request request = new Request("Locadora.cadastrar", data);
//	
//			String pacote = codificadorJSON.codificar(request);
//
//			ctrlClientTCP.enviarDado(pacote);
//			
//			Response response = (Response) codificadorJSON.descodificar(ctrlClientTCP.receberDado(), Response.class);
//
//			//			Response response = (Response) ControlJson.fromJson(ctrlClientTCP.getReponse(), Response.class);
//			
//			return response.getMsg();
//		}
		
//		public String remover(int idFilme) {
//			
//			ProxyLocadora locdraProxy = new ProxyLocadora(idFilme);
//			Request request = new Request("Locadora.remover", ControlJson.createJson(locdraProxy));
//			
//			ctrlClientTCP.sendRequest(ControlJson.createJson(request));
//			Response response = (Response) ControlJson.fromJson(ctrlClientTCP.getReponse(), Response.class);
//			
//			return response.getMsg();
//		}
//		
//		public String pesquisar(int idFilme) {
//			
//			ProxyLocadora locdraProxy = new ProxyLocadora(idFilme);
//			Request request = new Request("Locadora.pesquisar", ControlJson.createJson(locdraProxy));
//			
//			ctrlClientTCP.sendRequest(ControlJson.createJson(request));
//			Response response = (Response) ControlJson.fromJson(ctrlClientTCP.getReponse(), Response.class);
//			
//			return response.getMsg();
//		}
}
