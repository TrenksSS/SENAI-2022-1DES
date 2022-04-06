package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class veiculo {
	private String placa;
	private int anoModelo;
	private int anoFabricado;
	private String modelo;
	private String marca;
	private double valor;

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public veiculo(String placa, int anoModelo, int anoFabricado, String modelo, String marca, double valor) {
		this.placa = placa;
		this.anoModelo = anoModelo;
		this.anoFabricado = anoFabricado;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\t" + placa + "\t" + anoModelo + "\t" + anoFabricado + "\t" + modelo + "\t" + marca + "\t" + valor;
	}

}
