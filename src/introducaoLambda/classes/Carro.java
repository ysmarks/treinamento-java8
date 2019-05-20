package introducaoLambda.classes;

public class Carro {

	private String nome;
	private String cor;
	private int ano;
	
	public Carro(String nome, String cor, int ano) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.ano = ano;
	}
	public Carro(String cor, int ano) {
		this.cor = cor;
		this.ano = ano;
	}

	public Carro() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Carro [nome=" + nome + ", cor=" + cor + ", ano=" + ano + "]";
	}
	
	
}
