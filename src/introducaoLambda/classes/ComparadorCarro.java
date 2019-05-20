package introducaoLambda.classes;

public class ComparadorCarro {

	public static int compararPorCor(Carro c1, Carro c2) {
		return c1.getCor().compareTo(c2.getCor());
	}
	public int compararPorAno(Carro c1, Carro c2) {
		return ((Integer)c1.getAno()).compareTo(c2.getAno());
	}
}
