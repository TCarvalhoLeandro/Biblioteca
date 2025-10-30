package entities;

public class Livro {
	
	private int id;// id do livro
	private String titulo;//nome do livro
	private String autor;//nome do autor
	private int ano;//ano de publicação
	private boolean disponivel;//disponibilidade do livro
	
	public Livro() {
		//construtor padrao
	}
	
	//construtor com todos os atributos
	public Livro(int id, String titulo, String autor, int ano, boolean disponivel) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.disponivel = disponivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void emprestar() {
		setDisponivel(false);
	}
	
	public void devolver() {
		setDisponivel(true);
	}
	
	@Override
	public String toString(){
		 return id + " - " + titulo + " - "+ autor + " - " + ano; 
	}
	
	
}
