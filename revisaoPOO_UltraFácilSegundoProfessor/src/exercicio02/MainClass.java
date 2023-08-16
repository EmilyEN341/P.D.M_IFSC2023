package exercicio02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			ArrayList<Pessoa> listaPessoas = new ArrayList<>();
			System.out.println("Quantidade para adicionar na lista");
			Integer qtd = Integer.valueOf(s.nextLine());
			
			for (int i = 0; i < qtd; i++) {
				Pessoa pessoa = new Pessoa();
				System.out.println("Nome: ");
				pessoa.nome = s.nextLine();
				pessoa.email = s.nextLine();
				pessoa.telefone = Long.valueOf(s.nextLine());
				pessoa.nome_cidade = s.nextLine();
				pessoa.rua = s.nextLine();
				pessoa.numero = Integer.valueOf(s.nextLine());
				
				listaPessoas.add(pessoa);
			}
			
			for (Pessoa p : listaPessoas) {
				System.out.println("Nome: " + p.nome);
				System.out.println("Email: " + p.email);
				System.out.println("Telefone: " + p.telefone);
				System.out.println("Cidade: " + p.nome_cidade);
				System.out.println("Rua: " + p.rua);
				System.out.println("Número: " + p.numero);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}