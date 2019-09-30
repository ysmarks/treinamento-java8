package completableFuture.classe;

import java.util.concurrent.TimeUnit;

public class Desconto {

	public enum Codigo {
		NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);

		private final int porcentagem;

		private Codigo(int porcentagem) {
			this.porcentagem = porcentagem;
		}

		public int getPorcentagem() {
			return porcentagem;
		}

	}

	public static String calculaDesconto(Orcamento orcamento) {

		return String.format("%s o preco original: %.2f, desconto: %d," + " preco final: %.2f",
				orcamento.getNomeLoja(),
				orcamento.getPreco(),
				orcamento.getCodigoDesconto().getPorcentagem(),
				calculo(orcamento.getPreco(), orcamento.getCodigoDesconto()));
	}

	private static double calculo(double preco, Codigo codigo) {
		delay();
		return preco * (100 - codigo.porcentagem) / 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
