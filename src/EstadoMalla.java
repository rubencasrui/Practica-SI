import java.util.ArrayList;
import java.util.List;

/**
 * @author L.Mandow 
 * @date  2021-03-11
 * 
 * Plantilla para representar los estados de la pr�ctica
 *
 */
public class EstadoMalla implements Estado {
    private Malla mapa;
    private Coordenada posicionActual;
    private int g; //Coste desde salida - Estado actual
    private int h; //Coste para llegar dle actual al final

    
    public EstadoMalla(Malla malla, int x, int y)
    {
        mapa = malla;
        posicionActual = new Coordenada(x, y);
        g = 0;
        h = 0;
    }
	/**
	 * @return lista con los estados sucesores inmediatos del estado actual en el espacio de estados
	 */
   
	public List<? extends Estado> calculaSucesores()
    {
        List<? extends Estado> result = new ArrayList<>();
        for (int i=0; i<4; i++)//4 comprobaciones
        {
            //Obtener nueva posicion para
            Coordenada rastrOpciones = calcMovimiento(i, this.mapa, posicionActual);//  ##calc
            //¿Está en rango?¿Hay obstáculo?
            //if (enRango(rastrOpciones) && rastrOpciones.esValido(mapa))// ## enRango(9)
            if (rastrOpciones != null) //Si se ha encontrado un estado en rango y que no hay obstáculos
            {
                result.add(new EstadoMalla(this.mapa, rastrOpciones.getX(), rastrOpciones.getY());
            }
        }
        return result;
    }

	/**
	 * @param e2
	 * @return coste del arco que conecta el estado actual con el estado e2
	 */
	public int coste(Estado e2){
        int fila, columna, resultado;
        
        //restar fila actual con el objetivo
        //restar columna actual con el objetivo
        //suma de valores absolutos de la dif de filas y columnas
		
        return 1;
	}

	/**
	 * @return estimaci�n heur�stica del estado actual al objetivo
	 */
	public int h(Estado objetivo){//¿?
        // return this.mapa.getInicio().distancia(objetivo.getMapa().getFin()); ??


        //return abs (posicionActual.getX-mapa.getFin().x)+ abs (posicionActual.getY()-mapa.getFin().y);

		return 0;
    }
	
	/**
	 * Muestra el estado de forma legible por pantalla
	 */
	public void ver();{
        System.out.println(mapa.toString());
    }
	
	/**
	 * Los m�todos equals y hashcode son necesarios para poder utilizar los estados
	 * como clave en un HashMap
	 */
	/* public boolean equals(Object obj){
        return true;
    }

    //Concordancia ccon el equals.
	public int hashCode()
    {

    } */

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapa == null) ? 0 : mapa.hashCode());
		result = prime * result + ((posicionActual == null) ? 0 : posicionActual.hashCode());
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
		EstadoMalla other = (EstadoMalla) obj;
		if (mapa == null) {
			if (other.mapa != null)
				return false;
		} else if (!mapa.equals(other.mapa))
			return false;
		if (posicionActual == null) {
			if (other.posicionActual != null)
				return false;
		} else if (!posicionActual.equals(other.posicionActual))
			return false;
	}

	

    private String toString(){
        return "Estado Mallla(Coordenadas = {"+posicionActual.getX()+", "+posicionActual.getY()"}; "+"G(n) = "+g+" F(n) = "+f")";
    }
			   
    public Malla getMapa()
   {
	return this.mapa;
   }


    //-----------------------------------------------------------------------------------------
    private boolean enRango(int x, int y, Malla map){
        boolean res = false;
        if ((x< map.getNumColumnas()) && x>-1)//fila
            if (y<map.getNumFilas() && y>-1)//columa
                res = true;

        return res;
    }
    private Coordenada calcMovimiento(int mov, Malla map, Coordenada posActual){
        int x = posActual.getX();
        int y = posActual.getY();
        Coordenada result = null;
        switch (mov){
            case 0: // Abajo
                if (enRango(x, y + 1, map) && !map.getTablero()[x][y+1])
                    result = new Coordenada(x, y+1);
                break;
            case 1: // Arriba
                if (enRango(x, y - 1, map) && !map.getTablero()[x][y-1])
                        result = new Coordenada(x, y-1);
                break;
            case 2: // Derecha
                if (enRango(x + 1, y, map) && !map.getTablero()[x+1][y])
                    result = new Coordenada(x + 1, y);
                break;
            case 3: // Izquierda
                if (enRango(x - 1, y, map) && !map.getTablero()[x-1][y])
                    result = new Coordenada(x - 1, y);
                break;
        }
        
        return result;
    }
	
}
