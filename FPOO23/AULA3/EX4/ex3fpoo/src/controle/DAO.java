package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Planilha;


public class DAO {

	private BufferedReader br;
	private String path = "C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO23\\AULA3\\EX4\\ex3fpoo\\dados\\Usuarios.csv";
	
	public ArrayList<Planilha> abrir(){
		ArrayList<Planilha> lista = new ArrayList<>();
		Planilha usuario; 
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				usuario = new Planilha(linha);
                lista.add(usuario);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return lista;
	}
}
