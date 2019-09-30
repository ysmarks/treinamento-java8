package completableFuture.teste;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import completableFuture.classe.Loja;

public class Loja2Test {

	public static void main(String[] args) {
		List<Loja> lojas = Arrays.asList(
				new Loja("Americanas"), 
				new Loja("Casas Bahia"), 
				new Loja("Lojas Cem"),
				new Loja("Americanas"), 
				new Loja("Casas Bahia"), 
				new Loja("Lojas Cem"),
				new Loja("Americanas"), 
				new Loja("Casas Bahia"), 
				new Loja("Lojas Cem"),
				new Loja("Americanas"), 
				new Loja("Casas Bahia"), 
				new Loja("Lojas Cem"),
				new Loja("Americanas"), 
				new Loja("Casas Bahia"), 
				new Loja("Lojas Cem"),
				new Loja("Ricardo Eletro"));
		//acharPrecosSequencial(lojas);
		acharPrecosParalelo(lojas);
		//acharPrecosCompletableFutureSequencial(lojas);
		acharPrecosCompletableFuture(lojas);
		
		//Calcular o numero de threads
		//Numero de Thread = Ncpu * Ucpu * (1+W/C)
		//Ncpu = numero de cores disponivel
		System.out.println(Runtime.getRuntime().availableProcessors());
		//Ucpu = quantidade de utilização da CPU (0-1)
		//W/C = wait time e compute time
		
		Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});
		
		acharPrecosCompletableFuture(lojas, executor);

	}

	private static List<String> acharPrecosSequencial(List<Loja> lojas) {
		System.out.println("Stream sequencial");
		Long inicio = System.currentTimeMillis();
		List<String> collect = lojas.stream().map(loja -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println(collect);
		return collect;
		
	}
	private static List<String> acharPrecosParalelo(List<Loja> lojas) {
		System.out.println("Stream pararelo");
		Long inicio = System.currentTimeMillis();
		List<String> collect = lojas.parallelStream().map(loja -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println(collect);
		return collect;
		
	}
	private static List<String> acharPrecosCompletableFutureSequencial(List<Loja> lojas) {
		System.out.println("Completable Future sequencial");
		Long inicio = System.currentTimeMillis();
		
		List<String> collect = lojas.stream().map(loja -> CompletableFuture.supplyAsync(
				() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco())))
		.map(CompletableFuture::join)
		.collect(Collectors.toList());
	
		System.out.println("Tempo total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println(collect);
		return collect;
		
	}
	private static List<String> acharPrecosCompletableFuture(List<Loja> lojas) {
		System.out.println("Completable Future");
		Long inicio = System.currentTimeMillis();
		
		 List<CompletableFuture<String>> lista = lojas.stream().map(loja -> CompletableFuture.supplyAsync(
				() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco())))
		.collect(Collectors.toList());
		 
		 System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - inicio) + " ms");
		 List<String> collect = lista.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		System.out.println("Tempo total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println(collect);
		return collect;
		
	}
	private static List<String> acharPrecosCompletableFuture(List<Loja> lojas, Executor executor) {
		System.out.println("Completable Future com executor");
		Long inicio = System.currentTimeMillis();
		
		 List<CompletableFuture<String>> lista = lojas.stream().map(loja -> CompletableFuture.supplyAsync(
				() -> String.format("%s o preco eh: %.2f", loja.getNome(), loja.getPreco()), executor))
		.collect(Collectors.toList());
		 
		 System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - inicio) + " ms");
		 List<String> collect = lista.stream().map(CompletableFuture::join).collect(Collectors.toList());
		
		System.out.println("Tempo total: " + (System.currentTimeMillis() - inicio) + " ms");
		System.out.println(collect);
		return collect;
		
	}
	
}
