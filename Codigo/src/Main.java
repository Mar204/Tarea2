/**
 * @author Martín Rubilar.
 * En base a entregado en PA3P.
 * Se prueba el como deberia funcionar y las 3 'exception' en orden de archivos.
 */
public class Main{
    public static void main(String[] args) throws NoHayProductosException, PagoInsuficienteException, PagoIncorrectoException {
        //------------------------------------------- Caso Base: Correcto funcionamiento ---------------------------------
        Expendedor e1 = new Expendedor(1);
        //Ingresa Dinero
        Moneda m1 = new Moneda1000();
        Comprador c1 = new Comprador(m1, Enumeracion.COCA_COLA, e1);
        System.out.println("Escogiste:" + c1.queBebiste() + "." + "\n Vuelto: $" + c1.cuantoVuelto() + ".\n");
        //------------------------------------------- Caso 21: No hay stock ---------------------------------
        try {
            Expendedor e2 = new Expendedor(0);
            Moneda m2 = new Moneda500();
            Comprador c2 = new Comprador(m2, Enumeracion.FANTA, e2);
            System.out.println("Escogiste: " + c2.queBebiste() + "." + "\nVuelto: $" + c2.cuantoVuelto() + ".\n");
        } catch(Exception NoHayProductoException){
            System.out.println("No hay stock, perdon :(\n");
        }
        //------------------------------------------- Caso 2: Moneda null ---------------------------------
        try {
            Expendedor e3 = new Expendedor(1);
            Moneda m3 = null;
            Comprador c3 = new Comprador(m3, Enumeracion.SNICKER, e3);
            System.out.println("Escogiste: " + c3.queBebiste() + "." + "\nVuelto: $" + c3.cuantoVuelto() + ".\n");
        } catch(Exception PagoIncorrectoException) {
            System.out.println("Pago mal ingreado qwq.\n");
        }
        //------------------------------------------- Caso 3: No alcanza ---------------------------------
        try {
            Expendedor e4 = new Expendedor(2);
            Moneda m4 = new Moneda100();
            Comprador c4 = new Comprador(m4, Enumeracion.SPRITE, e4);
            System.out.println("Escogiste: " + c4.queBebiste() + "." + "\nVuelto: $" + c4.cuantoVuelto() + ".\n");
        } catch(Exception PagoInsuficienteException) {
            System.out.println("No le alcanza :p.\n");
        }
    }
}
