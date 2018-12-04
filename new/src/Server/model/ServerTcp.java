package Server.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.sql.ConnectionEvent;

public class ServerTcp {

	private static ServerTcp servTcp;
	private int porta = 4200;
	
	private ServerTcp() throws IOException, Exception {
		keepListen();
	}
	
	public static synchronized ServerTcp getInstance() throws IOException {
	    	
	    	if(servTcp == null) {
	    		try {
					servTcp = new ServerTcp();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	return servTcp;
	  }
	 
	 public void keepListen() {
	        
		 try {
			ServerSocket listenSocket = new ServerSocket(this.porta);
			System.out.println("Servidor ouvindo na porta 4200");
		 
			while (true) {
				Socket clientSocket = listenSocket.accept();
				
//				System.out.println("cliente conectado ao IP "+listenSocket.getInetAddress().getHostAddress());
				
				Connection conn = new Connection(clientSocket);
			}
			
		 } catch (Exception e) {
			System.out.println(e.getMessage());
		 }
		 	
	 }
}
