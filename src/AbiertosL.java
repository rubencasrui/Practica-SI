import java.util.ArrayList.*;

public class AbiertosL<E extends Estado> extends Abiertos{
    private ArrayList<NodoAB> listaAbiertos;


    public AbiertosLinear(){
        listaAbiertos = new ArrayList<>();
    }
    /**
	 * @return true si la lista est� vac�a, false en otro caso.
	 */
	public boolean isEmpty()
    {
        return listaAbiertos.isEmpty();
    }

	/**
	 * Inserta el estado e en la lista con el valor f indicado.
	 */
	public void offer(int f, E e)
    {
        int i = 0;
        boolean encontrado = false;
        while(i < listaAbiertos.size() && !encontrado)
        {
            if (listaAbiertos.get(i).getF() > f){
                listaAbiertos.add(i, new NodoAB(f, e));
                encontrado = true;
            }else{
                i++;
            }
            
        }
    }
	
	/**
	 * @return El primer estado de la lista, borr�ndolo de la misma.
	 */
	public E poll()
    {
        E res = listaAbiertos.get(0);
        listaAbiertos.remove(0);
        return res;
    }

	/**
	 * Elimina el estado e de la lista, independientemente de su valor de f
	 */
	public void remove (E e)
    {
        listaAbiertos.remove(e);
    }
		
	/**
	 * @return n�mero de nodos en la lista Abiertos.
	 */
	public int size()
    {
        return listaAbiertos.size();
    }

	/**
	 * Muestra por pantalla de forma legible el contenido de la lista.
	 */
	public void ver()
    {
        System.out.println(Arrays.deepToString(listaAbiertos.toArray()));
    }
}