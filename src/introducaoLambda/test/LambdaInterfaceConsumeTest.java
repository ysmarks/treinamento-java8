package introducaoLambda.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//Usando a interface funcional Consumer
public class LambdaInterfaceConsumeTest {

	public static void main(String[] args) {
		consumer(Arrays.asList("Ysmarks", "Kelly", "David"), (String names) -> System.out.println(names));
		
	}
	
	private static <T> void consumer(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}
}
