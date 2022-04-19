package visao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arquivo {
	
	public void escrever(String data) {
		
		try {
			FileWriter fw = new FileWriter("povo.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(data);
			
			bw.close();
			fw.close();
		}catch(Exception e) {
		}
		
	}
	
	public ArrayList<String> ler (String fileName) {
		ArrayList<String> data = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader("povo.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String linha = "";
			
			while((linha = br.readLine()) != null) {
				data.add(linha);
			}
			
			br.close();
			fr.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return data;
	}
	
}