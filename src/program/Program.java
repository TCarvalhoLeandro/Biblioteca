package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domainException.DadosException;
import entities.Leitor;
import entities.Livro;
import service.Biblioteca;
import service.Emprestimo;

/*FALTA FAZER
 * leitura e salvar em arquivo
 * tratar as exceções*/

public class Program {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Biblioteca biblioteca = new Biblioteca();// Instanciar Biblioteca apenas uma vez
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		/*Loop do programa de interação com o usuario*/
		while(true){
			try {
				System.out.println("=-".repeat(20) + " BIBLIOTECA " + "=-".repeat(19) + "="); 
				System.out.println("[0] - Sair");
				System.out.println("[1] - Gerenciar Livros");
				System.out.println("[2] - Gerenciar Leitores");
				System.out.println("[3] - Emprestimos e Devolucoes");
				System.out.println("[4] - Salvar e Carregar Dados");
				System.out.println();
				System.out.print("Digite a opção desejada: ");	
				int opcao = Integer.parseInt(br.readLine());
				
				switch(opcao) {// switch externo (menu principal)
				case 1: 
					while(true) {//O while(true) mantém o usuário dentro do menu de livros.
						System.out.println("=".repeat(20) + " LIVROS " + "=".repeat(20));
						System.out.println("[0] - Voltar");
						System.out.println("[1] - Cadastrar Livro");
						System.out.println("[2] - Listar Livros");
						System.out.println("[3] - Remover Livro");
						System.out.println("[4] - Buscar Livro");
						System.out.println();
						System.out.print("Digite a opcao desejada: ");
						int opcao1 = Integer.parseInt(br.readLine());
						System.out.println();
						switch (opcao1) {// switch interno (menu livros)
						case 1:
							System.out.print("ID: ");
							int id = Integer.parseInt(br.readLine());
							System.out.print("Titulo: ");
							String titulo = br.readLine();
							System.out.print("Autor: ");
							String autor = br.readLine();
							System.out.print("Ano de publicação: ");
							int ano = Integer.parseInt(br.readLine());
							boolean disponivel = true;
							Livro livro = new Livro(id, titulo, autor, ano, disponivel);
							biblioteca.cadastrarLivro(livro);
							System.out.println();
							System.out.println("Livro cadastrado com sucesso.");
							System.out.println();
							break;
						case 2:
							
							System.out.println("Lista de Livros: ");
							System.out.println();
							biblioteca.listarLivro();
							System.out.println();
							break;
						case 3:
							System.out.print("Remover livro, titulo: ");
							String remove = br.readLine();
							biblioteca.removerLivro(remove);
							System.out.println();
							break;
						case 4:
							System.out.print("Busca ID: ");
							int busca = Integer.parseInt(br.readLine());
							System.out.println(biblioteca.buscarLivro(busca));
							
							break;
						default:
							if(opcao1 != 0) System.out.println("Digito invalido.");
							break;
						}// switch interno (menu livros)
						//O if (opcao1 == 0) break; faz sair do loop (e voltar pro menu principal).
						if(opcao1 == 0) {
							System.err.println("Voltando ao menu anterior.");
							break;
						}
					}
					break;// switch externo (Gerenciar Livros) case 1
				case 2:
					while(true) {//O while(true) mantém o usuário dentro do menu de leitores.
						System.out.println("=".repeat(20) + " LEITORES " + "=".repeat(20));
						System.out.println("[0] - Voltar");
						System.out.println("[1] - Cadastrar Leitor");
						System.out.println("[2] - Listar Leitores");
						System.out.println("[3] - Remover Leitor");
						System.out.println("[4] - Buscar Leitor");
						System.out.println();
						System.out.print("Digite a opcao desejada: ");
						int opcao2 = Integer.parseInt(br.readLine());
						System.out.println();
						switch (opcao2) {// switch interno (menu leitores)
						case 1:
							System.out.print("ID: ");
							int id = Integer.parseInt(br.readLine());
							System.out.print("Nome: ");
							String nome = br.readLine();
							System.out.print("CPF: ");
							String cpf = br.readLine();
							System.out.print("Email: ");
							String email = br.readLine();
							Leitor leitor = new Leitor(id, nome, cpf, email);
							biblioteca.cadastrarLeitor(leitor);
							System.out.println();
							System.out.println("Leitor cadastrado com sucesso.");
							System.out.println();
							break; //case 1
						case 2:
							System.out.println("Lista de leitores: ");
							System.out.println();
							biblioteca.listarLeitores();
							System.out.println();
							break;// case 2
						case 3:
							System.out.print("Remover leitor, ID: ");
							int remove = Integer.parseInt(br.readLine());
							biblioteca.removerLeitor(remove);
							break;// case 3
						case 4:
							System.out.print("Buscar leitor, ID: ");
							int IDBusca = Integer.parseInt(br.readLine());
							System.out.println(biblioteca.buscarLeitor(IDBusca));
							System.out.println();
							break;// case 4
						default:
							if(opcao2 != 0) System.out.println("Digito invalido.");
						}//switch interno
						//O if (opcao2 == 0) break; faz sair do loop (e voltar pro menu principal).
						if(opcao2 == 0) {
							System.err.println("Voltando ao menu anterior..");
							break;
						}
					}	
					break;// switch externo (Gerenciar Leitor) case 2
				
				case 3:
					while(true) {
						System.out.println("=".repeat(20) + " EMPRESTIMOS E DEVOLUCOES " + "=".repeat(20));
						System.out.println("[0] - Voltar");
						System.out.println("[1] - Emprestimo: ");
						System.out.println("[2] - Listar emprestimo: ");
						System.out.println("[2] - Devolucao: ");
						System.out.println();
						System.out.print("Digite a opcao desejada: ");
						int opcao3 = Integer.parseInt(br.readLine());
						System.out.println();
						switch(opcao3) {// switch externo (Emprestimo e Devolucoes) case 3
						case 1:
							System.out.print("ID: ");
							int id = Integer.parseInt(br.readLine());
							
							System.out.print("ID Leitor: ");
							int idLeitor = Integer.parseInt(br.readLine());
							Leitor leitorEmp = biblioteca.buscarLeitor(idLeitor);
							
							System.out.print("ID Livro: ");
							int idLivro = Integer.parseInt(br.readLine());
							Livro livroEmp = biblioteca.buscarLivro(idLivro);
							
							System.out.print("Data emprestimo (dd/MM/yyyy): ");
							String entrada = br.readLine();
							LocalDate dataEmprestimo = LocalDate.parse(entrada, fmt);
							//System.out.println("Data devolucao (dd/MM/yyyy): ");
							//entrada = br.readLine();
							//LocalDate dataDevolucao = LocalDate.parse(entrada, fmt);
							
							boolean disponivel = false;
							
							// criei um emprestimo associando Leitor e livro
							Emprestimo emprestimo = new Emprestimo(id, leitorEmp, livroEmp, dataEmprestimo, disponivel);
							System.out.println();
							biblioteca.emprestimo(emprestimo);
							System.out.println();
							break; //case 1 interno
							
						case 2:
							System.out.println("Lista de emprestimos: ");
							System.out.println();
							biblioteca.listaEmprestimo();
							System.out.println();
							break; //case 2 interno
						case 3:
							System.out.println();
							System.out.println("Devolucao: ");
							System.out.println();
							System.out.print("Titulo: ");
							String devolucao = br.readLine();
							biblioteca.devolucao(devolucao);
							System.out.println();
							break;
						default:
							if(opcao3 != 0) System.out.println("Digito invalido.");
						}//switch interno
						//O if (opcao3 == 0) break; faz sair do loop (e voltar pro menu principal).
						if(opcao3 == 0) {
							System.err.println("Voltando ao menu anterior...");
							break;
						}
					}
					break;// switch externo (Emprestimo e Devolucoes) case 3
				
				default:
					if(opcao != 0) System.out.println("Digito invalido.");
					break;
				}// switch externo (menu principal)
				//O if (opcao == 0) break; faz encerrar o programa.
				if(opcao == 0) {
					System.err.println("Programa encerrado...");
					break;
				}
			}// fim try
			catch(DadosException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			catch(NumberFormatException e) {
				System.out.println("Digite um numero valido");
			}
			catch(Exception e) {
				System.out.println("Valor Invalido");
				
			}
		}
	}
}
