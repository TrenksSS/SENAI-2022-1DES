package visao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


public static void main(String[] args) {
	
	Arquivo arq = new Arquivo();
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	
	do {	System.out.println("1 - Cadastrar;");
	System.out.println("2 - Listar;");
	System.out.println("0 - Sair;");
	opcao = input.nextInt();
	
	switch(opcao) {
	
	case 1:
			System.out.println("Digite seu nome: ");
			String nome = input.next();
			
			System.out.println("Qual a data do seu nascimento?");
			String nasc = input.next();
		
			String data = nome + ";"  + nasc;
			
			
			arq.escrever(data);
			break;
			
	case 2:
			ArrayList<String> infoFile = arq.ler("cadastro");
			
			for(String linha : infoFile) {
				System.out.println(linha);
			}

			String[] temp = linha.split(";") ;
			break;
			
	case 3:
		
		break;
			
	case 0:
		System.out.println("Tixauuu");
		break;
	}
	
	
	
	
	}while(opcao != 0);
}
}