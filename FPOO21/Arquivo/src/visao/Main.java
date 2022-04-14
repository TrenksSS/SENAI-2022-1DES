package visao;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args) {

		try {

			FileWriter fw = new FileWriter("base.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Meu primeiro arquivo.\r\n");

			bw.close();
			fw.close();

		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}
}
