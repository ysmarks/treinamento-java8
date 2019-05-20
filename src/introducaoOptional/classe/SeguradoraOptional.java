package introducaoOptional.classe;

import java.util.Optional;

public class SeguradoraOptional {

	private Optional<String> nome;

	public SeguradoraOptional(Optional<String> nome) {
		super();
		this.nome = nome;
	}

	public SeguradoraOptional() {
		super();

	}

	public Optional<String> getNome() {
		return nome;
	}

	public void setNome(Optional<String> nome) {
		this.nome = nome;
	}

}
