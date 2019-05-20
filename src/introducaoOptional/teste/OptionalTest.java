package introducaoOptional.teste;

import java.util.Optional;

/**
 * 
 * @author ysantos
 * Introducao a classe Optional para tratar nulos
 *
 */
public class OptionalTest {

	private String nome;
	
	public static void main(String[] args) {
		
		OptionalTest test = new OptionalTest();
		
		//forma de checa se uma variavel é nula ou não até o java 7
		/*
		 * if(test.nome != null) System.out.println(test.nome);
		 */
		
		//Forma de checar se uma variavel ou objeto e nulo no java 8 com a classe Optional
		//primeira usando Optional.of quando tenho certeza que a variavel não é nula
		Optional<String> valor1 = Optional.of("vazio");
		Optional<String> valor2 = Optional.empty();
		Optional<String> valor3 = Optional.ofNullable(test.nome);
		
		//imprimir valores
		//System.out.println(valor1);
		System.out.println(valor1);
		System.out.println(valor2);
		System.out.println(valor3);
		
		//Buscando valores
		System.out.println(valor1.get());
		System.out.println(valor3.orElse("o numero é nulo"));
		
		
	}
}
