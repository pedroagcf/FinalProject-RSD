package Client.Controller;

import java.io.IOException;

import Client.Model.Conexao;
import client.Interface.ConexaoRemota;

public class TCPControlClient implements ConexaoRemota {
	
	private Conexao conn;
	private String ip;
	private int port; 
	
	public TCPControlClient() {
		this.ip = "localhost"; 
		this.port = 4200;
		this.conn = new Conexao(this.ip, this.port);
	}
	
	
	public Conexao getConexao() {
		return this.conn;
	}

	@Override
	public void iniciarConexao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarConexao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarDado(String requisicao) {
		try {
			this.conn.getOut().writeUTF(requisicao);
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String receberDado() {
		try {
			String data = this.conn.getIn().readUTF();
			return data;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}	
	}
}
