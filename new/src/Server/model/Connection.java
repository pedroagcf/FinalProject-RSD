package Server.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Server.controller.Despachante;

public class Connection extends Thread {
	private DataInputStream in; 
	private DataOutputStream out;
	Socket clientSocket; 
	Despachante despachante; 
	
	public Connection(Socket conSocket) {
		
		this.clientSocket = conSocket;
		this.despachante = new Despachante();
	
		
		try {
			this.in = new DataInputStream(this.clientSocket.getInputStream());
			this.out = new DataOutputStream(this.clientSocket.getOutputStream());
			this.start();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void run() {
		try {
			while(true) {
				
				if (in.available() > 0) {
					
					String request = in.readUTF();
					System.out.println("Olha ai o que acabou de chegar do cliente: ");
					System.out.println("Requested: " + request);
				
					String response = despachante.invoke(request);
					System.out.println("response " +  response);
					
					out.writeUTF(response);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
