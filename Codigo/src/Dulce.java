/**
 * Dulce (Abstract) genera 'producto' de tipo 'dulce' y número de serie.
 * Se guarda en el respectivo depósito.
 * Salen 2 clases de Dulce: Snicker ; Super 8 .
 **/
abstract class Dulce extends Productos{
    private int serie;
    public Dulce(int serie){
        super (serie);
        this.serie = serie;
    }
    //---------------------------------Get chiquito-------------------------------------

    public int getSerie(){
        return serie;
    }
    //----------------------------------------------------------------------------------
    public abstract String comer();
    //----------------------------------------------------------------------------------
}
