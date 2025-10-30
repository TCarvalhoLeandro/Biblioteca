package entities;

public class Leitor {
	
	private int id;//id do leitor
	private String nome;// nome do leitor
	private String cpf;//cpf do leitor
	private String email;//email do leitor
	
	public Leitor() {
		//construtor padrão
	}

	//construtor com todos os argumentos
	public Leitor(int id, String nome, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return id + " - " + nome + " - (" + cpf + ") - " + email;
	}
	
	
}
