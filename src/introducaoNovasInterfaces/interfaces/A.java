package introducaoNovasInterfaces.interfaces;

public interface A {
	
	default void dentro() {
		System.out.println("Dentro de A");
	}

}
