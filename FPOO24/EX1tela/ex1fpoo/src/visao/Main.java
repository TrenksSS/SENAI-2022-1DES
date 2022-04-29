package visao;

import java.util.Scanner;

import controle.Processa;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Processa.carregar();
		int menu = 0;
		
		while (menu != 2) {
		 System.out.println("Precione 1 para calcular a idade!");
		 menu = scan.nextInt();
		 
		 Processa.saida(menu);
		}

	}

}
