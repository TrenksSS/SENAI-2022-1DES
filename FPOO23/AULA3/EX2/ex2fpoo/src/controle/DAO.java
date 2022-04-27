package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Planilha;

public class DAO {
	private BufferedWriter bw;
	private BufferedReader br;
	private String entrada = "C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO23\\AULA3\\EX2\\ex2fpoo\\dados\\entradas.csv";
	private String saida = "C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO23\\AULA3\\EX2\\ex2fpoo\\dados\\saida.csv";

	public ArrayList<Planilha> abrir() {
		ArrayList<Planilha> linhas = new ArrayList<>();
		Planilha p;
		try {
			br = new BufferedReader(new FileReader(entrada));
			String l = br.readLine();
			while (l != null) {
				p = new Planilha(l);
				linhas.add(p);
				l = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linhas;
	}
	public void salvarmed(ArrayList <Planilha> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(saida));
			for (Planilha l : linhas) {
				bw.write(l.med()+ "\r\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
