package ex2;

import java.util.Random;
import java.util.Scanner;

public class ex {
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 4) {
			System.out.print(
					"1.Vetores:\n2.Inverter Vetores:\n3.Dividir e Multiplicar:\n4.Bustar Nomes:\n5.Diferença de Vetores:\n6.Crescente Decrescente:\n7.Iguais:\n8.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				Maiores();
				break;
			case 2:
				elementos();
				break;
			case 3:
				positivos();
				break;
			case 4:
				nomes();
				break;
			case 5:
				monte();
				break;
			case 6:
				organize();
				break;
			case 7:
				funcao();
				break;
			default:

				break;
			}
		}
	}

	public static void Maiores() {
		Random rand = new Random();
		int[] v = new int[10];
		System.out.println("Digite 10 numeros: ");
		for (int i = 0; i < v.length; i++) {
			v[i] = scan.nextInt();
		}
		for (int i = 0; i < v.length; i++) {
			System.out.println(+v[i]);
		}
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[9 - i]);
		}
	}

	public static void elementos() {
		int[] v = new int[10];
		int[] j = new int[10];
		System.out.println("Digite 10 numeros: ");
		for (int i = 0; i < v.length; i++) {
			v[i] = scan.nextInt();
		}
		for (int i = 0; i < v.length; i++) {
			System.out.println(+v[i]);
		}
		for (int i = 0; i < v.length; i++) {
			System.out.println(j[i] = v[9 - i]);
		}

	}

	public static void positivos() {
		int[] v = new int[10];
		int[] j = new int[10];
		System.out.println("Digite 10 numeros positivos inteiros: ");
		for (int i = 0; i < v.length; i++) {
			v[i] = scan.nextInt();
		}
		System.out.println("Primeiro vetor:");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + "\t");
		}

		for (int i = 0; i < v.length; i++) {
			if (i % 2 == 0) {
				j[i] = v[i] / 2;
			} else {
				j[i] = v[i] * 3;

			}
		}
		System.out.println();
		System.out.println("Segundo vetor:");
		for (int i = 0; i < j.length; i++) {
			System.out.print(j[i] + "\t");
		}
	}

	public static void nomes() {
		int c = 0;
		String[] v = new String[10];
		System.out.println("Cadastre 10 nomes: ");

		for (int i = 0; i < v.length; i++) {
			v[i] = scan.next();

		}

		System.out.println("Digite o nome que deseja: ");
		String n = scan.next();

		for (int i = 0; i < v.length; i++) {
			if (v[i].equals(n)) {
				System.out.println("Achei");
				c++;

			}
		}

		if (c != 0) {
			System.out.println("O numero de vezes que o nome aparece: " + c);

		} else {
			System.out.println("Não achei");
		}
	}

	public static void monte() {
		Random rand = new Random();
		int[] v1 = new int[20];
		int[] v2 = new int[20];
		int[] v3 = new int[20];
		int[] v4 = new int[20];
		int[] v5 = new int[20];

		System.out.println();
		System.out.println("Vetor 1: ");
		for (int i = 0; i < v1.length; i++) {
			v1[i] = rand.nextInt(20);
			System.out.print(v1[i] + "\t");
		}
		System.out.println();
		System.out.println("Vetor 2: ");
		for (int i = 0; i < v2.length; i++) {
			v2[i] = rand.nextInt(20);
			System.out.print(v2[i] + "\t");
		}

		for (int i = 0; i < v2.length; i++) {
			v3[i] = v2[i] - v1[i];
			v4[i] = v2[i] + v1[i];
			v5[i] = v2[i] * v1[i];

		}
		System.out.println("\nSubtração dos vetores: ");
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v3[i] + "\t");
		}

		System.out.println("\nSoma dos vetores: ");
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v4[i] + "\t");
		}

		System.out.println("\nMultiplicação entre vetores: ");
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v5[i] + "\t");
		}

		System.out.println();
	}

	public static void organize() {
		System.out.println("Digite a quantidade de números que você deseja digitar: ");
		int n = scan.nextInt();
		int a = 0;
		int b = 0;
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Digite um número: ");
			v[i] = scan.nextInt();
			if (v[i] % 2 == 0) {
				a++;

			} else {
				b++;
			}
		}

		int[] v1 = new int[a];
		int[] v2 = new int[b];
		int p = 0, j = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[i] % 2 == 0) {
				v1[p] = v[i];
				p++;

			} else {
				v2[j] = v[i];
				j++;
			}
		}

		int valor;

		for (int i = 0; i < v1.length; i++) {
			for (int k = 0; k < v1.length; k++) {
				if (v1[i] < v1[k]) {
					valor = v1[i];
					v1[i] = v1[k];
					v1[k] = valor;

				}
			}
		}

		for (int i = 0; i < v2.length; i++) {
			for (int l = 0; l < v2.length; l++) {
				if (v2[i] > v2[l]) {
					valor = v2[i];
					v2[i] = v2[l];
					v2[l] = valor;

				}

			}
		}

		System.out.println("Números pares: ");
		for (int i = 0; i < v1.length; i++) {
			System.out.print(v1[i] + "\t");
		}

		System.out.println();
		System.out.println("Números impares: ");
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i] + "\t");
		}
		System.out.println("\n");
	}

	public static void funcao() {

		Random rand = new Random();
		System.out.println("Digite a quantidade de números que deseja digitar: ");
		int qtd = scan.nextInt();
		int[] v = new int[qtd];
		int[] v1 = new int[qtd];

		System.out.println("Primeiro vetor: ");
		for (int i = 0; i < qtd; i++) {
			v[i] = rand.nextInt(10);
			System.out.print(v[i] + "\t");
		}

		System.out.println("\nSegundo vetor: ");
		for (int i = 0; i < qtd; i++) {
			v1[i] = rand.nextInt(10);
			System.out.print(v1[i] + "\t");
		}

		System.out.println("\nNúmeros iguais: ");
		for (int i = 0; i < qtd; i++) {
			for (int j = 0; j < qtd; j++) {
				if (v[i] == v1[j]) {
					int x = v[i];
					System.out.print(x + "\t");

				}
			}

		}

		System.out.println();
	}
}
