package entities;

public class Livro {
	
	private int isbn;
	private String titulo;
	private String autor;
	private int ano;
	private boolean disponivel;
	
	public Livro() {
		
	}
	
	public Livro(int isbn, String titulo, String autor, int ano, boolean disponivel) {
		// Regra de Negócio/Validação Intrínseca
		if(isbn <= 0) {
			throw new IllegalArgumentException("ISBN deve ser positivo.");
		}
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("Titulo é obrigatorio.");
		}
		if(autor == null || autor.trim().isEmpty()) {
			throw new IllegalArgumentException("Autor é  obrigatorio.");
		}
		if(ano <= 1900 ||ano > 2025) {
			throw new IllegalArgumentException("Ano inválido.");
		}
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.disponivel = disponivel;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public boolean emprestar() {
		return false;
	}
	
	public boolean devolver() {
		return true;
	}
	
	public String toString() {
		return String.format("%d - %s - (%s) - %d", isbn, titulo, autor, ano); 
	}
}
