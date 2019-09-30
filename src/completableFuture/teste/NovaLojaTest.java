package completableFuture.teste;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import completableFuture.classe.Desconto;
import completableFuture.classe.NovaLoja;
import completableFuture.classe.Orcamento;

/**
 * Encadeamento de tarefas
 * 
 * @author ysantos
 *
 */
public class NovaLojaTest {

	public static void main(String[] args) {
		List<NovaLoja> lojas = NovaLoja.lojas();
		// lojas.stream().forEach(lojas1 -> System.out.println(lojas1.getPreco()));
		acharPrecos(lojas);

		Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});
		acharPrecosAsync(lojas, executor);
	}

	private static List<String> acharPrecos(List<NovaLoja> lojas) {
		System.out.println("Stream sequencial");
		long start = System.currentTimeMillis();

		List<String> collect = lojas.stream().map(NovaLoja::getPreco).map(Orcamento::parse)
				.map(Desconto::calculaDesconto).collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);

		return collect;
	}

	private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
		System.out.println("Completable future async");
		long start = System.currentTimeMillis();

		List<CompletableFuture<String>> completableFuture = lojas.stream()
				//Pegando o preço original de forma async
				.map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
				//Transforma a string em um orçamento no momento em que ela se torna disponivel
				.map(future -> future.thenApply(Orcamento::parse))
				//Compoem o primeiro future com mais uma chamada async, para pegar os descontos
				//no momento que a primeira requisição async estiver disponivel
				.map(future -> future.thenCompose(orcamento -> CompletableFuture
						.supplyAsync(() -> Desconto.calculaDesconto(orcamento), executor)))
				.collect(Collectors.toList());
		//Espera todos os futures no stream finalizarem para terem seus resultados extraidos
		List<String> collect = completableFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());

		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);

		return collect;
	}
}
