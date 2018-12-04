package Client.Model;

public class ProxyLocadora {
	private int idFilme;
	private String nome;
	private String genero;
	
	public ProxyLocadora(int idFilme, String nome, String genero) {
		this.idFilme = idFilme;
		this.nome = nome;
		this.genero = genero; 
	}
	
	public ProxyLocadora(int idFilme) {
		this.idFilme = idFilme;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
