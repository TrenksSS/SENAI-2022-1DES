package ex;

import java.util.Scanner;

public class pesquisa1 {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.print("Digite quantos contatos deseja cadastrar:");
		int qtdCont = scan.nextInt();
		Contato[] contatos = new Contato[qtdCont];
		
		System.out.println("id\tNome\tIdade\tTelefone");
		for(int i = 0; i < qtdCont; i++) {
			contatos[i] = new Contato();
			contatos[i].id = scan.nextInt();
			contatos[i].nome = scan.next();
			contatos[i].idade = scan.nextInt();
			contatos[i].telefone = scan.next();
		}
		int opcao= 0;
		while(opcao !=5)
		System.out.println("1-Mostrar todos\t2-Buscar por ID\t3-Buscar por nome\t4-Buscar por telefone\t5-sair");
		opcao= scan.nextInt();
		switch(opcao){
		case 1:
		for(int i = 0; i < qtdCont; i++) {
			System.out.println(contatos[i].contatoTab());
			}
		
		}
	}

}