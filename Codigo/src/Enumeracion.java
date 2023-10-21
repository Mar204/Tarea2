/**
 *Enumeracion asigna número identificador y un precio a cada *producto*.
 **/
public enum Enumeracion {

    //----------------------------------------------------------------------
    COCA_COLA(1, 1000),
    SPRITE(2, 800),
    FANTA(3, 900),
    SNICKER(4, 700),
    SUPER8(5, 300);
    private final int tipo;
    private final int precio;

    //----------------------------------------------------------------------
    /**
     * El constructor recibe el tipo y precio del producto.
     * @param tipo identificador del producto.
     * @param precio precio del producto.
     **/
    Enumeracion(int tipo, int precio){
        this.tipo = tipo;
        this.precio = precio;
    }
    /**
     * Método getPrecio:
     * @return retorna precio producto.
     **/
    public int getPrecio(){
        return precio;
    }

    /**
     * Método getTipo:
     * @return retorna tipo producto.
     **/
    public int getTipo(){
        return tipo;
    }

}
