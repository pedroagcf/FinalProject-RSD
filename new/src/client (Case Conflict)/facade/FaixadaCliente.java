package Client.facade;
import Client.Controller.CodificadorJson;
import Client.Controller.TCPControlClient;
import client.Interface.Codificador;

public class FaixadaCliente {
	
	private Codificador codificadorJSON = new CodificadorJson();
	private TCPControlClient TCPCtrlClient;
	
	public FaixadaCliente() {
		this.TCPCtrlClient = new TCPControlClient();
	}

	public Codificador getCodificadorJSON() {
		return codificadorJSON;
	}

	public TCPControlClient getTCPCtrlClient() {
		return TCPCtrlClient;
	}
	
}
