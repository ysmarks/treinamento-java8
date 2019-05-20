package comportamentoPorParamentro.strategy;

import java.util.Calendar;

import comportamentoPorParamentro.classe.Carro;
import comportamentoPorParamentro.interfaces.CarroStrategy;

public class CarroDezAnosRecenteStrategy implements CarroStrategy {

	@Override
	public boolean teste(Carro carro) {
		
		return carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 10;
	}

}
