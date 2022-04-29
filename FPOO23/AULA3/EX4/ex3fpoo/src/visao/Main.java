package visao;

import java.util.Scanner;

import controle.Processa;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Processa.carregar();
		System.out.println("Digite o email: ");
		int indice = Processa.checarEmail(scan.next());
		if(indice != -1){
			System.out.println("Digite a senha: ");
				String senha = scan.next();
				if(Processa.checarSenha(indice, senha)) {
					System.out.println("Acesso Permitido");
				}else {
					System.out.println("Acesso negado!");
				}
			
		}else {
			System.out.println("Usuário não encontrado.");
		}
		

	}

}