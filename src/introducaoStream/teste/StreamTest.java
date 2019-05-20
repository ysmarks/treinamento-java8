package introducaoStream.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import introducaoStream.classes.Pessoa;
//Pega os tres primeiros nomes das pessoas com menos de 25 anos
//Ordenar pelo nome
public class StreamTest {

	public static void main(String[] args) {
		
		//Resolvendo com java 7
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		//Collections.sort(pessoas, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		List<String> lista = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() < 25) {
				lista.add(pessoa.getNome());
				if(lista.size() >= 3) 
					break;
			}
		}
		System.out.println(lista);
		
		//Resolvendo com java 8
		List<String> nome = pessoas
				.stream()
				.filter(p -> p.getIdade() < 25)
				//.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());//Metodo terminate
		
		System.out.println(nome);
		
		System.out.println(pessoas
				.stream()
				.distinct()
				.filter(p -> p.getIdade() < 25)
				.map(Pessoa::getNome)
				.count());//Metodo terminate
		
	}
}
