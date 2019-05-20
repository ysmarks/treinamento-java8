package introducaoNovasInterfaces.interfaces;
/**
 * 
 * @author ysantos
 * As principais mudanças a partir da versão 8 do java
 * são introdução a metodos estaticos e concretos.
 * O uso dos metodos concretos se dá atraves da palavra reservada DEFAULT
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
