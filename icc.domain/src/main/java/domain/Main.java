package domain;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Componente s1 = new ComponenteCompuesto(new Sistema(11, "s1", 1, 1, 1, 1, 1));
		
		Componente b1 = new ComponenteCompuesto(new Barra(21, "b1", 2, 2));
		s1.cargarHijo(b1);
		
		Componente t1 = new ComponenteCompuesto (new Trafo(31, "t1", 1, 1, 1));
		b1.cargarHijo(t1);
		
		Componente b2 = new ComponenteCompuesto(new Barra(41, "b2", 2, 2));
		t1.cargarHijo(b2);
		
		Componente t41 = new ComponenteCompuesto (new Trafo(51, "t41", 1, 1, 1));
		b2.cargarHijo(t41);
		
		Componente l41 = new ComponenteCompuesto (new Linea(52, "l41", 1, 1, 1,1,1));
		b2.cargarHijo(l41);
		
		Componente t42 = new ComponenteCompuesto (new Trafo(53, "t42", 1, 1, 1));
		b2.cargarHijo(t42);
		
		Componente bt411 = new ComponenteCompuesto(new Barra (61, "bt411", 2, 2));
		t41.cargarHijo(bt411);
		
		Componente bl411 = new ComponenteCompuesto(new Barra (62, "bl411", 2, 2));
		l41.cargarHijo(bl411);
		
		Componente bt412 = new ComponenteCompuesto(new Barra (63, "bt412", 2, 2));
		t42.cargarHijo(bt412);
		
		Componente m1 = new ComponenteHoja(new Motor(71, "m1", 2,2,2,2));
		bl411.cargarHijo(m1);
		
		Componente m2 = new ComponenteHoja(new Motor(72, "m2", 2,2,2,2));
		bl411.cargarHijo(m2);
		
		
		s1.mostrarArbol();

	}

}
