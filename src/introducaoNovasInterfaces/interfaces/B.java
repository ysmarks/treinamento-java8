package introducaoNovasInterfaces.interfaces;

public interface B extends A {

	default void dentro() {
		System.out.println("Dentro de B");
	}

}
