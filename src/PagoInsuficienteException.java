/**
 * Excepcion 3: No alcanza.
 **/
public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}