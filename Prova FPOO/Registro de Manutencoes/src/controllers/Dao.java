package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.Manu;

public class Dao {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "./dados/manutencao.csv";
	
	public ArrayList<Manu> ler() {
		ArrayList<Manu> linhas = new ArrayList<>();
		Manu p;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				p = new Manu(linha);
				linhas.add(p);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Manu> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Manu p : linhas) {
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
