package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {
	private int id;
	private String especie;
	private String nomePet;
	private String raca;
	private float peso;
	private Date nascimento;
	private String nomeDono;
	private String telefone;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Pet(int id, String especie, String nomePet, String raca, float peso, String nascimento, String nomeDono,
			String telefone) throws ParseException {
		this.id = id;
		this.especie = especie;
		this.nomePet = nomePet;
		this.raca = raca;
		this.peso = peso;
		this.nascimento = sdf.parse(nascimento);
		this.nomeDono = nomeDono;
		this.telefone = telefone;
	}
	public int obterIdade() {
		return new Date().getYear()-nascimento.getYear();
	}

	@Override
	public String toString() {
		return  + id + " " + especie + "\t" + nomePet + "\t" + raca + "\t" + peso
				+ sdf.format(nascimento)+ "\t" + obterIdade()  + "\t" + nomeDono + "\t" + telefone +"\n";
	}

}
