package modelo;

public class Gato extends Animal{
	private int qtdVidas = 7;

	public Gato(String especie, float peso, String cor, String nome, int qtdVidas) {
		super(especie, peso, cor, nome);
		this.qtdVidas = qtdVidas;
	}

	@Override
	public String toString() {
		return "Gato [qtdVidas=" + qtdVidas + "]";
	}
	
}
