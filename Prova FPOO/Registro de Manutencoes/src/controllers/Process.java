package controllers;

import java.util.ArrayList;
import models.Manu;
public class Process {

	public static ArrayList<Manu> manu = new ArrayList<>();
	private static Dao pd = new Dao();
	
	public static void abrir() {
		manu = pd.ler();
	}
	
	public static void salvar() {
		pd.escrever(manu);
	}
	
//	public static void carregarTestes() {
//		// Limpar a lista
//		manu = new ArrayList<>();
//		// Preencher com testes
//		manu.add(new Manu(1, "", "", "",""));
//		manu.add(new Manu(2, "", "", "",""));
//		manu.add(new Manu(3, "", "", "",""));
//		manu.add(new Manu(4, "", "", "",""));
//	}
}
