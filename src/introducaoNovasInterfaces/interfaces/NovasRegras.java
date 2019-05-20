package introducaoNovasInterfaces.interfaces;
/**
 * 
 * @author ysantos
 * As principais mudan�as a partir da vers�o 8 do java
 * s�o introdu��o a metodos estaticos e concretos.
 * O uso dos metodos concretos se d� atraves da palavra reservada DEFAULT
 *
 */
public interface NovasRegras {

	//metodo estatico
	static void metodoStatico() {
		System.out.println("Dentro do metodo estatico na interface NovasRegras");
	}
	//metodo concreto
	default void metodoConcreto() {
		System.out.println("Dentro do metodo concreto na interface NovasRegras");
	}
}
