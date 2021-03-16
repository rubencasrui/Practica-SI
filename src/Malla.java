import java.util.Arrays;
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
				else if (fin.getX() == i && fin.getY() == j)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + numColumnas;
		result = prime * result + numFilas;
		result = prime * result + (int) (semilla ^ (semilla >>> 32));
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Malla other = (Malla) obj;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (numColumnas != other.numColumnas)
			return false;
		if (numFilas != other.numFilas)
			return false;
		if (semilla != other.semilla)
			return false;
		if (!Arrays.deepEquals(tablero, other.tablero))
			return false;
		return true;
	}

	
	
}
