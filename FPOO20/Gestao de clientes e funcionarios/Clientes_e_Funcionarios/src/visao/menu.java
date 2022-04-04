package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Funcionario;

public class menu {

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static ArrayList<Cliente>cliente=new ArrayList<>();
	private static ArrayList<Funcionario>funcionario=new ArrayList<>();
	

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		while (menu != 5) {
			System.out.println("1.Cadastrar\n2.Listar\n3.Sair");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				cadastrarFuncionario();
				break;
			case 3:
				listarCliente();
				break;
			case 4:
				listarFuncionario();
				break;
			case 5:
				System.out.println("Opção invalida");
				break;
			}

		}
	}

	private static void listarFuncionario() {
	
	}

	private static void listarCliente() {
	}

	private static void cadastrarCliente() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Para cadastrar um funcionario digite as seguintes iformações:");
		System.out.println("Nome\tFelefone\tData de nascimento\tMatricula\tComição");
		Cliente clientes = new Cliente(scan.next(),scan.next(),df.parse(scan.next()),scan.nextInt(),scan.nextDouble());
		cliente.add(clientes);
	}

	private static void cadastrarFuncionario() throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Para cadastrar um funcionario digite as seguintes iformações:");
		System.out.println("Nome\tFelefone\tData de nascimento\tMatricula\tComição");
		Funcionario funcionarios = new Funcionario(scan.next(),scan.next(),df.parse(scan.next()),scan.nextInt(),scan.nextDouble());
		funcionario.add(funcionarios);
		
	}

}
