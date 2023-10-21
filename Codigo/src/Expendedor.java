/**
 * Expendedor muestra el funcionamiento de la máquina expendedora.
 **/
public class Expendedor {

    //----------------------------------------------------------------------

    private Productos producto;
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snicker;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVuelto;

    //----------------------------------------------------------------------
    /**
     * Constructor de Expendedor recibe la cantidad de productos que tendrán las bebidas y dulces de cada tipo.
     * @param numProducto es la cantidad de productos, con ella se inicializan los depositos.
     **/
    public Expendedor(int numProducto){
        //......................................................
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snicker = new Deposito<Dulce>();
        super8 = new Deposito<Dulce>();
        monVuelto = new Deposito<Moneda>();
        //.......................................................

        for(int i = 0; i < numProducto; i++){
            coca.addElemento(new CocaCola(i));
        }
        for(int i = 0; i < numProducto; i++){
            sprite.addElemento(new Sprite(i));
        }
        for(int i = 0; i < numProducto; i++){
            fanta.addElemento(new Fanta(i));
        }
        for(int i = 0; i < numProducto; i++){
            snicker.addElemento(new Snicker(i));
        }
        for(int i = 0; i < numProducto; i++){
            super8.addElemento(new Super8(i));
        }
    }

    //----------------------------------------------------------------------

    /**
     * Método comprarProducto: Realiza compra producto y revisa cada caso.
     * @param moneda moneda ingresada.
     * @param enumeracion tipo de producto.
     * @return devuelve el producto obtenido (bebida/dulce).
     * @throws NoHayProductosException la máquina no tiene producto en stock.
     * @throws PagoInsuficienteException el monto no es suficiente.
     * @throws PagoIncorrectoException moneda null (si trata de comprar sin moneda).
     **/
    public Productos comprarProducto(Moneda moneda, Enumeracion enumeracion) throws NoHayProductosException, PagoInsuficienteException, PagoIncorrectoException {
        if(moneda == null){
            throw new PagoIncorrectoException("Pago incorrecto.");
        }
        int valorMoneda = moneda.getValor();
        if (valorMoneda < enumeracion.getPrecio()) {
            monVuelto.addElemento(moneda);
            throw new PagoInsuficienteException("Pago insuficiente.");
        }

        Bebida be = null;
        Dulce du = null;
        switch (enumeracion) {
            case COCA_COLA:
                be = coca.getElemento();
                break;
            case SPRITE:
                be = sprite.getElemento();
                break;
            case FANTA:
                be = fanta.getElemento();
                break;
            case SNICKER:
                du = snicker.getElemento();
                break;
            case SUPER8:
                du = super8.getElemento();
        }

        if(be != null) {
            if(valorMoneda == enumeracion.getPrecio()){
                producto = be;
                return be;
            }
            else {
                valorMoneda -= enumeracion.getPrecio();
                while (valorMoneda != 0) {
                    monVuelto.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                producto = be;
                return be;
            }
        }
        else if(du != null) {
            if(valorMoneda == enumeracion.getPrecio()){
                producto = du;
                return du;
            }
            else {
                valorMoneda -= enumeracion.getPrecio();
                while (valorMoneda != 0) {
                    monVuelto.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                producto = du;
                return du;
            }
        }
        else{
            monVuelto.addElemento(moneda);
            throw new NoHayProductosException("No hay stock");
        }
    }

    //----------------------------Get chiquito------------------------------------------
    /**
     * @return * getVuelto: Devuelve el vuelto en monedas de $100.
     */
    public Moneda getVuelto(){
        return monVuelto.getElemento();
    }
}
