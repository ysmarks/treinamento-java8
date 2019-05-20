package introducaoNovasInterfaces.testes;

import introducaoNovasInterfaces.interfaces.NovasRegras;

public class InterfaceTest implements NovasRegras {

	public static void main(String[] args) {
		NovasRegras.metodoStatico();
		new InterfaceTest().metodoConcreto();
		
	}
	
}
