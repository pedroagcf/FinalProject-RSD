package Server.View;
import Server.model.ServerTcp;

public class Prompt {
	public static void main(String args[]) {
		try {
			ServerTcp tcp = ServerTcp.getInstance();
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}