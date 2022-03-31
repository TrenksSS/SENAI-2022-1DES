package modelo;

public class Nota {

	public String materia;
	public int nota1;
	public int nota2;
	public int nota3;
	public float media;

	public Nota(String materia, int a, int b, int c) {
		int cont = 0;
		this.materia = materia;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		if (nota1 != -1) {
			cont++;
		} else {
			nota1++;
		}
		if (nota2 != -1) {
			cont++;
		} else {
			nota2++;
		}
		if (nota3 != -1) {
			cont++;
		} else {
			nota3++;
		}

		this.media = (nota1 + nota2 + nota3) / (cont);

	}

	public String formatMedia() {

		return "\n" + materia + " " + nota1 + " " + nota2 + " " + nota3 + " " + media;
	}
}