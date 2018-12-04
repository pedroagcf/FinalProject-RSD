package client.Interface;

import java.util.List;

public interface crudService <T> {
	
	public String cadastrar(int id, String nome, String genero);
	public String remover(int id);
	public List<T> listar();
	public String pesquisar(int id);
}
