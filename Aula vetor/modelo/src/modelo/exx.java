package modelo;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class exx {
	public static Scanner scan; 
	public static void main(String[] args) throws IOException {
	 scan = new Scanner(System.in);
	 int menu = 0;
	 
	 while (menu!=4) {
		 System.out.println("1 numeros\n  2- numeros reais\n  3- nomes\n 4- sair");
		 menu = scan.nextInt();
		switch(menu) {
		case 1:
			GerarInteiro();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			System.out.println("Obrigado!");
			break;
		default:
			System.out.println("Op�ao invalida!");
			break;
			} 
	 	}
	 
	}
		public static void GerarInteiro() {
			scan = new Scanner(System.in);
			Random rand = new Random();
			
			System.out.println("Digite quanto numeros deseja gerar:");
			int qntd = scan.nextInt();
			
			int[] numeros = new int[qntd];
			
			for (int i = 0; i < qntd; i++) {
				numeros[i] = rand.nextInt(100);
				System.out.println(numeros[i]);
			}
		}
						
			public static void GerarReal() {
					scan = new Scanner(System.in);
					Random rand = new Random();
					
					System.out.println("Digite quanto numeros deseja gerar:");
					int qntd = scan.nextInt();
					double[] numeros = new double[qntd];
					
					for (int i = 0; i < qntd; i++) {
						numeros[i] = rand.nextDouble() *(100);
							System.out.printf("%.2f\n", numeros[i]);
			
				}
			}
		}
					
