package Client.Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conexao {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public Conexao(String ip, int porta) {
		try {
			this.socket = new Socket(ip, porta);
			
			this.in = new DataInputStream(this.socket.getInputStream());
			this.out = new DataOutputStream(this.socket.getOutputStream());
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		
		}catch (EOFException e) {
			System.out.println(e.getMessage());
		
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.socket.close();
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Socket getSocket() {
		return this.socket;
	}

	public DataInputStream getIn() {
		return this.in;
	}

	public DataOutputStream getOut() {
		return this.out;
	}
	
}
