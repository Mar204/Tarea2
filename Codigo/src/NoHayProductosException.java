/**
 * Excepcion 1: No hay stock.
 **/
public class NoHayProductosException extends Exception {
    public NoHayProductosException(String mensaje){
        super(mensaje);
    }
}
