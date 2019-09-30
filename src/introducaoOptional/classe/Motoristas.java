package introducaoOptional.classe;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://blog.algaworks.com/chega-de-nullpointerexception/
 * @author ysantos
 *
 */

public class Motoristas {

	private Map<String, Optional<Motorista>> motoristas = new HashMap<>();

	public Motoristas() {
		Seguro seguro = new Seguro("com seguro", new BigDecimal("4000"));
		Seguro seguro1 = new Seguro("Sem seguro", new BigDecimal("2000"));
		
		Caminhao caminhao = new Caminhao("volvo", Optional.ofNullable(seguro));
		Caminhao caminhao2 = new Caminhao("Ford", Optional.ofNullable(seguro1));
		
		Optional<Motorista> motorista = Optional.ofNullable(new Motorista("Romario", 53, Optional.ofNullable(caminhao)));
		Optional<Motorista> motorista2 =  Optional.ofNullable(new Motorista("Bebeto", 55, Optional.ofNullable(caminhao)));
		Optional<Motorista> motorista3 = Optional.ofNullable(new Motorista("ysmarks", 32, Optional.ofNullable(caminhao2)));
		
		motoristas.put("Romario", motorista);
		motoristas.put("Bebeto", motorista2);
		motoristas.put("tigre", motorista3);
	}
	
	public Optional<Motorista> porNome(String nome) {
		return motoristas.get(nome);
	}
	
}
