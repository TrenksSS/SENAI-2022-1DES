package modelo;

import java.util.Date;

public class Cliente extends Pessoa{
	private int id;
	private double creditoLimite;
	
	public Cliente(String nome, String telefone, Date nascimeto, int id, double creditoLimite) {
		super(nome, telefone, nascimeto);
		this.id = id;
		this.creditoLimite = creditoLimite;
		
	}

	@Override
	public String toString() {
		return   id + "\t" + creditoLimite + super.toString();
	}
	


}
