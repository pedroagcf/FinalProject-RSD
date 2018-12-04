package Client.Model;

public class ProxyLanHouse {

	private int idUser;
	private String nome;
	private String senha;
	
	public ProxyLanHouse(int idUser, String nome, String senha){
		this.idUser = idUser;
		this.nome = nome; 
		this.senha = senha;
	}
	
	public ProxyLanHouse(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
