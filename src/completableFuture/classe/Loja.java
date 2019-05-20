package completableFuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {

	//metodo sincrono
	public double getPreco() {
		return calculaPreco();
	}
	//Metodo assincrono
	public Future<Double> getPrecoAsync() {
		CompletableFuture<Double> completableFuture = new CompletableFuture<>();
		new Thread(() -> {
			completableFuture.complete(calculaPreco());
		}).start();
		return completableFuture;
	}

	private double calculaPreco() {
		delay();
		return ThreadLocalRandom.current().nextDouble() * 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
