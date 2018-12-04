package Server.Interface;

import java.util.List;

public interface CrudServer<T> {
	
	public boolean cadastrar(T obj);
	public boolean remover(int id);
	public List<T> listar();
	public T pesquisar(int id);
}
