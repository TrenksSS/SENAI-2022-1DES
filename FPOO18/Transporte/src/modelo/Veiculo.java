package modelo;

public class Veiculo {

	public String Placa;
	public String marca;
	public String modelo;
	public int anoModelo;
	public int anoFabricacao;
	public String cor;
	public Veiculo() {
	}

	public Veiculo(String Placa, String marca, String modelo, int anoModelo, int anoFabricacao, String cor) {
		this.Placa = Placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
	}
	

	public String paraString() {
		return Placa + "\t" + marca + "\t" + modelo + "\t" + anoModelo + "\t" + anoFabricacao + "\t" + cor ;
	}
}
