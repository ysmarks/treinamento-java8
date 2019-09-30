package streamparalelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamParalelosTest {

	
	public static void main(String[] args) {
		long num = 10_000_000_00;
		somaFor(num);
		
		somaStream(num);
		somaStreamParalelo(num);
		 
		somaRangeClosedStream(num);
		somaRangeClosedStreamParalelo(num);
	}
	
	private static void somaFor(long num) {
		System.out.println("for");
		long resultado = 0;
		long inicio = System.currentTimeMillis();
		for (long i = 1L; i <= num; i++) {
			resultado += i;	
		}
		long fim = System.currentTimeMillis();
		System.out.println(resultado + " " + (fim - inicio) + " ms");
	}
	
	private static void somaStream(long num) {
		System.out.println("stream sequencial");
		long resultado = 0;
		long inicio = System.currentTimeMillis();
		resultado = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println(resultado + " " + (fim - inicio) + " ms");
	}
	private static void somaStreamParalelo(long num) {
		System.out.println("stream paralelo");
		long resultado = 0;
		long inicio = System.currentTimeMillis();
		resultado = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println(resultado + " " + (fim - inicio) + " ms");
	}
	private static void somaRangeClosedStream(long num) {
		System.out.println("stream Range Closed Stream");
		long resultado = 0;
		long inicio = System.currentTimeMillis();
		resultado = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println(resultado + " " + (fim - inicio) + " ms");
	}
	
	private static void somaRangeClosedStreamParalelo(long num) {
		System.out.println("stream Range Closed Stream paralelo");
		long resultado = 0;
		long inicio = System.currentTimeMillis();
		resultado = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println(resultado + " " + (fim - inicio) + " ms");
	}
}
