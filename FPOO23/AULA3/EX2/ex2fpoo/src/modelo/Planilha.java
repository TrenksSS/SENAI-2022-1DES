
package modelo;

public class Planilha {
	private String s1;
	private double v1;
	private double v2;
	private double v3;
	
	
	public Planilha(String entrada) {
		s1 = (entrada.split(";")[0]);
		v1 = Double.parseDouble(entrada.split(";")[1]);
		v2 = Double.parseDouble(entrada.split(";")[2]);
		v3 = Double.parseDouble(entrada.split(";")[3]);
	}
	public String med() {
		double media = (v1 + v2 + v3)/3;
		return s1 + "\t" + String.format("%.2f"  , media);
	}

}
