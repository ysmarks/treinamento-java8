package completableFuture.classe;

import completableFuture.classe.Desconto.Codigo;

public class Orcamento {

	private final String nomeLoja;
	private final double preco;
	private final Desconto.Codigo codigoDesconto;
	
	private Orcamento(String nomeLoja, double preco, Codigo codigoDesconto) {
		this.nomeLoja = nomeLoja;
		this.preco = preco;
		this.codigoDesconto = codigoDesconto;
	}
	
	public static Orcamento parse(String s) {
		String[] split = s.split(":");
		String nomeLoja = split[0];
		double preco = Double.parseDouble(split[1]);
		Desconto.Codigo codigo = Desconto.Codigo.valueOf(split[2]);
		
		return new Orcamento(nomeLoja, preco, codigo);
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public double getPreco() {
		return preco;
	}

	public Desconto.Codigo getCodigoDesconto() {
		return codigoDesconto;
	}
	
	
	
	
}
