import java.util.PriorityQueue.*;
import java.util.Arrays.*;

public class AbiertosPriorityQueue<E extends Estado> extends Abiertos{
    private PriorityQueue<NodoAB> cola;

	public boolean isEmpty()
    {
        return cola.isEmpty();
    }

	/**
	 * Inserta el estado e en la lista con el valor f indicado.
	 */
	public void offer(int f, E e)
    {
        cola.enqueue((new NodeAB(f, e)));
    }
	
	/**
	 * @return El primer estado de la lista, borr�ndolo de la misma.
	 */
	public E poll()
    {
        NodoAB res = cola.first();
        cola.dequeue();
        return res.getEstado();
    }

	/**
	 * Elimina el estado e de la lista, independientemente de su valor de f
	 */
	public void remove(E e)
	{
		cola.remove(e);
	}
		
	/**
	 * @return n�mero de nodos en la lista Abiertos.
	 */
	public int size()
	{
		return cola.size();
	}

	/**
	 * Muestra por pantalla de forma legible el contenido de la lista.
	 */
	public void ver(){
		System.out.println(Arrays.deepToString(cola.toArray()));
	}
}
