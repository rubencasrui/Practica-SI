import java.util.Random;

public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada(){//==> Actualizar
		this.x = 0;
		this.y = 0;
	}
	
	public Coordenada(int x, int y){//==> Actualizar
		this.x = x;
		this.y = y;
	}
	
	public Coordenada(Malla malla, Random generador){
		Coordenada inicio = new Coordenada();
		do{
			inicio.setX(generador.nextInt(malla.getNumFilas()));
			inicio.setY(generador.nextInt(malla.getNumColumnas()));
		}while (!inicio.esValido(malla.getTablero()));
	}

	public int getX(){
		return x;
	}
    
    public void setX(int x){
        this.x = x;
    }

	public int getY(){
		return y;
	}

    public void setY(int y){
        this.y = y;
    }

    //PRE-CONDICION: la coordenada está siempre en rango
	public boolean esValido(boolean[][] tablero){
		return !tablero[x][y];
	}

	public int distancia(Coordenada b){
		return Math.abs(this.x - b.getX()) + Math.abs(this.x - b.getY());
	}
	
}
