public class App {
	private static final String SEP  = "--------------------------------------------";
	public static void main(String[] args) throws Exception {
		System.out.println("App Malla.");

		Malla malla1 = new Malla(5, 5, 1, 4);
		Malla malla2 = new Malla(3, 6, 1, 4);
		Malla malla3 = new Malla(5, 5, 2, 4);
		Malla malla4 = new Malla(5, 5, 1, 4);

		malla1.ver();
		System.out.println(SEP);
		malla2.ver();
		System.out.println(SEP);
		malla3.ver();
		System.out.println(SEP);
		malla4.ver();
	}
}
