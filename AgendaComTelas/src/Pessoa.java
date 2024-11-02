

public class Pessoa {
	private String nome;
	private String email;
	private String celular;
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa(String nome, String celular, String email, String tipo) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.tipo = tipo;
	}

	public Pessoa() {
	}

	@Override
	public String toString() {
		return this.nome + "," + this.celular + "," + this.email + "," + this.tipo;
	}
	
}
