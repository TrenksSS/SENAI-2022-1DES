package controle;

import java.util.ArrayList;

import modelo.Planilha;

public class Processa {
	static ArrayList<Planilha> linha =new ArrayList<>();
	
	private static DAO dao = new DAO(); 
	public static void  carregar(){
		linha = dao.abrir();
		
	}
	public static void saida(int opcao) {
		switch(opcao) {
		case 1:
			dao.salvarSub(linha);
			System.out.println("Idade calculada com sucesso!!!");
			break;
		
	}
	}
}