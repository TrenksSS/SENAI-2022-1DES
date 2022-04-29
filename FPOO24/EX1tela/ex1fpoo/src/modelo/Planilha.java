package modelo;

public class Planilha {
	private String s1;
	private int v1;
	
	public Planilha(String entrada) {
		s1 = (entrada.split(";")[0]);
		v1 = Integer.parseInt(entrada.split(";")[1]);
	}
	public int sub() {
		return 2022 - v1;
	}

}
