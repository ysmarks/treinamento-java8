package comportamentoPorParamentro.strategy;

import comportamentoPorParamentro.classe.Carro;
import comportamentoPorParamentro.interfaces.CarroStrategy;

public class CarroCorRosaStrategy implements CarroStrategy{

	@Override
	public boolean teste(Carro carro) {
		
		return carro.getCor().equals("rosa");
	}

}
