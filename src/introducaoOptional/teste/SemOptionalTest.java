package introducaoOptional.teste;

import java.util.Optional;

import introducaoOptional.classe.Carro;
import introducaoOptional.classe.CarroOptional;
import introducaoOptional.classe.Pessoa;
import introducaoOptional.classe.PessoaOptional;
import introducaoOptional.classe.Seguradora;
import introducaoOptional.classe.SeguradoraOptional;

public class SemOptionalTest {

	public static void main(String[] args) {
		Seguradora seguradora = new Seguradora("kelysm");
		Carro carro = new Carro(seguradora, "Voyage");
		Pessoa pessoa = new Pessoa(carro, "teste");
		obterNomeSeguradora1(pessoa);

	}

	private static String obterNomeSeguradora1(Pessoa pessoa) {

		if (pessoa != null) {
			Carro carro = pessoa.getCarro();
			if (carro != null) {
				Seguradora seguradora = carro.getSeguradora();
				if (seguradora != null)
					return seguradora.getNome();
			}

		}
		return "";
	}

	private static String obterNomeSeguradora2(Optional<Pessoa> pessoa) {

		/*
		 * return pessoa.flatMap(Pessoa::getCarro).flatMap(Carro::getSeguradora)
		 * .map(SeguradoraOptional::getNome).orElse("Não existe");
		 */
		return null;
	}

	private static void obterNomeSeguradoraOptional(SeguradoraOptional seguradora) {
		Optional<SeguradoraOptional> optional = Optional.ofNullable(seguradora);
		optional.filter(s -> s.getNome().equals("kelysm")).ifPresent(x -> System.out.println("Esta correto"));
	}
}
