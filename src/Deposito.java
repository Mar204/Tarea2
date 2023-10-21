/**
 * Deposito genera 'depósito genérico' para productos y monedas.
 **/
import java.util.ArrayList;
class Deposito<T> {
    private ArrayList<T> var;
    /**
     * Contructor que inicializa el ArrayList.
     **/
    public Deposito(){
        var = new ArrayList<T>();
    }
    //-----------------------------Add 'n Get-----------------------------------------
    /**
     * Método "getElemento" extrae un elemento de la lista.
     * @return aux entrega el elemento que fue extraido.
     **/
    public T getElemento(){
        if(var.size() <= 0){
            return null;
        }
        else{
            T aux = var.get(0);
            var.remove(0);
            return aux;
        }
    }

    /**
     * Método "addElemento" añade un elemento a la lista.
     * @param n es el nuevo elemento.
     **/
    public void addElemento(T n){
        var.add(n);
    }

    //----------------------------------------------------------------------
}