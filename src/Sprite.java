/**
 * Sprite genera *bebida* tipo Sprite.
 **/
class Sprite extends Bebida{
    /**
     * Constructor de Sprite asigna número de serie.
     **/
    public Sprite(int serie){
        super(serie);
    }
    /**
     * @return beber: Entrega el sabor.
     **/
    public String beber(){
        return "Sprite: \n Sabor 'limón'";
    }
}
