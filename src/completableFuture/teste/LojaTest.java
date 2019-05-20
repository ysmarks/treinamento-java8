package completableFuture.teste;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import completableFuture.classe.Loja;

public class LojaTest {

	public static void main(String[] args) {
		
		Loja americanas = new Loja();
		Loja sem = new Loja();
		Loja riachuelo = new Loja();
		Loja havan = new Loja();
		long inicio = System.currentTimeMillis();
		/*
		 * System.out.println(americanas.getPreco());
		 * System.out.println(sem.getPreco()); System.out.println(riachuelo.getPreco());
		 * System.out.println(havan.getPreco());
		 * System.out.println(System.currentTimeMillis() - inicio + " ms");
		 */
		Future<Double> precoAsync = americanas.getPrecoAsync();
		Future<Double> precoAsync1 = sem.getPrecoAsync();
		Future<Double> precoAsync2 = riachuelo.getPrecoAsync();
		Future<Double> precoAsync3 = havan.getPrecoAsync();
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de invocação " + (fim - inicio) + " ms");
		executando();
		try {
			System.out.println(precoAsync.get());
			System.out.println(precoAsync1.get());
			System.out.println(precoAsync2.get());
			System.out.println(precoAsync3.get());
			System.out.println(System.currentTimeMillis() - inicio + " ms");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private static void executando() {
		long soma = 0;
		for (int i = 0; i < 1_000_000; i++) {
			soma += i;
		}
		System.out.println("Soma: " + soma);
	}
}
