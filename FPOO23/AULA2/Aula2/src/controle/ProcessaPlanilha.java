package controle;

import java.util.ArrayList;

import modelo.Planilha;

public class ProcessaPlanilha {
	static ArrayList<Planilha> linha =new ArrayList<>();
	
	private static DAO dao = new DAO(); 
	public static void  carregar(){
		linha = dao.abrir();
		
	}
	public static void saida(int opcao) {
		switch(opcao) {
		case 1:
			dao.salvarSoma(linha);
			break;
		case 2:
		dao.salvarMult(linha);
		break;
		case 3:
			dao.salvarSub(linha);
			break;
		case 4:
			dao.salvarDiv(linha);
			break;
		
	}
	}
}
