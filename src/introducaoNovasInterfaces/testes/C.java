package introducaoNovasInterfaces.testes;

import introducaoNovasInterfaces.interfaces.A;
import introducaoNovasInterfaces.interfaces.B;
/**
 * 
 * @author ysantos
 *Nesse caso mesmo C implementando as interfaces B e A, ela executar� o metodo
 *mais relevante, ou seja o que estiver mais proximo. Com a interface B extends de A
 *o metode de B ser� executado
 */
public class C extends D implements A, B{

	public static void main(String[] args) {
		new C().dentro();
	}
	
}
