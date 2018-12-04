package client.Interface;

public interface Codificador {

	public String codificar(Object obj);
	public Object descodificar(String obj, Class c);
	
}
