import java.util.ArrayList;

public class Ej102 {
    public static void main(String[] args) {
        Expendedor e = new Expendedor(5, 100);
        Moneda m = new Moneda500();
        Comprador c = new Comprador(m, 657, e);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());
    }
}
//-------------------------------------------------------------------
abstract class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        return "sprite";
    }
}
class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }
    public String beber(){
        return "cocacola";
    }
}
//-------------------------------------------------------------------
class Comprador{
    private String sonido;
    private int vuelto;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida bebida = exp.comprarBebida(m, cualBebida);
        vuelto = 0;
        if (bebida != null) {
            m = exp.getVuelto();
            while (m != null) {
                vuelto += m.getValor();
                m = exp.getVuelto();
            }
            sonido = bebida.beber();
        }
        else {
            if(m == null){
                vuelto = 0;
                sonido = null;
            }
            else {
                m = exp.getVuelto();
                while (m != null) {
                    vuelto += m.getValor();
                    m = exp.getVuelto();
                }
                sonido = null;
            }
        }
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sonido;
    }
}
//-------------------------------------------------------------------
class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private int precioBebidas;
    public static final int COCA=1;
    public static final int SPRITE=2;
    public Expendedor(int numBebidas, int precioBebidas){
        this.precioBebidas = precioBebidas;
        coca = new Deposito();
        sprite = new Deposito();
        for(int i = 0; i < numBebidas; i++){
            coca.addBebida(new CocaCola(i));
        }
        for(int i = 0; i < numBebidas; i++){
            sprite.addBebida(new Sprite(i));
        }
        monVu = new DepositoM();
    }
    public Bebida comprarBebida(Moneda m, int cual) {
        if(m == null){
            return null;
        }
        int valorMoneda = m.getValor();
        if (valorMoneda < this.precioBebidas) {
            while(valorMoneda != 0){
                monVu.addMoneda(new Moneda100());
                valorMoneda -= 100;
            }
            return null;
        }
        else{
            if(cual == COCA){
                Bebida b = coca.getBebida();
                if(b != null) {
                    if(valorMoneda == this.precioBebidas){
                        return b;
                    }
                    else {
                        valorMoneda -= this.precioBebidas;
                        while (valorMoneda != 0) {
                            monVu.addMoneda(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return b;
                    }
                }
                else{
                    while(valorMoneda != 0){
                        monVu.addMoneda(new Moneda100());
                        valorMoneda -= 100;
                    }
                    return null;
                }
            }
            else if(cual == SPRITE){
                Bebida b = sprite.getBebida();
                if(b != null) {
                    if(valorMoneda == this.precioBebidas){
                        return b;
                    }
                    else {
                        valorMoneda -= this.precioBebidas;
                        while (valorMoneda != 0) {
                            monVu.addMoneda(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return b;
                    }
                }
                else{
                    while(valorMoneda != 0){
                        monVu.addMoneda(new Moneda100());
                        valorMoneda -= 100;
                    }
                    return null;
                }
            }
            else{
                while(valorMoneda != 0){
                    monVu.addMoneda(new Moneda100());
                    valorMoneda -= 100;
                }
                return null;
            }
        }
    }
    public Moneda getVuelto(){
        return monVu.getMoneda();
    }
}
//-------------------------------------------------------------------
abstract class Moneda{
    public Moneda(){
    }
    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}
class Moneda1500 extends Moneda{
    public Moneda1500(){
        super();
    }
    public int getValor() {
        return 1500;
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}
//-------------------------------------------------------------------
class DepositoM{
    private ArrayList<Moneda> var;
    public DepositoM(){
        var = new ArrayList<Moneda>();
    }
    public void addMoneda(Moneda a){
        var.add(a);
    }
    public Moneda getMoneda(){
        if(var.size() <= 0){
            return null;
        }
        else{
            Moneda aux = var.get(0);
            var.remove(0);
            return aux;
        }
    }
}
//-------------------------------------------------------------------
class Deposito{
    private ArrayList<Bebida> var;
    public Deposito(){
        var = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida a){
        var.add(a);
    }
    public Bebida getBebida(){
        if(var.size() <= 0){
            return null;
        }
        else{
            Bebida aux = var.get(0);
            var.remove(0);
            return aux;
        }
    }
}
//-------------------------------------------------------------------

