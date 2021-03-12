import java.util.Random;
import java.util.StringJoiner;

public class Malla {
	
	private boolean[][] obstaculos;
	private int numFilas;
	private int numColumnas;
	private long semilla; //sin usar
	private Random generador;
	private Coordenada inicio;
	private Coordenada fin;
	
	private class Coordenada{
		protected int x;
		protected int y;
		
		protected Coordenada(int x, int y){//==> Actualizar
			this.x = x;
			this.y = y;
		}

		protected boolean esValido()
		{
			return (!obstaculos[this.x][this.y]);
		}
	}
	
	public Malla(int f, int c, long s, int num){
		numFilas = f;
		numColumnas = c;
		semilla = s;
		obstaculos = new boolean[f][c];
		generador = new Random(semilla);
		rellenarMatriz(num, generador, obstaculos);
	}

	private void rellenarMatriz(int num, Random generador, boolean[][] obstaculos){
		//Generamos obstáculos
		while(num > 0){
			int x = generador.nextInt(numFilas);
			int y = generador.nextInt(numColumnas);
			//insertar obstáculo
			if(!obstaculos[x][y]){
				obstaculos[x][y] = true;
				num--;
			}
		}
		//Generamos estado inicio y fin
		Coordenada inicio = new Coordenada(-1, -1);
		do{
			//Actualizar;
			inicio.x = generador.nextInt(numFilas);
			inicio.y = generador.nextInt(numColumnas);
		}while (!inicio.esValido());

		Coordenada fin = new Coordenada(-1, -1);
		do{
			//Actualizar;
			fin.x = generador.nextInt(numFilas);
			fin.y = generador.nextInt(numColumnas);
		}while(!fin.esValido());

		this.inicio = inicio;
		this.fin = fin;
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
				if(obstaculos[i][j])
					fila.add("[#]");
				else if (inicio.x == i && inicio.y == j)
					fila.add("[I]");
				else if (fin.x == i && fin.y ==j)
					fila.add("[F]");
				else
					fila.add("[ ]");
			}
			
			result.add(fila.toString());
		}
		return result.toString();
	}

	public boolean[][] getObstaculos() {
		return obstaculos;
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
