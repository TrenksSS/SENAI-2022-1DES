package visao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


public static void main(String[] args) {
	
	Arquivo arq = new Arquivo();
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	
	do {
		System.out.println("1 - Criar frase;");
	System.out.println("2 - Mostrar imagem;");
	System.out.println("0 - Sair;");
	opcao = input.nextInt();
	input.nextLine();
	
	switch(opcao) {
	
	case 1:
			System.out.println("Digite uma frase: ");
			String fras = input.nextLine();
		
			String data = "<center>" + "<h1>" + fras + "</h1>" + "</center>" + "<br>" +"\r\n";
			
			
			arq.escrever(data);
			break;
			
	case 2:
		System.out.println("Coloque o link de uma imagem entre aspas");
		String img = input.nextLine();
		
		String data1 = "<center>" +"<img src=" + img + "></img>"+ "</center>" + "\r\n";
		
		arq.escrever(data1);
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