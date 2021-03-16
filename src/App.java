public class App {
	private static final String SEP  = "--------------------------------------------";
	public static void main(String[] args) throws Exception {
		System.out.println("App Malla.");
		
		for (int s = 1 ; s <= 5; s++)
		{
			Malla malla1 = new Malla(5, 5, s, 8);
			Malla malla2 = new Malla(3, 6, s, 8);
			Malla malla3 = new Malla(5, 8, s, 8);
			Malla malla4 = new Malla(4, 7, s, 8);
			System.out.println("Inicio de la Prueba número "+s+" +++++++++++++++++++++++++++");
			malla1.ver();
				System.out.println(malla1.getInicio().distancia(malla1.getFin()));
				System.out.println(SEP);
			malla2.ver();
				System.out.println(malla2.getInicio().distancia(malla2.getFin()));
				System.out.println(SEP);
			malla3.ver();
				System.out.println(malla3.getInicio().distancia(malla3.getFin()));
				System.out.println(SEP);
			malla4.ver();
				System.out.println(malla4.getInicio().distancia(malla4.getFin()));
			
			System.out.println("Fin de la Prueba número "+s+" ++++++++++++++++++++++++++++++");
			System.out.println();
		}

		
		Malla malla1 = new Malla(5, 5, 0, 8);
		System.out.println(malla1.hashCode());
		Malla malla2 = new Malla(5, 5, 0, 8);
		System.out.println(malla2.hashCode());
		Malla malla3 = new Malla(5, 5, 1, 8);
		System.out.println(malla3.hashCode());

		System.out.println("Prueba malla 1 - 2:");
		System.out.println(malla1.equals(malla2));
		System.out.println("Prueba malla 2 - 3:");
		System.out.println(malla2.equals(malla3));

	}
}
