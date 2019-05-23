package introducaoOptional.classe;

import java.util.Optional;

public class Caminhao {

	private String nome;
	private Optional<Seguro> seguro;
	
	public Caminhao(String nome, Optional<Seguro> seguro) {
		super();
		this.nome = nome;
		this.seguro = seguro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Optional<Seguro> getSeguro() {
		return seguro;
	}
	public void setSeguro(Optional<Seguro> seguro) {
		this.seguro = seguro;
	}
	
	
}
