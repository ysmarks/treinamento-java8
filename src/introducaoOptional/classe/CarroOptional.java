package introducaoOptional.classe;

import java.util.Optional;

public class CarroOptional {

	private Optional<SeguradoraOptional> seguradoraOptional;
	private String nome;
	
	public CarroOptional(Optional<SeguradoraOptional> seguradoraOptional, String nome) {
		super();
		this.seguradoraOptional = seguradoraOptional;
		this.nome = nome;
	}
	
	public CarroOptional() {}

	public Optional<SeguradoraOptional> getSeguradoraOptional() {
		return seguradoraOptional;
	}

	public void setSeguradoraOptional(Optional<SeguradoraOptional> seguradoraOptional) {
		this.seguradoraOptional = seguradoraOptional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
