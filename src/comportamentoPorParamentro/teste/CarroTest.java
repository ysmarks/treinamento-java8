package comportamentoPorParamentro.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import comportamentoPorParamentro.classe.Carro;
import comportamentoPorParamentro.interfaces.CarroStrategy;

public class CarroTest {

//metodo estatico para filtrar por cor usando java 1.7
private static List<Carro> filtraPorcor(List<Carro> carros, String cor) {
	List<Carro> result = new ArrayList<>();
	for (Carro carro : carros) {
		if(carro.getCor().equals(cor))
			result.add(carro);
	}
	return result;
}

private static List<Carro> filtrarCarroDezAnosFabricado(List<Carro> carros) {
	List<Carro> resultado = new ArrayList<>();
	for(Carro carro : carros) {
		if (carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 10) {
			resultado.add(carro);
		}
	}
	return resultado;
}

public static List<Carro> filtrarCarros(List<Carro> carros, CarroStrategy carroStrategy) {
	List<Carro> resultado = new ArrayList<>();
	for (Carro carro : carros) {
		if(carroStrategy.teste(carro)) {
			resultado.add(carro);
		}
	}
	return resultado;
} 
//usando metodo generico
public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate) {
	List<T> result = new ArrayList<>();
	for (T t : list) {
		if(predicate.test(t)) {
		result.add(t);
		}
	}
	return result;
}
	public static void main(String[] args) {
		List<Carro> carros = Arrays.asList(
				new Carro("Gol", "rosa", 2019),
				new Carro("Palio", "preto", 200), 
				new Carro("Gol", "amarelo", 2015),
				new Carro("ka", "rosa", 2010),
				new Carro("Santa fe", "azul", 2005));
		/*
		 * System.out.println(filtrarCarros(carros, new CarroCorRosaStrategy()));
		 * System.out.println(filtrarCarros(carros, new CarroDezAnosRecenteStrategy()));
		 */
		System.out.println(filtrar(carros, new Predicate<Carro>() {

			@Override
			public boolean test(Carro t) {
				// TODO Auto-generated method stub
				return t.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 10;
			}
		}));
		/*
		 * System.out.println(filtraPorcor(carros, "rosa"));
		 * System.out.println(filtrarCarroDezAnosFabricado(carros));
		 */
		System.out.println(Calendar.getInstance().get(Calendar.YEAR) + " " + Calendar.getInstance().get(Calendar.MONTH) + " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}
}
