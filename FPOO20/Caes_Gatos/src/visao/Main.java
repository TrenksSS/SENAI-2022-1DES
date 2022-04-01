package visao;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cao;
import modelo.Gato;

public class Main {
	private static ArrayList<Cao> caes = new ArrayList<>();
	private static ArrayList<Gato> gatos = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 3) {
			System.out.println("1.Cadastrar\n2.Listar\n3.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarGato();
				break;
			case 2:
				cadastrarCao();
				break;
			case 3:
				break;
			case 4:
				break;
			}

		}
	}

	private static void cadastrarGato() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Especie\tNome\tPeso\tRaça\tQuantidade de Vidas");
		Gato gato = new Gato(scan.next(), scan.nextFloat(), scan.next(), scan.next(), scan.nextInt());
	}

	private static void cadastrarCao() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Especie\tNome\tPeso\tRaça\tQuantidade de motoquiros atacados");
		Cao cao = new Cao(scan.nextInt(), scan.next(), scan.next(), scan.nextFloat(), scan.next());

	}

}
