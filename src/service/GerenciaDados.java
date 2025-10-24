package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import entities.Leitor;
import entities.Livro;

//O GerenciarLivro agora DEPENDE de uma Biblioteca (Composição)
public class GerenciaDados {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private Biblioteca biblioteca;
	
	// Injeção de Dependência via construtor
	public GerenciaDados(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public  void  executar(int opcao) {
		
		try {
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
						System.out.println("[2] - Gerenciar leitores");
					
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
						
						// a busca retorna um array com os dados do livro
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
				case 2: 
					System.out.println();
					System.out.println(">>>>>" + " GERENCIAR LEITORES " + "<<<<<");
					System.out.println("[0] - Retornar");
					System.out.println("[1] - Cadastrar leitor");
					System.out.println("[2] - Listar leitores");
					System.out.println("[3] - Remover leitor");
					System.out.println("[4] - Buscar leitor");
					System.out.println("[5] - Salvar");
					System.out.println("[6] - Carregar arquivo");
					
					System.out.println();
					System.out.print("Escolha uma opção: ");
					opcao1 = Integer.parseInt(br.readLine());
					System.out.println("=".repeat(53));
					
					System.out.println();
					switch(opcao1) {
					case 0:
						System.out.println("[0] - Sair");
						System.out.println("[1] - Gerenciar livros");
						System.out.println("[2] - Gerenciar leitores");
					
						System.out.println();
						System.out.print("Escolha uma opção: ");
						opcao = Integer.parseInt(br.readLine());
						System.out.println();
						break;
					case 1:
						System.out.println("Digite o id: ");
						int id = Integer.parseInt(br.readLine());
						System.out.println("Digite o nome: ");
						String nome = br.readLine();
						System.out.println("Digite o cpf: ");
						String cpf = br.readLine();
						System.out.println("Digite o email:");
						String email = br.readLine();
						
						Leitor leitor = new Leitor(id, nome, cpf, email);// Crio o objeto leitor
						
						biblioteca.cadastrarLeitor(leitor);
						break;
					case 2:
						biblioteca.listarLeitor();
						System.out.println();
						break;
					case 3: 
						System.out.println("Remover um leitor: ");
						System.out.println("DIgite o ID: ");
						id = Integer.parseInt(br.readLine());
						biblioteca.removeLeitor(id);
						System.out.println();
						break;
					case 4:
						System.out.println("Busca: ");
						System.out.println("Digite o ID do leitor:");
						int busca = Integer.parseInt(br.readLine());
						
						// a busca retorna um array com os dados do livro
						ArrayList<Leitor> buscaLeitor = biblioteca.buscaLeitor(busca);
						
						System.out.println();
						System.out.println("Resultado: ");
						if(buscaLeitor != null) {
							for(Leitor obj: buscaLeitor) {
								System.out.println(obj);
							}
						}
						else {
							System.out.println("Não encontrado.");
						}
						break;
					case 5: 
						biblioteca.salvarLeitor("leitores.txt");
						System.out.println("Leitor salvo com sucesso");
						break;
					case 6:
						System.out.println("Leitores carregada: ");
						biblioteca.carregaLeitor("leitores.txt");
						biblioteca.listarLeitor();
						System.out.println();
						break;
						
					}
					
					break;
				}
			}
		}
		catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}	
}
