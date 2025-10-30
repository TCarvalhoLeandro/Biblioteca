package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.Biblioteca;


/*CLASSE CRIADA PARA GERENCIAR O MENU DO LIVRO*/
public class MenuLivro {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void menuLivro()  {
		
		try {
			System.out.println("[0] - Voltar");
			System.out.println("[1] - Cadastrar Livro");
			System.out.println("[2] - Listar Livros");
			System.out.println("[3] - Remover Livro");
			System.out.println();
			System.out.println("Digite a opcao desejada: ");
			
			int opcao = Integer.parseInt(br.readLine());
			switch(opcao){
				case 0:
					return;
				case 1:
					Biblioteca bbl = new Biblioteca();
					bbl.cadastrarLivro();
					break;
			}
			
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
