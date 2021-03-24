import java.util.LinkedList;

public class ArboL<Nodo<E extends Estado>> extends Arbol{
    
    private LinkedList<Nodo<E extends Estado>> lista;
    
    public ArboL(){
        lista = new LinkedList<>();
    }

    public void put(Nodo nodo){
        lista.add(nodo);
    }
	
	public boolean containsKey(E estado){
        return containsKey(estado);
    }
	
	public Nodo get(E estado){
        boolean encontrado = false;
        int i = 0;
        while (i < lista.size() && !encontrado)
        {
            lista.get(i).getEstado().equals(estado) ? encontrado = true : i++;
        }
        return lista.get(i);
    }
	
	public void ver(){		
        for (Nodo<E> l : lista.iterator())
        {
            System.out.println(l.toString());
        }
    }
}