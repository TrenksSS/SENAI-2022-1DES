package visao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.Aluno;

public class Principal {

	static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	static int valor = 0;
	static Scanner input = new Scanner(System.in);
	static int ra;
	static Aluno[] alunos = new Aluno[10];

	public static Scanner scan;

	public static void main(String[] args) throws IOException, ParseException {
		scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 8) {
			System.out.print(
					"1.Cadastrar alunos\n2.Cadastrar notas\n3.Listar todos alunos\n4.Listar todas as notas\n5.Buscar aluno\n6.Listar alunos aprovados\n7.Listar alunos reprovados\n8.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarAlunos();
				break;
			case 2:
				cadastrarNotas();
				break;
			case 3:
				listarAlunos();
				break;
			case 4:
				listarNotas();
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:
				System.out.println("Adeus");
				break;
			default:
				System.out.println("Op??o invalida");
				break;
			}
		}
	}

	private static void cadastrarAlunos() throws ParseException {
		ra++;
		System.out.println("ra\tNome\tdata de Nascimento");
		alunos[valor] = new Aluno(input.nextInt(), input.next(), df.parse(input.next()));
		valor++;
	}

	public static void cadastrarNotas() {
		System.out.println("Qual aluno?");
		String u = input.next();
		for (int i = 0; i < valor; i++) {
			if ((alunos[i].nome).equalsIgnoreCase(u)) {
				for (int j = 0; j < 4; j++) {
					System.out.println("Materia\t 1 2 3\t -1 se n?o tiver avaliado.");
					alunos[i].notas[j] = new Nota(input.next(), input.nextInt(), input.nextInt(), input.nextInt());

				}
			}
		}
	}

	public static String listarAlunos() {
		System.out.println("ra.\t Nome.\tIdade.");
		for (int i = 0; i < valor; i++) {
			System.out.println(alunos[i].formatAluno());
		}
		return null;
	}

	public static String listarNotas() {
		for (int i = 0; i < valor; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(alunos[i].formatLista());
			}
		}
		return null;
	}
}
