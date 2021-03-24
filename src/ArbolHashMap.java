import java.util.HashMap;

public class ArbolHashMap<E extends Estado> extends Arbol{

    private HashMap<Estado, Nodo<E extends Estado>> arbol;

    public ArbolHashMap(){
        arbol = arboHashMap();
    }
    public void put(Nodo nodo)
    {
        arbol.put(nodo.e, nodo);
    }
	
	public boolean containsKey(E estado)
    {
        return(arbol.containsKey(estado));
    }
	
	public Nodo get(E estado)
    {
        return arbol.get(estado);
    }
	
	public void ver()
    {
        StringJoiner sj = new StringJoiner(", ", "Arbol de Busqueda(", ")");
        for (Estado x : arbol.keySet())
        {
            sj.add("Estado{"+x.e+"} <-> Padre{"+arbol.get(x).getPadre()+"}");    
     
        
        return sj.toString();

        }
}