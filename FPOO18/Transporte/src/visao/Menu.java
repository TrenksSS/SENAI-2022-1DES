package visao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.Veiculo;

public class Menu {
	private static Scanner Scan = new Scanner(System.in);
	private static Veiculo veiculos[] = new Veiculo[10];
	private static String itens[] = {"cadastrar veiculo", "Listar Veiculo", "Sair"};
	private static int menu = 0;
	private static int indice = 0;
	public static void main(String[] args) {
			while (menu != 3) {
				menu = menu(itens);
				switch(menu) {
			case 1:
				private static int printMenu(String[] itrn) {
					for (int i = 0; i< itens.length;i++)
						System.out.println("Escolha uma opção");
				}
				break;
			case 2:
				break;
			case 3:
				System.out.println("Até logo e volte sempre.");
				break;
			default:
				System.out.println("Opção inválida");
				break;
				}
			}
		}
	private static int menu(String[] itens) {
		System.out.println("\t._______________________.");
		for (int i = 0; i < itens.length; i++) {
			System.out.println("\t|" + (i + 1) + "." + itens[i] + "\t|");
		}
		System.out.println("\t:___Escolha uma opção___:");
		return Scan.nextInt();
	}
}

