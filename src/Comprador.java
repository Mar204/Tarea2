/**
 * La clase comprador representa al cliente, lo compra en el constructor
 * y despues guarda la cantidad de vuelto y el sonido de el producto que consume.
 */
public class Comprador {
    private String sonido;
    private int vuelto;
    /**
     * El constructor es cuando el comprador compra un producto.
     * Parametros en orden:
     * @param m se le entrega la moneda con la cual va a comprar.
     * @param enumeracion el tipo de producto que el comprador va a tratar de comprar.
     * @param exp la maquina expendedora a la cual tratara de comprarle el producto.
     * @throws NoHayProductosException ocurre cuando a la maquina no le queda el producto que trata de comprar.
     * @throws PagoInsuficienteException la moneda que se inserta no es suficiente para comprar el producto.
     * @throws PagoIncorrectoException se le paso una moneda nula, no hay moneda.
     */
    public Comprador(Moneda m, Enumeracion enumeracion, Expendedor exp) throws NoHayProductosException, PagoInsuficienteException, PagoIncorrectoException {
        Productos producto;
        //----------------------------------------------------------------------
        try{
            producto = exp.comprarProducto(m, enumeracion);

            if (producto != null) {
                m = exp.getVuelto();
                vuelto = 0;
                while (m != null) {
                    vuelto += m.getValor();
                    m = exp.getVuelto();
                }
                if(producto instanceof Bebida){
                    sonido = ((Bebida)producto).beber();
                }
                else if (producto instanceof Dulce){
                    sonido = ((Dulce)producto).comer();
                }
            }else{
                throw new NoHayProductosException("Maquina expendedora no ha podido entregar el producto.");
            }
        }catch (NoHayProductosException e){
            sonido = null;
            producto = null;
            m = exp.getVuelto();
            vuelto = 0;
            while (m != null) {
                vuelto += m.getValor();
                m = exp.getVuelto();
            }
            throw new NoHayProductosException(e.getMessage());
        }catch (PagoInsuficienteException e){
            sonido = null;
            producto = null;
            m = exp.getVuelto();
            vuelto = 0;
            while (m != null) {
                vuelto += m.getValor();
                m = exp.getVuelto();
            }
            throw new PagoInsuficienteException(e.getMessage());
        }catch (PagoIncorrectoException e){
            sonido = null;
            producto = null;
            vuelto = 0;
            throw new PagoIncorrectoException(e.getMessage());
        }

    }
    //----------------------------------------------------------------------
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sonido;
    }
    //----------------------------------------------------------------------
}