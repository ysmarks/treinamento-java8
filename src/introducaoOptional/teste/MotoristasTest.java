package introducaoOptional.teste;

import introducaoOptional.classe.Caminhao;
import introducaoOptional.classe.Motorista;
import introducaoOptional.classe.Motoristas;
import introducaoOptional.classe.Seguro;

public class MotoristasTest {

	public static void main(String[] args) {
		/*
		 * Motoristas motoristas = new Motoristas(); 
		 * Motorista motorista =
		 * motoristas.porNome("Romario"); String cobertura =
		 * motorista.getCaminhao().getSeguro().getCobertura(); cobertura = cobertura !=
		 * null? cobertura: "sem seguro"; System.out.println(cobertura);
		 */
		
		/*
		 * Motoristas motoristas = new Motoristas(); Motorista motorista =
		 * motoristas.porNome("Bebeto"); if(motorista != null) { Caminhao caminhao =
		 * motorista.getCaminhao(); if(caminhao != null) { Seguro seguro =
		 * caminhao.getSeguro(); if(seguro != null)
		 * System.out.println(seguro.getCobertura()); } }
		 */
		Motoristas motoristas = new Motoristas();
		String cobertura = motoristas.porNome("tigre")
				.flatMap(Motorista::getCaminhao)
				.flatMap(Caminhao::getSeguro)
				.map(Seguro::getCobertura)
				.orElse("Sem seguro");
		System.out.println(cobertura);
		
	}
}
