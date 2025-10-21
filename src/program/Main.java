package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import entities.Livro;
import service.Biblioteca;

public class Main {

	public static void main(String[] args) {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Biblioteca biblioteca = new Biblioteca();
		
		try {
			System.out.println("=".repeat(15) + " BIBLIOTECA DO LEANDRO " + "=".repeat(15));
		
			System.out.println("[0] - Sair");
			System.out.println("[1] - Gerenciar livros");
		
			System.out.println();
			System.out.print("Escolha uma opção: ");
			int opcao = Integer.parseInt(br.readLine());
			System.out.println("=".repeat(53));
			boolean valido = true;
			while(valido) {
				switch(opcao) {
				case 0: 
					System.out.println("Programa encerrado...");
					valido = false;
					break;
				case 1:
					System.out.println();
					System.out.println(">>>>>" + " GERENCIAR LIVROS " + "<<<<<");
					System.out.println("[0] - Retornar");
					System.out.println("[1] - Cadastrar livro");
					System.out.println("[2] - Listar livros");
					System.out.println("[3] - Remover livro");
					System.out.println("[4] - Buscar livro");
					System.out.println("[5] - Salvar");
					System.out.println("[6] - Carregar arquivo");
					
					System.out.println();
					System.out.print("Escolha uma opção: ");
					int opcao1 = Integer.parseInt(br.readLine());
					System.out.println("=".repeat(53));
					
					System.out.println();
					
					switch(opcao1) {
					
					case 0:
						System.out.println("[0] - Sair");
						System.out.println("[1] - Gerenciar livros");
					
						System.out.println();
						System.out.print("Escolha uma opção: ");
						opcao = Integer.parseInt(br.readLine());
						System.out.println();
						break;
						
					case 1:
						System.out.println("Cadastro de livro: ");
						System.out.print("Digite o ISBN: ");
						int id = Integer.parseInt(br.readLine());
						System.out.print("Digite o título: ");
						String titulo = br.readLine();
						System.out.print("Digite o autor: ");
						String autor = br.readLine();
						System.out.print("Digite o ano: ");
						int ano = Integer.parseInt(br.readLine());
						System.out.println();
						Livro livro = new Livro(id, titulo, autor, ano, true);
						biblioteca.cadastrarLivro(livro);
						System.out.println("Livro adicionado com sucesso.");
						break;
						
					case 2:
						biblioteca.listarLivros();
						System.out.println();
						break;
						
					case 3:
						System.out.println("Remover um livro: ");
						System.out.print("Digite o título: ");
						String remove = br.readLine();
						biblioteca.removerLivro(remove);
						break;
						
					case 4:
						System.out.println("Busca: ");
						System.out.println("Digite o titulo do livro:");
						String busca = br.readLine();
						
						ArrayList<Livro> buscaLivro = biblioteca.buscarLivros(busca);
						
						System.out.println();
						System.out.println("Resultado: ");
						if(buscaLivro != null) {
							for(Livro obj: buscaLivro) {
								System.out.println(obj);
							}
						}
						else {
							System.out.println("Não encontrado.");
						}
						break;
						
					case 5:
						biblioteca.salvarLivros("livros.txt");
						System.out.println("Livro salvo com sucesso");
						break;
						
					case 6: 
						System.out.println("Biblioteca carregada: ");
						biblioteca.carregarLivros("livros.txt");
						biblioteca.listarLivros();
						System.out.println();
						break;
					
					default:
						System.out.println("Opção inválida.");
						break;
					}
				
				}
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

}
