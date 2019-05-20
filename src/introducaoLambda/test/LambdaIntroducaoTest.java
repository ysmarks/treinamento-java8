package introducaoLambda.test;


import introducaoLambda.classes.Carro;
import introducaoLambda.interfaces.CarroStrategy;

public class LambdaIntroducaoTest {

	// O que � lambda:
	// � anonima
	// � uma fun��o
	// pode ser passada por ai
	// � concisa, consegue resolver as coisas em uma linha
	// como funciona?
	// Exemplo (Carro carro)"paramentdos" ->"seta" carro.getCor()."express�o ou corpo"
	// corpo"
	//onde existe um interface funcional pode ser substituida por lambda
	public static void main(String[] args) {

		//Exemplos
		
		//usando classe anonima
		CarroStrategy carroStrategy = new CarroStrategy() {
			
			@Override
			public boolean teste(Carro carro) {
				
				return carro.getCor().equals("azul");
			}
		};
		
		//Usando Lambda
		CarroStrategy strategy = (Carro carro) -> carro.getCor().equals("azul");
		Runnable runnable = () -> System.out.println("Dentro da interface runnable");
		runnable.run();
		new Thread(runnable).start();
		
		System.out.println(carroStrategy.teste(new Carro("gol", "azul", 2017)));
		System.out.println(strategy.teste(new Carro("gol", "azul", 2017)));
	}
}
