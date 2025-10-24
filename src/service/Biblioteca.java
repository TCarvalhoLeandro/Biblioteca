package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domainException.DadosExceptions;
import entities.Leitor;
import entities.Livro;

public class Biblioteca {
	
	/*Quando a variavel de instancia for uma lista não esqueça de inicializar*/
	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<Leitor> leitores = new ArrayList<>();
	private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
	
	public Biblioteca() {
		
	}
	
	public Biblioteca(ArrayList<Livro> livros, ArrayList<Leitor> leitores, ArrayList<Emprestimo> emprestimos) {
		this.livros = livros;
		this.leitores = leitores;
		this.emprestimos = emprestimos;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public ArrayList<Leitor> getLeitores() {
		return leitores;
	}

	public void setLeitores(ArrayList<Leitor> leitores) {
		this.leitores = leitores;
	}

	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	/*METODO PARA CADASTRAR LIVRO*/
	public void cadastrarLivro(Livro livro) throws DadosExceptions{
		if(this.livros != null) {
			for(Livro obj: this.livros) {
				if(obj.getTitulo() == livro.getTitulo()) {
					throw new DadosExceptions("Livro já exixte.");
				}
			}
		}
		livros.add(livro);
		
	}
	
	/*METODO PARA CADASTRAR LEITOR*/
	public void cadastrarLeitor(Leitor leitor) throws DadosExceptions{
		if(this.leitores != null) {
			for(Leitor obj: this.leitores) {
				if(obj.getId() == leitor.getId()) {
					throw new DadosExceptions("Leitor já exixte.");
				}
			}
		}
		leitores.add(leitor);
		
	}
	
	/*METODO PARA LISTAR OS LIVROS*/
	/*.indexOf() retorna a posição do objeto na lista*/
	public void listarLivros() {
		if(this.livros != null) {
			for(Livro obj: this.livros) {
				System.out.println((livros.indexOf(obj) + 1 )+ " | " + obj);
			}
		}
	}
	
	/*METODO PARA LISTAR OS LEITOR*/
	/*.indexOf() retorna a posição do objeto na lista*/
	public void listarLeitor() {
		if(this.leitores != null) {
			for(Leitor obj: this.leitores) {
				System.out.println(obj);
			}
		}
	}
	
	
	
	
	/*METODO PARA REMOVER UM LIVRO*/
	public void removerLivro(String titulo) {
		if(this.livros != null) {
			for(Livro obj: this.livros) {
				/*Use .equals(...) para comparar conteúdo de Strings*/
				if(obj.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
					livros.remove(obj);
				}
				/*Se a lista estiver vazia retorna para onde chamou*/
				if(livros.isEmpty()) {
					System.out.println("Lista vazia");
					return;

				}
			}
		}
	}
	
	/*METODO PARA REMOVER UM LEITOR*/
	public void removeLeitor(int id) {
		if(this.leitores != null) {
			for(Leitor obj: this.leitores) {
				/*Use .equals(...) para comparar conteúdo de Strings*/
				if(obj.getId() == id) {
					leitores.remove(obj);
				}
				/*Se a lista estiver vazia retorna para onde chamou*/
				if(leitores.isEmpty()) {
					System.out.println("Lista vazia");
					return;

				}
			}
		}
	}
	
	/*METODO PARA BUCAR LIVRO POR PALAVRA CHAVE*/
	/*Para buscar livros por palavra chave eu tenho que criar um arraylist do tipo livro
	 * pra armazenar os livros que correspondem a palavra chave*/
	public ArrayList<Livro> buscarLivros(String palavraChave) {
		/*ArrayList criado*/
		ArrayList<Livro> resultados = new ArrayList<>();
		
		/*tratando erro*/
		if(palavraChave == null || palavraChave.isBlank() || this.livros == null) {
			return resultados;
		}
		
		/*Iterando no ArrayList livros*/
		for(Livro obj: this.livros) {
			if(obj != null && obj.getTitulo() != null) {
				if(obj.getTitulo().toLowerCase().contains(palavraChave.toLowerCase())) {
					resultados.add(obj);
				}
			}
		}
		return resultados;
	}
	
	/*METODO PARA BUCAR LEITOR POR ID*/
	/*Para buscar leitor por id eu tenho que criar um arraylist do tipo livro
	 * pra armazenar o leitor que correspondem a palavra chave*/
	public ArrayList<Leitor> buscaLeitor(int id) {
		/*ArrayList criado*/
		ArrayList<Leitor> resultados = new ArrayList<>();
		
		/*tratando erro*/
		if(this.leitores == null) {
			return resultados;
		}
		
		/*Iterando no ArrayList livros*/
		for(Leitor obj: this.leitores) {
			if(obj != null) {
				resultados.add(obj);
			}
		}
		return resultados;
	}
	
	public void registrarEmprestimo() {
		
	}
	
	public void registrarDevolucao() {
		
	}
	
	/*METODO PARA SALVAR ARQUIVO TXT*/
	public void salvarLivros(String nomeArquivo) throws IOException{
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))){
			
			for(Livro livro: this.livros) {
				String linha = livro.getIsbn()  + ";" + livro.getTitulo() + ";" + livro.getAutor()
				+ ";" +  livro.getAno();
				
				bw.write(linha);
				bw.newLine();
			}
			
		}
	}
	

	/*METODO PARA SALVAR ARQUIVO TXT*/
	public void salvarLeitor(String nomeArquivo) throws IOException{
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))){
			
			for(Leitor leitor: this.leitores) {
				String linha = leitor.getId()  + ";" + leitor.getNome() + ";" + leitor.getCpf()
				+ ";" +  leitor.getEmail();
				
				bw.write(linha);
				bw.newLine();
			}
			
		}
	}
	
	/*METODO PARA CARREGAR ARQUIVO TXT*/
	public void carregarLivros(String nomeArquivo) throws IOException{
		
		livros.clear();// limpa o Array de livros
		String linha;
		
		try(BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				
				if(partes.length == 4) {
					int isbn = Integer.parseInt(partes[0]);
					String titulo = partes[1];
					String autor = partes[2];
					int ano = Integer.parseInt(partes[3]);
					
					Livro livro = new Livro(isbn, titulo, autor, ano, true);
					
					livros.add(livro);
					
				}
			}
		}
	}



/*METODO PARA CARREGAR ARQUIVO TXT*/
public void carregaLeitor(String nomeArquivo) throws IOException{
	
	leitores.clear();// limpa o Array de livros
	String linha;
	
	try(BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
		while((linha = br.readLine()) != null) {
			String[] partes = linha.split(";");
			
			if(partes.length == 4) {
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				String cpf = partes[2];
				String email = partes[3];
				
				Leitor leitor = new Leitor(id, nome, cpf, email);
				
				leitores.add(leitor);
				
				}
			}
		}
	}
}
