package visao;

import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {


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
			System.out.println("Informe a marca do veiculo: ");
			String marca = input.next();
			
			System.out.println("Informe o modelo do veiculo");
			String modelo = input.next();
			
			System.out.println("Informe a cor do veículo:");
			String cor = input.next();
			
			System.out.println("DIgite a placa do veiculo:");
			String placa = input.next();
			
			String data = marca + ";" + modelo + ";" + cor + ";" + placa;
			
			
			arq.escrever(data, "Estacionamento", true);
			break;
			
	case 2:
			ArrayList<String> infoFile = arq.ler("Estacionamento");
			
			for(String linha : infoFile) {
				System.out.println(linha);
			}
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
