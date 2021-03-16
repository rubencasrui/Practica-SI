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
		Coordenada coorAleatoria = new Coordenada();
		do{
			coorAleatoria.setX(generador.nextInt(malla.getNumFilas()));
			coorAleatoria.setY(generador.nextInt(malla.getNumColumnas()));
		}while (!coorAleatoria.esValido(malla.getTablero()));
		this.x = coorAleatoria.getX();
		this.y = coorAleatoria.getY();
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
		return Math.abs(this.x - b.getX()) + Math.abs(this.y - b.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
	
	
}
