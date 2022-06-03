package controllers;

import java.text.ParseException;
import java.util.ArrayList;

import dao.OrcamentoDAO;
import models.Orcamento;



public class OrcamentoProcess {

	public static ArrayList<Orcamento> orcamento = new ArrayList<>();
	private static OrcamentoDAO md = new OrcamentoDAO();
	
	public static void abrir() {
		try {
			orcamento = md.ler();
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void salvar() {
		md.escrever(orcamento);
		abrir();
	}
}
