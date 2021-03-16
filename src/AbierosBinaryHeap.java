import dataStructures.priorityQueue;

public AbiertosBinaryHeap<NodoAB> extends Abiertos<NodoAB>{
    private BinaryHeapPriorityQueue<NodoAB> cola;
    private int size;


    /**
	 * @return true si la lista est� vac�a, false en otro caso.
	 */
	public abstract boolean isEmpty()
    {
        return cola.isEmpty && size == 0;
    }

	/**
	 * Inserta el estado e en la lista con el valor f indicado.
	 */
	public abstract void offer(int f, E e)
    {
        cola.enqueue(new NodeAB(f, e));
    }
	
	/**
	 * @return El primer estado de la lista, borr�ndolo de la misma.
	 */
	public abstract E poll()
    {
        NodeAB res = new NodeAB(cola.first().f, cola.first().e);
        cola.dequeue();
        return res;
    }

	/**
	 * Elimina el estado e de la lista, independientemente de su valor de f
	 */
	public abstract void remove (E e);
		
	/**
	 * @return n�mero de nodos en la lista Abiertos.
	 */
	public abstract int size();

	/**
	 * Muestra por pantalla de forma legible el contenido de la lista.
	 */
	public abstract void ver();
}