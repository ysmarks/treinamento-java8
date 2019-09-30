package completableFuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {

	private String nome;
	
	
	public Loja(String nome) {
		this.nome = nome;
	}
	
	public Loja() {

	}

	// metodo sincrono
	public double getPreco() {
		return calculaPreco();
	}

	// Metodo assincrono verboso
	public Future<Double> getPrecoAsync() {
		CompletableFuture<Double> completableFuture = new CompletableFuture<>();
		new Thread(() -> {
			try {
			completableFuture.complete(calculaPreco());
			} catch(Exception e) {
				completableFuture.completeExceptionally(e);
			}
		}).start();
		return completableFuture;
	}
	
	//Metodo assicrono com supplyAsync
	public Future<Double> getPrecoAsyncTunado() {
		return CompletableFuture.supplyAsync(this::calculaPreco);
	}

	private double calculaPreco() {
		delay();
		//System.out.println(1 / 0);
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
	
	
}
