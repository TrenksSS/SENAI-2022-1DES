package modelo;

public class Planilha {

	private String email;
	private String senha;

	public Planilha(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Planilha(String linha) {
		this.email = linha.split(";")[0];
		this.senha = linha.split(";")[1];
	}

	@Override
	public String toString() {
		return email + "\t" + "*******";
	}

}