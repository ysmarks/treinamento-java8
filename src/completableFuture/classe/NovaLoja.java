package completableFuture.classe;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class NovaLoja {

	private String nome;
	
	
	public NovaLoja(String nome) {
		this.nome = nome;
	}
	
	public NovaLoja() {

	}

	// metodo sincrono
	//pegar o nome:preco:codigo
	public String getPreco() {
		double preco = calculaPreco();
		Desconto.Codigo codigo = Desconto.Codigo.values()[ThreadLocalRandom.current().nextInt(Desconto.Codigo.values().length)];
		return String.format("%s:%.2f:%s", nome, preco, codigo);
	}

	private double calculaPreco() {
		delay();
		return ThreadLocalRandom.current().nextDouble() * 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getNome() {
		return nome;
	}
	
	public static List<NovaLoja> lojas() {
		return Arrays.asList(
				new NovaLoja("Americanas"), 
				new NovaLoja("Casas Bahia"), 
				new NovaLoja("Lojas Cem"),
				new NovaLoja("Besni"), 
				new NovaLoja("Ricardo Eletrico"), 
				new NovaLoja("Marabraz"),
				new NovaLoja("Pernanbucanas"), 
				new NovaLoja("magazine Luiza"));
	}
	
	
}
