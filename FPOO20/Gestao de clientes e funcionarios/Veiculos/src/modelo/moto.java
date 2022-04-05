package modelo;

import java.util.Date;

public class moto extends veiculo {
	private int cilindradas;

	public moto(String placa, int anoModelo, int anoFabricado, String modelo, String marca, double valor, int cilindradas) {
		super(placa, anoModelo, anoFabricado, modelo, marca, valor);
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return "" + cilindradas + super.toString();
	}
	
}
