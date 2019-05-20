package introducaoStream.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest2 {

	public static void main(String[] args) {
		//bloco 1
		List<List<String>> nomes = new ArrayList<>();
		nomes.add(Arrays.asList("teste1", "teste2"));
		nomes.add(Arrays.asList("teste3", "teste4"));
		List<String> n = nomes
				.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(n);
		
		//bloco 2
		List<String> palavras = Arrays.asList("teste1", "teste2", "teste3", "teste4");
		String[] split = palavras.get(0).split("");
		System.out.println(Arrays.toString(split));
		
		//bloco 3
		List<String> t = palavras
				.stream()
				.map(p -> p.split(""))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());
		System.out.println(t);
	}
}
