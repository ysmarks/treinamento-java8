package introducaoStream.teste;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import introducaoStream.classes.Pessoa;

public class StreamTest4Reduce {

	public static void main(String[] args) {
		//Duas formas de descobrir o valor maximo
		Optional<Integer> max = getStream().reduce(Integer::max);
		System.out.println(max);
		
		//Forma de descobrir o valor minimo
		Optional<Integer> min = getStream().reduce(Integer::min);
		System.out.println(min);
		
		//primeira forma de somar com method reference
		Optional<Integer> somar = getStream().reduce(Integer::sum);
		System.out.println(somar);
		
		//segunda forma de somar com lambda
		Optional<Integer> soma2 = getStream().reduce((x, y) -> x + y);
		System.out.println(soma2);
		
		//exemplo mais real usando map
		Stream<Pessoa> pessoa = Pessoa.bancoDePessoas().stream();
		Optional<Double> reduce = pessoa.filter(p -> p.getSalario() > 400)
		.map(Pessoa::getSalario)
		.reduce(Double::sum);
		System.out.println(reduce);
		
		//mais um exemplo usando mapToDouble
		Stream<Pessoa> pessoa2 = Pessoa.bancoDePessoas().stream();
		double sum = pessoa2.filter(p -> p.getSalario() > 4000)
				.mapToDouble(Pessoa::getSalario)
				.sum();
		System.out.println(sum);
	}
	private static Stream<Integer> getStream() {
		return Arrays.asList(1,2,3,4,5,6,7,8,9).stream();
	}
}
