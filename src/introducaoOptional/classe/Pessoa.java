package introducaoOptional.classe;

public class Pessoa {

	private Carro carro;
	private String nome;
	
	public Pessoa(Carro carro, String nome) {
		super();
		this.carro = carro;
		this.nome = nome;
	}
	
	public Pessoa() {}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
