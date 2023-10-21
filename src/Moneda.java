/**
 * Moneda (abstracta) genera las monedas que se pueden utilizar.
 * Salen 4 valores: $100, $500, $1000 y $1500.
 **/
abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){
    }

    public Moneda getSerie(){
        return this;
    }
    /**
     * compareTo:Se comparan las monedas.
     * @param moneda moneda a comparar.
     * @return negativo si es mayor, positivo si es menor y 0 si son iguales.
     */
    @Override
    public int compareTo(Moneda moneda){
        return this.getValor()-moneda.getValor();
    }

    public abstract int getValor();
}