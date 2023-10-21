/**
 * CocaCola genera *bebida* tipo Coca-Cola.
 * */
class CocaCola extends Bebida{
    /**
     * Constructor de CocaCola asigna número de serie.
     * */
    public CocaCola(int serie){
        super(serie);
    }
    /**
     * @return beber: Entrega el sabor.
     * */
    public String beber(){
        return "CocaCola: \n Sabor 'cola'";
    }
}
