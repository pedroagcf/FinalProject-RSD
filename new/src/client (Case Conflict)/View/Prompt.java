package Client.View;

import java.util.List;
import java.util.Scanner;

import Client.Controller.ControlProxyLanHouse;
import Client.Controller.ControlProxyLocadora;
import Server.model.Filme;

public class Prompt {
	
//	private int port = 4200;
//	private String ip = "localhost";
	private ControlProxyLocadora ctrlProxLocdra;
	private ControlProxyLanHouse ctrlLanHouse;
//	private TCPControlClient ctrlClientTCP;
	private Scanner input;
	
	public void run() {
//		this.ip, this.port
//		this.ctrlClientTCP = new TCPControlClient(); 
		this.ctrlProxLocdra = new ControlProxyLocadora();
		this.input = new Scanner(System.in);
		this.ctrlLanHouse = new ControlProxyLanHouse();
		boolean flag = true;
		System.out.println("LanHouse do Bairro");
		
		while (flag) {
			
			System.out.println("\n>>");
			System.out.println("1 | Acessar a Locadora");
			System.out.println("2 | Acessar a LanHouse");
			System.out.println("0 | Encerrar");
			System.out.println("########");
		
			int opc = Integer.parseInt(input.nextLine()); 
		
			switch (opc) {
			
			case 0:
				flag = false;
				break;

			case 1:
				promptLocadora();
				break;
				
			case 2:
				promptLanHouse();
				break;	
			default:
				break;
			}
		}
		
	}
	
	private void promptLocadora() {	
        boolean flag = true;

        while(flag) {
            
        	System.out.println("\n>> ");
            System.out.println("1 | Cadastrar Filme");
            System.out.println("2 | Remover Filme");
            System.out.println("3 | Pesquisar Filme");
            System.out.println("0 | Voltar");
            System.out.print(">> ");

            int opc = Integer.parseInt(input.nextLine());

            switch (opc) {
                case 0: 
                	flag = false;
     
                	break;

                case 1: 
                	cadastrarFilme(); 
                
                	break;
                case 2: 
                	removerFilme(); 
                	
                	break;
                case 3: 
                	pesquisarFilme();
              
                	break;
                	
                case 4: 
                	listarFilmes();
                	
                	break;
                	
                default: 
                	
                	System.out.println("Erro | opcao nao encontrada.");
                	break;
            }
        }
		
	}
	
	public void cadastrarFilme() {
		
		System.out.println("Insira um Id para o filme: ");
		int idFilme = Integer.parseInt(input.nextLine());
		
		System.out.println("Insira o nome do filme: ");
		String nome = input.nextLine();
		
		System.out.println("Insira o genero do filme: ");
		String genero = input.nextLine();
		
		String response = this.ctrlProxLocdra.cadastrar(idFilme, nome, genero);
		System.out.println("\n" + response);
	}
	
	public void removerFilme() {
		System.out.println("Digite o id do filme que deseja remover: ");
		int idFilme =  Integer.parseInt(input.nextLine());
		
		String response = this.ctrlProxLocdra.remover(idFilme);
		System.out.println("\n" + response);
	}
	
	public void pesquisarFilme() {
		
		System.out.println("Digite o id do filme que deseja pesquisar: ");
		int idFilme =  Integer.parseInt(input.nextLine());
		
		String response = this.ctrlProxLocdra.pesquisar(idFilme);
		System.out.println("\n" + "Olha ai o que acabou de chegar do servidor: ");
		System.out.println(response);
	}
	
	public void listarFilmes() {
		
		System.out.println("listando os filmes: ");
		List<Filme> listaFilme = this.ctrlProxLocdra.listar();
		
		System.out.println(listaFilme.toString());
	
//		for (Filme f : listaFilme) {
//			System.out.println(f.getNome());
//		}	
		
		System.out.println("\n"+"Olha ai o que acabou de chegar do servidor: ");
	}
	
	
	
	public void promptLanHouse() {
        boolean flag = true;

        while(flag) {
            
        	System.out.println("\n>> ");
            System.out.println("1 | Cadastrar Usuario");
            System.out.println("2 | Remover Usuario");
            System.out.println("3 | Pesquisar Usuario");
            System.out.println("4 | Inserir credito");
            System.out.println("0 | Sair");
            
            System.out.print(">> ");

            int opc = Integer.parseInt(input.nextLine());

            switch (opc) {
                case 0: 
                	flag = false;
     
                	break;

                case 1: 
                	cadastrarLogin(); 
                
                	break;
                case 2: 
                	removerLogin(); 
                	
                	break;
                case 3: 
                	pesquisarLogin();
                	
                	break;
                case 4: 
                	adicionarTempo();
                	
                	break;	
                
                default: 
                	break;
            }
        }		
	}
	
	public void cadastrarLogin() {
		
		System.out.println("Insira um Id para o usuario: ");
		int idUsuario = Integer.parseInt(input.nextLine());
		
		System.out.println("Insira o nome do usuario: ");
		String nome = input.nextLine();
		
		System.out.println("Insira a senha do usuario: ");
		String senha = input.nextLine();
		
		String response = this.ctrlLanHouse.cadastrar(idUsuario, nome, senha);
		System.out.println("\n" + response);
		
	}
	
	public void removerLogin() {
		System.out.println("Digite o id do usuario que deseja remover: ");
		int idUsuario =  Integer.parseInt(input.nextLine());
		
		String response = this.ctrlLanHouse.remover(idUsuario);
		System.out.println("\n" + response);
		
	}
	
	public void pesquisarLogin() {

		System.out.println("Digite o id do usuario que deseja pesquisar: ");
		int idUsuario =  Integer.parseInt(input.nextLine());
		
		String response = this.ctrlLanHouse.pesquisar(idUsuario);
		System.out.println("\n" + "Olha ai o que acabou de chegar do servidor: ");
		System.out.println(response);
	
	}
	
	public void adicionarTempo() {
		
	}
			
}
