package service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domainException.DadosException;
import entities.Leitor;
import entities.Livro;

public class Biblioteca {

	private List<Livro> livros = new ArrayList<Livro>();// lista de livros
	private List<Leitor> leitores = new ArrayList<Leitor>();// lista de leitores
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();// lista de emprestimos
	
	/*construtor padrão*/
	public Biblioteca() {
		
	}
	
	//construtor com listas usado para criar livros novos
	public Biblioteca(List<Livro> livros, List<Leitor> leitores, List<Emprestimo> emprestimos) {
		this.livros = livros;
		this.leitores = leitores;
		this.emprestimos = emprestimos;
	}

	/*GETTERS SETTERS*/
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void setLeitores(List<Leitor> leitores) {
		this.leitores = leitores;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
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
			System.out.println(livro);
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
			livro.setDisponivel(false);
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
		boolean devolvido = false;
		
		/*Um Iterator é um objeto que permite percorrer uma coleção (List, Set, etc.) de forma segura.
			Ele é parecido com o for-each, mas permite remover elementos da lista durante a iteração sem dar erro.*/
		Iterator<Emprestimo> it = emprestimos.iterator();
		
		while(it.hasNext()) {// enquanto houver próximo elemento
			/*it.hasNext() retorna true → existe um próximo elemento na lista.
			  it.hasNext() retorna false → você já percorreu toda a lista, o loop termina.
			  it.next() → retorna o próximo elemento da lista e avança o iterador.*/
			Emprestimo emp = it.next();// pega o próximo elemento
			
	        if(emp.getLivro().getTitulo().trim().equalsIgnoreCase(tituloLivro.trim()) 
	           && emp.getDataDevolucao() == null) {
	            
	            emp.registrarDevolucao();            	 	// marca a data da devolução
	            emp.getLivro().setDisponivel(true);   		// deixa o livro disponível
	
	            System.out.println(emp.toStringDevolucao());
	            /*hasNext() → “tem mais elementos pra percorrer?”
				  next() → “me dá o próximo elemento”.
				  remove() → remove o elemento retornado pelo next() de forma segura.*/
	            
	            it.remove(); 								 // remove com segurança do Iterator
	
	            // sobrescreve o arquivo com a lista atualizada
	            try {
	                CSVUtil.salvarCSV(emprestimos, "/home/leandro/eclipse-workspace/Biblioteca/emprestimos.csv");
	            } catch (IOException e) {
	                System.out.println("Erro ao atualizar arquivo: " + e.getMessage());
	            }
	
	            System.out.println("Devolucao registrada com sucesso\n");
	            devolvido = true;
	            break;
	        }
	    }

		if(!devolvido) {
	        System.out.println("Nenhum empréstimo ativo encontrado para este livro.");
	    }
	}

	/*METODO PARA CARREGAR OS ARQUIVOS .CSV*/
	public void carregarArquivo() {
		try {
			//Atualizo a biblioteca com os arquivos .csv
	        setLivros(CSVUtil.lerLivroCSV("/home/leandro/eclipse-workspace/Biblioteca/livros.csv"));;
	        setLeitores(CSVUtil.lerLeitorCSV("/home/leandro/eclipse-workspace/Biblioteca/leitores.csv"));
	        setEmprestimos(CSVUtil.lerEmprestimoCSV("/home/leandro/eclipse-workspace/Biblioteca/emprestimos.csv", leitores, livros));
	        System.out.println("Arquivos carregados com sucesso!");
	        
	    } catch (IOException e) {
	        System.out.println("Erro ao carregar arquivos: " + e.getMessage());
	    }
	}
}


