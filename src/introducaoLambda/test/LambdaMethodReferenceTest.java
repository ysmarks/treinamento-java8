package introducaoLambda.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import introducaoLambda.classes.Carro;
import introducaoLambda.classes.ComparadorCarro;

public class LambdaMethodReferenceTest {

	public static void main(String[] args) {
		//Forma de utilizar method reference
		//forEach(Arrays.asList("Teste1", "Teste2", "Teste3"), System.out::println);
		
		List<Carro>  carros = Arrays.asList(
				new Carro("Monza", "Azul", 1999),
				new Carro("Polo", "Branco", 2001),
				new Carro("Gol", "Prta", 2003),
				new Carro("HB20", "Preto", 2018),
				new Carro("Scort", "Azul", 1995));
		//To reference method static
		Collections.sort(carros, ComparadorCarro::compararPorCor);
		//System.out.println(carros);
		
		//Reference to an instance method of a particular object
		ComparadorCarro comparadorCarro = new ComparadorCarro();
		Collections.sort(carros, comparadorCarro::compararPorAno);
		//System.out.println(carros);
		
		//Reference to an instance method of an arbitrary object of a particular type
		List<String> nomes = Arrays.asList("vovo1", "leite", "Didi");
		//nomes.sort(String::compareTo);
		//nomes.sort((s1, s2) -> s1.compareTo(s2));
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
		//System.out.println(nomes);
		//System.out.println(stringToInteger2.apply("8"));
		
		//Reference to a constructor
		String nome = "Voyage";
		BiFunction<String, Integer, Carro> carroBiFunctional = (s, i) -> new Carro(nome, s, i);
		BiFunction<String, Integer, Carro> carroBiFunctional2 = Carro::new;
		System.out.println(carroBiFunctional.apply("Azul", 2019));
		System.out.println(carroBiFunctional2.apply("Verde", 2019));
	}
	private static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}
}
