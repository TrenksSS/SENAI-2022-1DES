package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Orcamento;

public class OrcamentoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "C:\\Users\\suporte\\Desktop\\Proa java 03 junho\\Registro de Orçamentos\\orcamentos\\Orçamento.csv";
	
	public ArrayList<Orcamento> ler(){
		ArrayList<Orcamento> linhas = new ArrayList<>();
		Orcamento o;
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = br.readLine();
			
			while(linha != null) {
				o = new Orcamento(linha);
				linhas.add(o);
				linha = br.readLine();
			}
			
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Orcamento> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			for (Orcamento o : linhas) {
				bw.write(o.toCSV());
			}
			bw.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
