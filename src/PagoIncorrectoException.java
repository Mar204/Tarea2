/**
 * Excepcion 2: Moneda null.
 **/
public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
