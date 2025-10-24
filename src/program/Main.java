package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import service.Biblioteca;
import service.GerenciaDados;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Biblioteca biblioteca = new Biblioteca();// Cria o componente de dados

		System.out.println("=".repeat(15) + " BIBLIOTECA DO LEANDRO " + "=".repeat(15));

		System.out.println("[0] - Sair");
		System.out.println("[1] - Gerenciar livros");
		System.out.println("[2] - Gerenciar leitores");

		System.out.println();
		System.out.print("Escolha uma opção: ");
		int opcao = Integer.parseInt(br.readLine());
		System.out.println("=".repeat(53));

		// Injeta o componente na classe de serviço/gerenciamento (Composição)
		GerenciaDados gerenciaLivro = new GerenciaDados(biblioteca);
		gerenciaLivro.executar(opcao);

	}

}
