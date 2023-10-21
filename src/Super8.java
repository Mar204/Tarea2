/**
 * Super8 genera *dulce* tipo Super8.
 **/
class Super8 extends Dulce{
    /**
     * Constructor de Super8 asigna número de serie.
     **/
    public Super8(int serie){
        super(serie);
    }
    /**
     * @return comer: Entrega el sabor.
     **/
    public String comer(){
        return "Super 8r: \n Sabor 'galleta y chocolate'";
    }
}