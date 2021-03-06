package modelo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
	public SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public Nota[] notas = new Nota[4];
	public int ra;
	public String nome;
	public Date nasc;
	public int idade;

	@SuppressWarnings("deprecation")
	public int Idade() {

		Date hoje = new Date();
		idade = hoje.getYear() - nasc.getYear();
		int mes = hoje.getMonth() - nasc.getMonth();
		if (mes < 1) {
			idade--;
		}
		return idade;
	}
	public String formatAluno() {
		return ra + "\t" + nome + "\t" + Idade();
	}

	public Aluno(int ra, String nome,Date nasc) {
		this.ra = ra;
		this.nome = nome;
		this.nasc = nasc;
	}

	public String formatLista() {
		return ra + " " + nome + " " + Idade() + " " + df.format(nasc);
	}
}
