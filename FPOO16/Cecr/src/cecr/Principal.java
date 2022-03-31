package cecr;

import java.util.Scanner;
import cecr.Cer;

public class Principal {
	public static Scanner scan;
	public static Cer[] cer = new Cer[10];

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 4) {
			System.out.print("1.CAdastrar alunos\n2.Elementos:\n3.Media e mediana\n4.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarAluno();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			default:

				break;
			}
		}
	}

	private static void cadastrarAluno() {
		System.out.println("Em desenvolvimento");
		
	}


}
