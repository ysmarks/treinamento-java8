package introducaoOptional.classe;

import java.util.Optional;

public class PessoaOptional {

	private Optional<CarroOptional> carroOptional;
	private String nome;

	public PessoaOptional(Optional<CarroOptional> carroOptional, String nome) {
		super();
		this.carroOptional = carroOptional;
		this.nome = nome;
	}

	public PessoaOptional() {

	}

	public Optional<CarroOptional> getCarroOptional() {
		return carroOptional;
	}

	public void setCarroOptional(Optional<CarroOptional> carroOptional) {
		this.carroOptional = carroOptional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
