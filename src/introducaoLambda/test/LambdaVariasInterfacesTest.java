package introducaoLambda.test;

import java.util.function.IntPredicate;

public class LambdaVariasInterfacesTest {

	public static void main(String[] args) {
		
		//interface IntePredicate
		IntPredicate pares =  i -> i % 2 == 0;
		System.out.println(pares.test(30));
		
		
		
	}
}
