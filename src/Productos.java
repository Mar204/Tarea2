/**
 * Producto (abstracta). Salen 2 de tipo producto: Bebidas y Dulces.
 **/
abstract class Productos {
    private int serie;
    public Productos(int serie){
        this.serie = serie;
    }
    /**
     * @return * getSerie: Devuelve el numero de serie.
     */
    public int getSerie(){
        return serie;
    }
}