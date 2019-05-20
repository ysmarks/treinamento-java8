package introducaoStream.teste;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import introducaoStream.classes.Pessoa;

/**
 * @author ysantos
 * reduzinho e sumarizando stream
 *
 */
public class StreamTest6Collectors1 {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//metodo tradicional e collect
		System.out.println(pessoas.stream().count());
		pessoas.stream().collect(Collectors.counting());
		
		Optional<Pessoa> max = pessoas.stream().max(Comparator.comparing(Pessoa::getSalario));
		System.out.println(max.get().getSalario());
		//pegando o maximo
		Optional<Pessoa> collect = pessoas.stream().collect(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(collect.get().getSalario());
		//pegando o minimo
		Optional<Pessoa> collect2 = pessoas.stream().collect(Collectors.minBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(collect2.get().getSalario());
		
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());//somando o salario
		pessoas.stream().collect(Collectors.summingDouble(Pessoa::getSalario));
		
		//sumarizando tudo
		DoubleSummaryStatistics collect3 = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
		System.out.println(collect3);
		
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(",")));
	}
}
