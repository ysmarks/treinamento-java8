package introducaoOptional.classe;

public class Carro {
	
	private Seguradora seguradora;
	private String nome;
	
	public Carro(Seguradora seguradora, String nome) {
		super();
		this.seguradora = seguradora;
		this.nome = nome;
	}
	
	public Carro() {}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
