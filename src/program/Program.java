package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import domainException.DadosException;
import entities.Leitor;
import entities.Livro;
import service.Biblioteca;
import service.CSVUtil;
import service.Emprestimo;

/*FALTA FAZER

 * tratar as exceções
 * validar cpf
 * validar email
 * calcular dias atrasados
 * calcular a multa por atraso*/

public class Program {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Biblioteca biblioteca = new Biblioteca();// Instanciar biblioteca apenas uma vez
		biblioteca.carregarArquivo();// carrega os arquivos  .csv
		/*Os arquivos são carregados e só podem ser modificados atraves dos menus*/
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");// formato de data 
		
		/*Loop do programa de interação com o usuario*/
		while(true){
			try {
				System.out.println("=".repeat(15) + " BIBLIOTECA " + "=".repeat(15)); 
				System.out.println("0 - Sair");
				System.out.println("1 - Livros");
				System.out.println("2 - Leitores");
				System.out.println("3 - Emprestimos e Devolucoes");
				System.out.println("4 - Salvar e Carregar");
				System.out.println();
				System.out.print("Digite a opção desejada: ");	
				int opcao = Integer.parseInt(br.readLine());
				
				switch(opcao) {// switch externo (menu principal)
				case 1: 
					while(true) {//O while(true) mantém o usuário dentro do menu de livros.
						System.out.println("=".repeat(15) + " LIVROS " + "=".repeat(15));
						System.out.println("0 - Voltar");
						System.out.println("1 - Cadastrar ");
						System.out.println("2 - Listar");
						System.out.println("3 - Remover");
						System.out.println("4 - Buscar");
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
						System.out.println("=".repeat(15) + " LEITORES " + "=".repeat(15));
						System.out.println("0 - Voltar");
						System.out.println("1 - Cadastrar ");
						System.out.println("2 - Listar ");
						System.out.println("3 - Remover ");
						System.out.println("4 - Buscar ");
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
						System.out.println("=".repeat(15) + " EMPRESTIMOS E DEVOLUCOES " + "=".repeat(15));
						System.out.println("0 - Voltar");
						System.out.println("1 - Emprestimo ");
						System.out.println("2 - Listar ");
						System.out.println("3 - Devolucao ");
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
				case 4:
					while(true) {//O while(true) mantém o usuário dentro do menu de salvar e carregar.
						System.out.println("=".repeat(15) + " SALVAR E CARREGAR " + "=".repeat(15));
						System.out.println("0 - Voltar");
						System.out.println("1 - Salvar ");
						System.out.println("2 - Carregar ");
						System.out.println();
						System.out.print("Digite a opcao desejada: ");
						int opcao4 = Integer.parseInt(br.readLine());
						System.out.println();
						switch (opcao4) {// switch interno (menu salvar e carregar)
						case 1:
							/*salvar todas as listas*/
							  try {
								  	if(Livro.getContador() > 0) {// só vai escrever no arquivo se for instanciado
								  		CSVUtil.salvarCSV(biblioteca.getLivros(), "livros.csv");
								  		Livro.setContador(0);// salvou no arquivo zera o contador
								  	}
							        if(Leitor.getContador() > 0) {// só vai escrever no arquivo se for instanciado
							        	CSVUtil.salvarCSV(biblioteca.getLeitores(), "leitores.csv");
							        	Leitor.setContador(0);// salvou no arquivo zera o contador
							        }
							        if(Emprestimo.getContador() > 0) {// só vai escrever no arquivo se for instanciado
							        	CSVUtil.salvarCSV(biblioteca.getEmprestimos(), "emprestimos.csv");
							        	Emprestimo.setContador(0);// salvou no arquivo zera o contador
							        }
							        System.out.println("Dados salvos com sucesso!");
							  }
							  catch (IOException e) {
							       System.out.println("Erro ao salvar: " + e.getMessage());
							  }
							
							break; //case 1
						case 2:
							List<Livro> livros = CSVUtil.lerLivroCSV("/home/leandro/eclipse-workspace/Biblioteca/livros.csv");
							for(Livro livro: livros) {
								System.out.println(livro);
							}
							System.out.println();
							System.out.println("=".repeat(25));
							System.out.println();
							
							List<Leitor> leitores = CSVUtil.lerLeitorCSV("/home/leandro/eclipse-workspace/Biblioteca/leitores.csv");
							for(Leitor leitor: leitores) {
								System.out.println(leitor);
							}
							System.out.println();
							System.out.println("=".repeat(25));
							System.out.println();
							List<Emprestimo> emprestimos = CSVUtil.lerEmprestimoCSV("/home/leandro/eclipse-workspace/Biblioteca/emprestimos.csv",
									leitores, livros);
							for(Emprestimo emprestimo: emprestimos) {
								System.out.println(emprestimo);
							}
							System.out.println();
							System.out.println("=".repeat(25));
							System.out.println();
							break;
						
						default:
							if(opcao4 != 0) System.out.println("Digito invalido.");
						}//switch interno(menu salvar e carregar)
						
						//O if (opcao2 == 0) break; faz sair do loop (e voltar pro menu principal).
						if(opcao4 == 0) {
							System.err.println("Voltando ao menu anterior..");
							break;
						}
					}
					break;// switch externo (salvar e carregar) case 4
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
				System.out.println(e.getMessage());
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
