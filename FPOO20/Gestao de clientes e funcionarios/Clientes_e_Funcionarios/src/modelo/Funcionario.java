package modelo;

import java.util.Date;

public class Funcionario extends Pessoa {
	private int matricula;
	private double comissao;

	public Funcionario(String nome, String telefone, Date nascimeto, int matricula, double comica) {
		super(nome, telefone, nascimeto);
		this.comissao = comissao;
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "" + matricula + "\t" + comissao + "]";
	}
	

}
