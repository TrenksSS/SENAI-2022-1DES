package modelo;

public class Cao extends Animal{
	private int qtdMotoqueirosAtacados;

	public Cao(int qtdMotoqueirosAtacados, String especie, String nome, float peso,String raca) {
		super(especie, peso, raca, nome);
		this.qtdMotoqueirosAtacados = qtdMotoqueirosAtacados;
	}

	@Override
	public String toString() {
		return "Cao [qtdMotoqueirosAtacados=" + qtdMotoqueirosAtacados + "]";
	}
	


}
