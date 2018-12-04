package Server.model;


public class Filme {
	
	private String nome; 
	private String genero; 
	private int idFilme;
	
	public Filme(String nome, String genero, int idFilme) {
		this.idFilme = idFilme;
		this.nome = nome;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Filme [nome=" + this.nome + ", genero=" + this.genero + "]";
	}
	
	
}
