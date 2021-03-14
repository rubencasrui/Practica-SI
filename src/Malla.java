import java.util.Random;
import java.util.StringJoiner;

public class Malla {
	
	private boolean[][] tablero;
	private int numFilas;
	private int numColumnas;
	private long semilla; //sin usar
	private Random generador;
	private Coordenada inicio;
	private Coordenada fin;
	
	
	public Malla(int f, int c, long s, int num){
		numFilas = f;
		numColumnas = c;
		semilla = s;
		tablero = new boolean[f][c];
		generador = new Random(semilla);
		rellenarMatriz(num, generador, tablero);
		inicio = new Coordenada(this, generador);
		fin = new Coordenada(this, generador);
	}

	private void rellenarMatriz(int num, Random generador, boolean[][] tablero){
		//Generamos obstáculos
		while(num > 0){
			int x = generador.nextInt(numFilas);
			int y = generador.nextInt(numColumnas);
			//insertar obstáculo
			if(!tablero[x][y]){
				tablero[x][y] = true;
				num--;
			}
		}
	}

	public void ver(){
		System.out.println(this.toString());
	}

	@Override
	public String toString(){
		StringJoiner result = new StringJoiner("\n");//Fila
		for (int i = 0; i < numFilas; i++) {		
			StringJoiner fila = new StringJoiner("");
			for (int j = 0; j < numColumnas; j++) {
				if(tablero[i][j])
					fila.add("[#]");
				else if (inicio.getX() == i && inicio.getY() == j)
					fila.add("[I]");
				else if (fin.getX() == i && fin.getY() ==j)
					fila.add("[F]");
				else
					fila.add("[ ]");
			}
			
			result.add(fila.toString());
		}
		return result.toString();
	}

	public boolean[][] getTablero() {
		return tablero;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public int getNumColumnas() {
		return numColumnas;
	}

	public long getSemilla() {
		return semilla;
	}

	public Coordenada getInicio() {
		return inicio;
	}

	public Coordenada getFin() {
		return fin;
	}
	
}
