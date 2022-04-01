package modelo;

public class Animal {
	private String especie;
	private float peso;
	private String raca;
	private String nome;

	public Animal(String especie, float peso, String cor, String nome) {
		this.especie = especie;
		this.peso = peso;
		this.raca = raca;
		this.nome = raca;
	}

	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", peso=" + peso + ", raca=" + raca + ", nome=" + nome + "]";
	}
	

}
