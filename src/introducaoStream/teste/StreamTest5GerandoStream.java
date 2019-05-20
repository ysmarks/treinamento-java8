package introducaoStream.teste;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GerandoStream {

	public static void main(String[] args) {
		
		//usando IntStream
		IntStream.rangeClosed(1, 40).filter(p -> p % 2 == 0).forEach(s -> System.out.print(s + " "));
		System.out.println();
		// usando range
		IntStream.range(1, 40).filter(p -> p % 2 == 0).forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		Stream<String> nomes = Stream.of("ysmarks", "kelly", "david");
		nomes.map(String::toUpperCase).forEach(s -> System.out.println(s + " "));
		
		int nums[] = {1,2,3,4};
		OptionalDouble average = Arrays.stream(nums).average();
		System.out.println(average);
		
		//usando o metodo iterate
		Stream.iterate(1, n -> n + 2).limit(5).forEach(s -> System.out.println(s + " "));
		
		//usando o generate
		Stream.generate(Math::random).limit(4).forEach(System.out::println);
		
		//usando generate
		ThreadLocalRandom localRandom = ThreadLocalRandom.current();
		Stream.generate(() -> localRandom.nextInt(1, 10)).limit(10).forEach(System.out::println);
		
		
	}
}
