package service;

import java.time.LocalDate;

import entities.Leitor;
import entities.Livro;

public class Emprestimo {
	
	private int id;
	private Leitor leitor;
	private Livro livro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private boolean devolvido;
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(int id, Leitor leitor, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao,
			boolean devolvido) {
		this.id = id;
		this.leitor = leitor;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.devolvido = devolvido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	public void registrarDevolucao() {
		
	}
	
	public long diasAtrasados() {
		return 1;
	}
	
}
