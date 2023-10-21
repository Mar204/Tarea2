/**
 * Fanta genera *bebida* tipo Fanta.
 **/
class Fanta extends Bebida{
    /**
     * Constructor de Fanta asigna número de serie.
     **/
    public Fanta(int serie){
        super(serie);
    }
    /**
     * @return beber: Entrega el sabor.
     **/
    public String beber(){
        return "Fanta: \n Sabor 'naranja'";
    }
}
