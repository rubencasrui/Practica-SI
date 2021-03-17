import java.util.ArrayList;
import java.util.LinkedList;

public class AbiertosLista<E extends Estado> extends Abiertos<E>{
    private ArrayList<E> lista;
    //private LinkedList<E> lista;
    private int size;
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void offer(int f, E e) {

    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void ver() {

    }
}
