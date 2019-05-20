package introducaoStream.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import introducaoStream.classes.Genero;
import introducaoStream.classes.Maioridade;
import introducaoStream.classes.Pessoa;

/**
 * 
 * @author ysantos Agrupamento de Stream
 *
 */
public class StreamTest6Collectors2 {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//Agrupamento por genero no java 7
		Map<Genero, List<Pessoa>> generoList = new HashMap<>();
		List<Pessoa> masculino = new ArrayList<>();
		List<Pessoa> feminino = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero().equals(Genero.FEMININO)) 
				feminino.add(pessoa);
			else 
				masculino.add(pessoa);	
		}
		generoList.put(Genero.FEMININO, feminino);
		generoList.put(Genero.MASCULINO, masculino);
		System.out.println(generoList);
		
		//Agrupamento por genero no java 8
		Map<Genero, List<Pessoa>> collect = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero));
		System.out.println(collect);
		
		//Agrupamento por maioridade
		Map<Maioridade, List<Pessoa>> collect2 = pessoas.stream().collect(Collectors.groupingBy(p -> {
			if(p.getIdade() < 18) return Maioridade.MENOR;
			else return Maioridade.ADULTO;
		}));
		System.out.println(collect2);
		//Agrupando por genero e maioridade
		Map<Genero, Map<Maioridade, List<Pessoa>>> collect3 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.groupingBy(p -> {
			if(p.getIdade() < 18) return Maioridade.MENOR;
			else return Maioridade.ADULTO;
		})));
		System.out.println(collect3);
		//Agrupando por genero e quantidade
		Map<Genero, Long> collect4 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()));
		System.out.println(collect4);
		//Agrupando por genero e maio salario
		Map<Genero, Optional<Pessoa>> collect5 = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
		System.out.println(collect5);
		//Agrupando por genero e maio salario e removendo o optional
		Map<Genero, Pessoa> collect6 = pessoas.stream()
		.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)), Optional::get)));
		System.out.println(collect6);
		//Agrupando por genero e estatisticas
		Map<Genero, DoubleSummaryStatistics> collect7 = pessoas.stream()
		.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.summarizingDouble(Pessoa::getSalario)));
		System.out.println(collect7);
		
		
	}

}
