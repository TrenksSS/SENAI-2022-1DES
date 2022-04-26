package modelo;

public class Planilha {
	//Atributos
	private int v1;
	private int v2;
	private int v3;
	//Construtor
	public Planilha(String entrada) {
		v1 = Integer.parseInt(entrada.split(";")[0]);
		v2 = Integer.parseInt(entrada.split(";")[1]);
		v3 = Integer.parseInt(entrada.split(";")[2]);
	}
	//Métodos para Processamento
	public int adicao() {
		return v1 + v2 + v3;
	}
	public int mult() {
		return v1 * v2 * v3;
	}
	public int sub() {
		return v1 - v2 - v3;
	}
	public int div() {
		return v1 / v2 / v3;
	}
}
