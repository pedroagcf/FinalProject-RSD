package client.Interface;

public interface ConexaoRemota {

	public void iniciarConexao();
	public void finalizarConexao();
	public void enviarDado(String requisao);
	public String receberDado();

}
