package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domainException.DadosException;
import entities.Leitor;
import entities.Livro;

public class Biblioteca {

	private List<Livro> livros = new ArrayList<>();// lista de livros
	private List<Leitor> leitores = new ArrayList<>();// lista de leitores
	private List<Emprestimo> emprestimos = new ArrayList<>();// lista de emprestimos
	//construtor padrao
	public Biblioteca() {
		
	}
	//construtor com argumentos
	public Biblioteca(List<Livro> livros, List<Leitor> leitores, List<Emprestimo> emprestimos) {
		this.livros = livros;
		this.leitores = leitores;
		this.emprestimos = emprestimos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<Leitor> getLeitores() {
		return leitores;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	public void menuLivro() throws IOException {
		
	}
	
	/*CADASTRAR LIVROS*/
	public void cadastrarLivro(Livro livro) {
		livros.add(livro);
	}
	
	/*LISTAR LIVROS*/
	public void listarLivro() {
		//verifica se a lista está vazia
		if(livros.isEmpty()) {
			System.out.println("Lista de livros vazia");
			
		}
		for(Livro livro: livros) {
			System.out.println(livro.getId() + " - " + livro.getTitulo() + " - " + livro.getAutor() + " - " + livro.getAno());
		}
	}
	
	/*REMOVER LIVROS*/
	public void removerLivro(String nome) {
		//verifica se a lista está vazia
		if(livros.isEmpty()) {
			System.out.println("Lista de livros vazia");
			
		}
		// É errado remover um objeto enquanto itera a lista
		Livro livroParaRemover = null;
		for(Livro livro: livros) {
			if(livro.getTitulo().equalsIgnoreCase(nome))
				livroParaRemover = livro; // encontrou o livro
				break;// sai do loop assim que acha o livro
		}
		//remove o livro fora do loop
		if(livroParaRemover != null) {
			livros.remove(livroParaRemover);
			System.out.println("Livro removido com sucesso");
		}
		else {
			System.out.println("Livro não encontrado");
		}
	}
	
	/*BUSCAR LIVROS*/
	public Livro buscarLivro(int id) throws DadosException{
		if(livros.isEmpty()) {
			//System.out.println("Lista de livros vazia");
			throw new DadosException("Lista de livros vazia");
		}		
		Livro buscaLivro = null;
		for(Livro livro: livros) {
			if(livro.getId() == id) {
				buscaLivro = livro;
				break;
			}		
		}
		if(buscaLivro != null) {
			return buscaLivro;
		}
		else {
			throw new DadosException("Livro nao encontrado");
		}
	}
	
	/*CADASTRAR LEITOR*/
	public void cadastrarLeitor(Leitor leitor) {
		leitores.add(leitor);
	}
	
	
	/*LISTAR LEITORES*/
	public void listarLeitores() {
		if(leitores.isEmpty()) {
			System.out.println("Lista de leitores vazia.");
		}
		
		for(Leitor leitor: leitores) {
			System.out.println(leitor);
		}
	}
	
	/*REMOVER LEITOR*/
	public void removerLeitor(int id)  throws DadosException{
		if(leitores.isEmpty()) {
			//System.out.println("Lista de Leitores vazia.");
			throw new DadosException("Lista de leitores vazia");
		}
		
		Leitor leitorRemove = null;
		
		for(Leitor leitor: leitores) {
			if(leitor.getId() == id) {
				leitorRemove = leitor;//livro encontrado
				break;// sai do loop assim que acha o livro
			}
		}
		//remove o livro fora do loop
		if(leitorRemove != null) {
			leitores.remove(leitorRemove);
			System.out.println("Leitor removido com sucesso.");
		}
		else System.out.println("Leitor não encontrado.");
	}
	
	/*BUSCAR LEITOR*/
	public Leitor buscarLeitor(int id) throws DadosException{
		if(leitores.isEmpty()) {
			//System.out.println("Lista de leitores vazia");
			throw new DadosException("Lista de leitores vazia");
		}		
		Leitor buscaLeitor = null;
		for(Leitor leitor: leitores) {
			if(leitor.getId() == id) {
				buscaLeitor = leitor;
				break;
			}		
		}
		if(buscaLeitor != null) {
			return buscaLeitor;
		}
		else {
			throw new DadosException("Leitor nao encontrado");
		}
	}
	
	/*REGISTRAR EMPRESTIMO*/
	public void emprestimo(Emprestimo emprestimo) {
		
		Livro livro = emprestimo.getLivro();// peguei o livro a ser emprestado
		//Adiciona o novo emprestimo
		if(livro.isDisponivel()) {
			emprestimos.add(emprestimo);
			//marca o livro como emprestado
			livro.emprestar();
			System.out.println("Empréstimo cadastrado com sucesso.");
		}
		else {
	        System.out.println("Livro indisponível para empréstimo.");
	    }
	}
	
	/*LISTAR EMPRESTIMO*/
	public void listaEmprestimo() throws DadosException{		
		if(emprestimos.isEmpty()) {
			//System.out.println("Lista de emprestimos vazia.");
			throw new DadosException("Lista de emprestimos vazia");
		}
		for(Emprestimo emp: emprestimos) {
			if(emp.getDataDevolucao() == null) {
				System.out.println(emp.toStringEmprestimo());
			}
			if(emp.getDataDevolucao() != null) {
				System.out.println(emp.toStringDevolucao());
			}
		}
	}
	
	/*DEVOLUCAO*/
	public void devolucao(String tituloLivro) {
		for(Emprestimo emp: emprestimos) {
			//Ache o emprestimo ativo(ainda não devolvido)
			if(emp.getLivro().getTitulo().trim().equalsIgnoreCase(tituloLivro.trim()) && emp.getDataDevolucao() == null) {
				emp.registrarDevolucao(); //marca a data da devolucao
				emp.getLivro().setDisponivel(true);// deixa o livro didponivel
				System.out.println("Devolucao registrada com sucesso");
				System.out.println(emp.toStringDevolucao());
		        System.out.println();
		        return;
			}
		}
		System.out.println("Nenhum empréstimo ativo encontrado para este livro.");
	}
	
	
	
	public void salvarDados() {
		
	}
	public void carregarDados() {
		
	}
	
	
	
	
	
	
	
}
