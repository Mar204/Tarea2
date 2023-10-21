/**
 * Bebida (Abstract) genera el producto  tipo *bebida* y un número de *serie*.
 * Se guarda en depósito del expendedor.
 * Salen 3 clases de Bebida: Cocacola ; Sprite ; Fanta .
 **/

abstract class Bebida extends Productos{
    private int serie;
    public Bebida(int serie){
        super (serie);
        this.serie = serie;
    }
    //..................................................................................

    public int getSerie(){
        return serie;
    }
    public abstract String beber();

    //..................................................................................
}
