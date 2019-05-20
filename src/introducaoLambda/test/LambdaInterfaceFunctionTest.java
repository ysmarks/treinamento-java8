package introducaoLambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/**
 * 
 * @author ysantos
 * Exemplo de uso da interface Functional
 *
 */
public class LambdaInterfaceFunctionTest {

	public static void main(String[] args) {
		List<Integer> integers = testeInterfaceFunction(Arrays.asList("Romario", "Bebeto", "Rai", "Dunga"), (String nome) -> nome.length());
		System.out.println(integers);
	}
	public static <T, R> List<R> testeInterfaceFunction(List<T> list, Function<T, R> function) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(function.apply(t));
		}
		return result;
	}
}
