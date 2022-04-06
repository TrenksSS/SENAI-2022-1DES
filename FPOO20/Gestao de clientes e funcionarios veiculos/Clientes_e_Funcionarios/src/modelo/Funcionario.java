package modelo;

import java.util.Date;

public class Funcionario extends Pessoa {
	private int matricula;
	private double comissao;

	public Funcionario(String nome, String telefone, Date nascimento, int matricula, double comissao) {
		super(nome, telefone, nascimento);
		this.comissao = comissao;
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "" + matricula + "\t" + comissao + super.toString();
	}
	

}
