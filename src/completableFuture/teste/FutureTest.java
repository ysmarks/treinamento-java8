package completableFuture.teste;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author ysantos
 * Introdução programação Sincronar e assincronar
 */
public class FutureTest {
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) {
		
		Future<Double> future = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(2);
			return 2000D;
		});
		executando();
		
		try {
			Double double1 = future.get();
			System.out.println(double1);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private static void executando() {
		long soma = 0;
		for (int i = 0; i < 1_000_000; i++) {
			soma += i;
		}
		System.out.println(soma);
	}

}
