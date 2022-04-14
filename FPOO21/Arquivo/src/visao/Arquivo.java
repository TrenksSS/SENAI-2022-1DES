package visao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arquivo {

	public void Escrever(String info) {
		try {
			FileWriter fw = new FileWriter(fileName + ".txt", append);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(info + "\r\n");
			
			bw.close();
			fw.close();
			
			
		}catch(Exception e) {
		
	}
			public ArrayList<String> ler (String fileName) {
				ArrayList<String> data = new ArrayList<>();
				
				
			} 

}
}
