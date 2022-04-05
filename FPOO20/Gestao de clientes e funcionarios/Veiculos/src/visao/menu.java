package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.carro;
import modelo.moto;

public class menu {
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static ArrayList<carro> Carro = new ArrayList<>();
	private static ArrayList<moto> Moto = new ArrayList<>();

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 5) {
			System.out.println(
					"1.Cadastrar Carro\n2.Cadastrar Moto\n3.Listar Carros\n4.Lstar Motos\n5.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarCarro();
				break;
			case 2:
				cadastrarMoto();
				break;
			case 3:
				listarCarro();
				break;
			case 4:
				listarMoto();
				break;
			case 5:
				System.out.println("Opção invalida");
				break;
			}

		}
	}

	private static void listarMoto() {
		for (moto m : Moto ) {
			System.out.println(m.toString());
		}
	}

	private static void listarCarro() {
		for (carro c : Carro) {
			System.out.println(c.toString());
		}
	}

	private static void cadastrarCarro() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Para cadastrar um cliente digite as seguintes iformações:");
		System.out.println("Placa\t\tAno Modelo\tAno de fabricação\tModelo\tMarca\tValor\tTipo\tNumero de passageiros");
		carro Carros = new carro(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),
				scan.nextDouble(), scan.nextInt(), scan.nextInt());
		Carro.add(Carros);
	}

	private static void cadastrarMoto() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Para cadastrar um funcionario digite as seguintes iformações:");
		System.out.println("Placa\tAno Modelo\tAno de fabricação\tModelo\tMarca\tValor\tCilindradas");
		moto Motos = new moto(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),
				scan.nextDouble(), scan.nextInt());
		Moto.add(Motos);

	}

}



