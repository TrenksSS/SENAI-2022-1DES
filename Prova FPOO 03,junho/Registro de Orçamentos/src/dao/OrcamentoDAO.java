package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import models.Orcamento;

public class OrcamentoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "C:\\Users\\suporte\\Desktop\\Prova FPOO 03,junho\\Registro de Orçamentos\\orcamentos\\orcamentos.csv";
	
	public ArrayList<Orcamento> ler() throws ParseException {
		ArrayList<Orcamento> linhas = new ArrayList<>();
		Orcamento manu;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				manu = new Orcamento(linha);
				linhas.add(manu);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Orcamento> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Orcamento m : linhas) {
				bw.write(m.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
