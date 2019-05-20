package comportamentoPorParamentro.interfaces;

import comportamentoPorParamentro.classe.Carro;

@FunctionalInterface
public interface CarroStrategy {

	boolean teste(Carro carro);
}
